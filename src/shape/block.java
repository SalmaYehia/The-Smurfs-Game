package shape;

import factories.imageFactory;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import states.FallingFromLeft;

public class block extends Shape {

	private Image image;
	private GraphicsContext gc;


	public block(double width, double heightt, GraphicsContext gc) {
		image = imageFactory.getImageFactory().getImage("rock", 55, 55);
		this.gc = gc;

		setY(100);

		setState(FallingFromLeft.getFallingFromLeftInstance());
		setX(0);

		setSlope(width, heightt);
		type = 3;

	}

	public block() {
		image = imageFactory.getImageFactory().getImage("rock", 55, 55);

		setY(100);

		setState(FallingFromLeft.getFallingFromLeftInstance());
		setX(0);

		setSlope(133, 1362);
		type = 3;

	}

	@Override
	public double centerX() {
		return x + 25;
	}

	@Override
	public double centerY() {
		return y + 55;
	}

	@Override
	public void setX(double x) {
		this.x = x ;
	}

	@Override
	public void setY(double y) {
		this.y = y ;
	}

	@Override
	public void drawShape(GraphicsContext gc) {
		gc.drawImage(image, x - 25, y - 30);
	}


}
