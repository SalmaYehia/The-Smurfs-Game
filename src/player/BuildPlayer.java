package player;

import factories.imageFactory;

public class BuildPlayer {

    public Player create(PlayerProxy r) {
        Player t = null;
        if (r.type == 0) {
            t = new Player(imageFactory.getImageFactory().getImage("smurff"), r.isMouseControl());
        } else if (r.type == 1) {
            t = new Player(imageFactory.getImageFactory().getImage("smurfette"), r.isMouseControl());
        }
        t.setLeftButton(r.getLeftButton());
        t.setRightButton(r.getRightButton());
        t.setX(r.getPositionX());
        t.setY(r.getPositionY());
        t.score = r.score;
        return t;
    }
}