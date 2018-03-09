package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class Caught implements ShapeState{

    private static Caught caught = null;

    public static Caught getCaughtInstance() {
        if (caught == null)
            return caught = new Caught();
        return caught;
    }

    @Override
    public float setSlope(double screenWidth, double screenheight) {
        return 0;
    }

    @Override
    public double increaseSlopedY(double oldY, float slope, double width) {
        return 0;
    }

    @Override
    public String getstate() {
        return "caught";
    }

    @Override
    public void move(Shape shape, GraphicsContext gc, double shapeSpeed, double width, double fallingSpeed) {

    }
    public void move(Shape shape, double x) {
       shape.setX(x);
    }
}
