package player;

public class BuildPlayerProxy {

    public PlayerProxy create(Player r, int type) {
        PlayerProxy u = new PlayerProxy(r.getX(), r.getY(), r.getMouseControl(), r.getLeftButton(), r.getrightButton(),
                r.score, r.PH);
        u.type = type;
        return u;
    }
}