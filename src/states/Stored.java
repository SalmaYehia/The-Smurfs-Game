package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class Stored implements ShapeState {

    private static Stored stored = null;

    private Stored() {

    }

    public static Stored getStoredInstance() {
        if (stored == null)
            return stored = new Stored();
        return stored;
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
        return "stored";
    }

    @Override
    public void move(Shape shape, GraphicsContext gc, double shapeSpeed, double width, double fallingSpeed) {

    }

}
