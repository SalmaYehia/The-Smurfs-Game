package controller;

import java.util.ArrayList;
import java.util.LinkedList;

import factories.imageFactory;
import iterator.CreateIterator;
import iterator.Iterator;
import iterator.PlayerIterator;
import iterator.Shapeiterator;
import iterator.ShapeiteratorArray;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import layouts.Game;
import logs.Logs;
import player.Player;
import shape.Shape;
import shape.block;
import shape.shapeInt;
import shape.shapePool;
import snapshot.Snapshot;
import states.Caught;
import states.PlayerStack;
import strategy.difficultGame;
import strategy.easyGame;
import strategy.gameStrategy;
import strategy.mediumGame;
import strategy.scoreStrategy;
import strategy.timerStrategy;
import strategy.winningStrategy;

public class gameController implements Runnable, CreateIterator {
	private final double characterHeight = 330;
	private final double characterWidth = 100;
	private final int KEYBOARD_MOVEMENT = 70;
	private GraphicsContext gc;
	private AnimationTimer drawingThread;
	private ArrayList<Shape> fallingShapes;
	public static shapePool pool;
	private imageFactory imgFactory;
	private TimerThread timer;
	private LinkedList<Player> players;
	private gameOptions gameOptions;
	private winningStrategy winningStrategy;
	private gameStrategy gameStrategy;
	private Group root;
	private Label timerLabel;
	private double shapeSpeed;
	private double fallingSpeed = 1;
	private int minutesTimer;
	private int SecondsTimer;
	private double width;
	private double height;
	private int counter;
	private Label score1;
	private Label score2;
	private int shapesDensity;

	public gameController(Game game, Snapshot snapshot) {
		setGameParameters(game);
		this.gameOptions = snapshot.getOptions();
		fallingShapes = snapshot.getShapes();
		counter = snapshot.getCounter();
		minutesTimer = snapshot.getMinutes();
		SecondsTimer = snapshot.getSeconds();
		imgFactory = imageFactory.getImageFactory();
		pool = shapePool.getPoolInstance();
		players = new LinkedList<Player>();
		setPlayers(snapshot.getPlayers());
		setWinningStrategy(snapshot.getOptions());
		setGameStrategy(snapshot.getOptions());
	}

	public gameController(Game game, gameOptions gameOptions) {
		setGameParameters(game);
		this.gameOptions = gameOptions;
		imgFactory = imageFactory.getImageFactory();
		pool = shapePool.getPoolInstance();
		fallingShapes = new ArrayList<Shape>();
		players = new LinkedList<Player>();
		counter = 0;
		setPlayers();
		setWinningStrategy(gameOptions);
		setGameStrategy(gameOptions);
	}

	private void setGameParameters(Game game) {
		this.gc = game.getGraphicContext();
		this.width = game.getWidth();
		this.height = game.getHeight();
		this.root = game.getRoot();
		this.timerLabel = game.getTimerLabel();
		this.score1 = game.getScore1Label();
		this.score2 = game.getScore2Label();
	}

	private void setWinningStrategy(gameOptions options) {
		if (options.getWinningStrategy() == "timer") {
			winningStrategy = new timerStrategy(options.getMaxTime());
		} else if (options.getWinningStrategy() == "score") {
			winningStrategy = new scoreStrategy(options.getMaxScore());
		}
	}

	private void setGameStrategy(gameOptions options) {
		if (options.getGameStrategy().equals("easy")) {
			System.out.println("jgfvihgvio");
			gameStrategy = new easyGame(this);
		} else if (options.getGameStrategy().equals("medium")) {
			gameStrategy = new mediumGame(this);
		} else if (options.getGameStrategy().equals("difficult")) {
			gameStrategy = new difficultGame(this);
		}
		fallingSpeed = gameStrategy.getFallingSpeed();
		shapesDensity = gameStrategy.getShapesDensity();
	}

	@Override
	public void run() {
		setGameSpeed();
		setFallingPlates();
		startGameTimer();
	}

	private void setGameSpeed() {
		shapeSpeed = gameOptions.getGameSpeed();
	}

	private void setFallingPlates() {
		drawingThread = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				draw();
			}
		};
		drawingThread.start();
	}

	private void changeText() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				score1.setText("SMURF" + "\n     " + players.get(1).getScore());
				score2.setText("SMURFETTE" + "\n          " + players.get(0).getScore());
			}
		});
	}

	private void draw() {
		gc.clearRect(0, 0, width, height);
		counter++;
		gameStrategy.manageBlocks();
		if (counter % shapesDensity == 0) {
			fallingShapes.add(pool.borrowObject(width, height));
			counter = 0;
		}
		for (int i = 0; i < fallingShapes.size(); i++) {
			if (fallingShapes.get(i).getY() >= height) {
				pool.returnObject(fallingShapes.get(i));
				fallingShapes.remove(i);
				i--;
			} else {
				fallingShapes.get(i).move(gc, shapeSpeed, width, fallingSpeed);
			}
			if (players.size() == 2 && i > 0) {
				catchDetection(i);
				changeText();
				//
			}
		}
		//////////////////////////// iterator
		Iterator k = this.cteateIterator(players);
		if (players.size() == 2)
			while (k.hasNext()) {
				for (PlayerStack crnt : ((Player) k.Next()).Stacks) {
					for (shapeInt x : crnt.stack)
						x.drawShape(gc);
				}
			}

		checkGameEnd();
	}

	private void checkGameEnd() {
		if (winningStrategy.detectEndGame(this)) {
			EndGame();
		}
	}

	private void EndGame() {
		int score1 = players.get(0).getScore();
		int score2 = players.get(1).getScore();

		if (score1 == score2) {
			EndGame("Draw");
		} else if (score1 > score2) {
			EndGame("Player one wins");
		} else if (score1 < score2) {
			EndGame("Player two wins");
		}
	}

	private void EndGame(String winner) {
		System.out.println("end game");
		timer.stopTimer();
		drawingThread.stop();
		eventHandler.getInstance().EndGame(winner);
	}

	private void catchDetection(int obj) {
		Shape object = fallingShapes.get(obj);
		for (int i = 0; i < 2; i++) {
			PlayerStack S1 = players.get(i).Stacks.get(0);
			if (!S1.isblocked()) {
				catchDetection(S1, obj, object, i);
			}
			PlayerStack S2 = players.get(i).Stacks.get(1);
			if (!S2.isblocked()) {
				catchDetection(S2, obj, object, i, characterWidth);
			}
		}
	}

	private void catchDetection(PlayerStack s, int index, Shape object, int playerIndx) {
		if (object.getY() == height - s.getHight()
				&& Math.abs(object.centerX() - players.get(playerIndx).getX()) < 15) {
			s.add(object);
			fallingShapes.remove(index);
			object.setState(Caught.getCaughtInstance());
			if (object instanceof block) {
				s.blockStack();
				checkStacksBlocked(playerIndx);
			}
		}
	}

	private void catchDetection(PlayerStack s, int index, Shape object, int playerIndx, double characterWidth) {
		if (object.getY() == height - s.getHight()
				&& Math.abs(object.centerX() - 100 - characterWidth - players.get(playerIndx).getX()) < 15) {
			s.add(object);
			fallingShapes.remove(index);
			object.setState(Caught.getCaughtInstance());
			if (object instanceof block) {
				s.blockStack();
				checkStacksBlocked(playerIndx);
			}
		}
	}

	private void checkStacksBlocked(int index) {
		if (players.get(index).getStacks().get(0).isblocked()) {
			if (players.get(index).getStacks().get(1).isblocked()) {
				if (index == 0) {
					EndGame("player two wins");
				} else if (index == 1) {
					EndGame("player one wins");
				}
			}
		}
	}

	private void setPlayers(LinkedList<Player> players) {
		this.players = players;
		Player player;
		System.out.println("show players");
		for (int i = 0; i < players.size(); i++) {
			player = this.players.get(i);
			System.out.println(player.getImageView());
			root.getChildren().add(player.getImageView());
			System.out.println("show player " + i + 1);
		}
	}

	private void setPlayers() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				int n = gameOptions.getNPlayers();
				boolean mouseCntrl;
				Image img;
				for (int i = 0; i < n; i++) {
					System.out.println("setplayer" + i + 1);
					mouseCntrl = gameOptions.getMouseControl(i);
					img = imgFactory.getImage(gameOptions.getCharacter(i));
					Player player = new Player(img, mouseCntrl);
					if (!mouseCntrl) {
						player.setLeftButton(gameOptions.getLeftButton(i));
						player.setRightButton(gameOptions.getrightButton(i));
					}
					player.setX(gameOptions.getPositionX(i));
					player.setY(height - characterHeight);
					root.getChildren().add(player.getImageView());
					players.add(player);
				}
			}
		});
	}

	public void notifyMouseMoved(double x) {
		Player p;
		for (int i = 0; i < players.size(); i++) {
			p = players.get(i);
			if (p.getMouseControl()) {
				p.setX(x);
			}
		}
	}

	public void notifyKeyPressed(KeyCode key) {
		Player p;
		for (int i = 0; i < players.size(); i++) {
			p = players.get(i);
			if (!p.getMouseControl()) {
				if (p.getrightButton() == key) {
					if (p.getX() < width - characterWidth) {
						p.MoveByKey(KEYBOARD_MOVEMENT);
					}
				} else if (p.getLeftButton() == key) {
					if (p.getX() > 0) {
						p.MoveByKey(-1 * KEYBOARD_MOVEMENT);
					}
				}
			}
		}
	}

	private void startGameTimer() {
		timer = new TimerThread(timerLabel, minutesTimer, SecondsTimer);
		Thread t = new Thread(timer);
		t.start();
	}

	public int getTimerMin() {
		return timer.getMin();
	}

	// stop running threads
	public Snapshot pause() {
		timer.stopTimer();
		drawingThread.stop();
		Logs.log("Snapshot abject is created", "info");
		Snapshot snapshot = new Snapshot(fallingShapes, gameOptions, players, timer.getMin(), timer.getsec(), counter);
		return snapshot;
	}

	public void setGameSpeed(double speed) {
		shapeSpeed = speed;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Shape> getFallingShapes() {
		return fallingShapes;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public GraphicsContext getGraphics() {
		return gc;
	}

	@Override
	public Iterator cteateIterator(LinkedList<Player> player) {

		return new PlayerIterator(player);
	}

	@Override
	public Iterator cteateIterator(ArrayList<Shape> shape) {

		return new Shapeiterator(shape);
	}

	@Override
	public Iterator cteateIterator(Shape[] shape) {

		return new ShapeiteratorArray(shape);
	}

}