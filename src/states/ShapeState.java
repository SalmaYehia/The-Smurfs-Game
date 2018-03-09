package states;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public interface ShapeState {

    abstract public float setSlope(double screenWidth, double screenheight);

    abstract public double increaseSlopedY(double oldY, float slope, double width);

    abstract public String getstate();

    abstract public void move(Shape shape, GraphicsContext gc, double shapeSpeed, double width, double fallingSpeed);
}