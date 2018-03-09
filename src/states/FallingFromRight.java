package states;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import shape.Shape;

public class FallingFromRight implements ShapeState {
	private static FallingFromRight fallingFromRight = null;
	private Random randomize = new Random();

	private FallingFromRight() {

	}

	public static FallingFromRight getFallingFromRightInstance() {

		if (fallingFromRight == null) {
			return fallingFromRight = new FallingFromRight();
		}

		return fallingFromRight;

	}



	@Override
	public void move(Shape shape, GraphicsContext gc, double shapeSpeed,double width, double fallingSpeed) {
		// TODO Auto-generated method stub

		if (shape.getX() > (width-250) ) {

			shape.setX(shape.getX() - shapeSpeed); // controls speed
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

		float slope = (float) (screenheight - (100)) / (float)(r - (screenWidth-250)) ;

		 return (slope < 0 )?  slope :  -slope ;

	}

	@Override
	public double increaseSlopedY(double oldY, float slope,double width) {
		// TODO Auto-generated method stub
		return 	(oldY- ((100)-(slope*(width-250))))/ slope;

	}

	@Override
	public String getstate() {

		return "right";
	}

}
