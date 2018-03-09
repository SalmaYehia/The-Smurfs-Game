package states;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class FallingFromLeft implements ShapeState {
	private static FallingFromLeft fallingFromLeft = null;
	private Random randomize = new Random();

	private FallingFromLeft() {

	}

	public static FallingFromLeft getFallingFromLeftInstance() {

		if (fallingFromLeft == null) {
			return fallingFromLeft = new FallingFromLeft();
		}

		return fallingFromLeft;
	}

	@Override
	public void move(Shape shape, GraphicsContext gc, double shapeSpeed,double width, double fallingSpeed) {
		// TODO Auto-generated method stub
		if (shape.getX() < 250) {

			shape.setX(shape.getX() + shapeSpeed); // controls speed
			shape.drawShape(gc);
		} else {

			shape.increaseSlopedY(width, fallingSpeed);
			shape.drawShape(gc);
		}
	}

	@Override
	public float setSlope(double screenWidth, double screenheight) {
		// TODO Auto-generated method stub
		float r = (randomize.nextInt((int) screenWidth));
		float slope = (float) (screenheight - 100) / (r - 250);
		return (slope > 0) ? slope : -slope;

	}

	@Override
	public double increaseSlopedY(double oldY, float slope,double width) {
		// TODO Auto-generated method stub
		return (oldY - ((100) - (slope * 250))) / slope;
	}

	@Override
	public String getstate() {

		return "left";
	}

}
