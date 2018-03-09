package strategy;

import controller.gameController;
import logs.Logs;

public class scoreStrategy implements winningStrategy {

    private int maxScore;

    public scoreStrategy(int maxScore) {
        System.out.println("score strategy");
        this.maxScore = maxScore;
    }

    @Override
    public boolean detectEndGame(gameController controller) {
        if (controller.getPlayers().size() == 2) {
            int score1 = controller.getPlayers().get(0).getScore();
            int score2 = controller.getPlayers().get(1).getScore();

            if (score1 == maxScore || score2 == maxScore) {
                Logs.log("game has ended", "info");
                return true;
            }
        }
        return false;
    }

}
