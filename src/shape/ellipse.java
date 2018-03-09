package shape;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import states.Stored;

public class ellipse extends Shape implements Serializable, shapeInt {
	private Ellipse ellipseShape;

	public ellipse() {
		Color c = colors[randomize.nextInt(colors.length)];
		this.color = c;
		ellipseShape = new Ellipse();
		ellipseShape.setCenterY(10.0);
		ellipseShape.setCenterX(10.0);
		ellipseShape.setRadiusX(60.0);
		ellipseShape.setRadiusY(15.0);
		ellipseShape.setFill(color);
		this.state = Stored.getStoredInstance();
		this.height = 28.0f;
		type = 1;
	}

	@Override
	public void drawShape(GraphicsContext gc) {
		gc.setFill(this.color);
		gc.fillOval(x - 25, y - 10.0, 60.0, 25.0f);
	}

	@Override
	public void setX(double x) {
		this.x = x;
		this.ellipseShape.setCenterX(x);
	}

	@Override
	public void setY(double y) {
		this.y = y;
		this.ellipseShape.setCenterY(y);
	}

	@Override
	public double centerX() {
		return getX();
	}

	@Override
	public double centerY() {
		return getY();
	}

}