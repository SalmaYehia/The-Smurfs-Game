package strategy;

import controller.gameController;

public class easyGame implements gameStrategy {


	private final double fallingSpeed = 1;
	
	public easyGame(gameController game) {
	}
	
	@Override
	public void manageBlocks() {
		//null object
	}

	@Override
	public double getFallingSpeed() {
		return fallingSpeed;
	}

	@Override
	public int getShapesDensity() {
		return 30;
	}

}
