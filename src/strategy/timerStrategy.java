package strategy;

import controller.gameController;
import logs.Logs;

public class timerStrategy implements winningStrategy {

	public int minutes;

	public timerStrategy(int minutes) {
		System.out.println("time strategy");
		this.minutes = minutes;
	}

	@Override
	public boolean detectEndGame(gameController controller) {
		int timer = controller.getTimerMin();
		System.out.println("strategy " + timer + " " + minutes);
		if (timer >= minutes) {
		    Logs.log("game has ended", "info");
			return true;
		}
		return false;
	}

}
