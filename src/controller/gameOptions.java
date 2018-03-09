package controller;

import java.util.LinkedList;

import javafx.scene.input.KeyCode;

public class gameOptions {

	private LinkedList<String> characters;
	private LinkedList<Boolean> mouseControl;
	private LinkedList<KeyCode> rightButton;
	private LinkedList<KeyCode> leftButton;
	private LinkedList<Double> startPositionX;
	private String winningStrategy;
	private String gameStrategy;
	private static final int Players = 2;
	private double shapeSpeed;
	private int maxTime;
	private int maxScore;

	public gameOptions() {
		shapeSpeed = 4.0;
		setWinningStrategy("score"); // score , timer
		setGameStrategy("easy");// easy , medium , difficult
		setMaxTime(1);////// 1 min
		setMaxScore(10);
		characters = new LinkedList<String>();
		mouseControl = new LinkedList<Boolean>();
		rightButton = new LinkedList<KeyCode>();
		leftButton = new LinkedList<KeyCode>();
		startPositionX = new LinkedList<Double>();
		setDefaultOptions();
	}

	public int getNPlayers() {
		return Players;
	}

	private void setDefaultOptions() {
		// player1
		characters.add("smurff");
		mouseControl.add(true);
		rightButton.add(null);
		leftButton.add(null);
		startPositionX.add(0.0);

		// player2
		characters.add("smurfette");
		mouseControl.add(false);
		rightButton.add(KeyCode.RIGHT);
		leftButton.add(KeyCode.LEFT);
		startPositionX.add(1000.0);
	}

	public void setPlayer1Mouse() {
		mouseControl.add(0, true);
		mouseControl.add(1, false);
		rightButton.add(0, null);
		leftButton.add(0, null);
		rightButton.add(1, KeyCode.RIGHT);
		leftButton.add(1, KeyCode.LEFT);

	}

	public void setPlayer2Mouse() {
		mouseControl.add(1, true);
		mouseControl.add(0, false);
		rightButton.add(1, null);
		leftButton.add(1, null);
		rightButton.add(0, KeyCode.RIGHT);
		leftButton.add(0, KeyCode.LEFT);

	}

	public String getCharacter(int playerIndex) {
		return characters.get(playerIndex);
	}

	public boolean getMouseControl(int playerIndex) {
		return mouseControl.get(playerIndex);
	}

	public KeyCode getLeftButton(int playerIndex) {
		return leftButton.get(playerIndex);
	}

	public KeyCode getrightButton(int playerIndex) {
		return rightButton.get(playerIndex);
	}

	public Double getPositionX(int playerIndex) {
		return startPositionX.get(playerIndex);
	}

	public void setGameSpeed(double x) {
		shapeSpeed = x;
	}

	public double getGameSpeed() {
		return shapeSpeed;
	}

	public String getWinningStrategy() {
		return winningStrategy;
	}

	public void setWinningStrategy(String winningStrategy) {
		this.winningStrategy = winningStrategy;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public String getGameStrategy() {
		return gameStrategy;
	}

	public void setGameStrategy(String gameStrategy) {
		this.gameStrategy = gameStrategy;
	}
}
