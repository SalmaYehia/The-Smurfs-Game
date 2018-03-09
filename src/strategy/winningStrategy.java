package strategy;

import controller.gameController;

public interface winningStrategy {

	public boolean detectEndGame(gameController controller);
	
}
