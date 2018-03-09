package strategy;

import java.util.Random;

import controller.gameController;
import shape.block;

public class difficultGame implements gameStrategy {

	private gameController game;
	private final double fallingSpeed = 2;
	private int counter;

	public difficultGame(gameController game) {
		this.game = game;
		counter = 0;
	}

	@Override
	public void manageBlocks() {
		System.out.println(counter);
		counter++;
		if (counter == 30) {
			counter = 0;
			if (new Random().nextInt(100) % 3 == 0) {
				game.getFallingShapes().add(
						new block(game.getWidth(), game.getHeight(), game.getGraphics()));
			}
		}
	}

	@Override
	public double getFallingSpeed() {
		return fallingSpeed;
	}

	@Override
	public int getShapesDensity() {
		return 10;
	}

}
