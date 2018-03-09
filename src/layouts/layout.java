package layouts;

import controller.eventHandler;
import factories.buttonFactory;
import factories.imageFactory;
import javafx.scene.Scene;

public abstract class layout {

	protected double windowHeight;
	protected double windowWidth;
	protected Scene scene;
	protected buttonFactory factory;
	protected imageFactory imgFactory;

	public eventHandler handler = eventHandler.getInstance();
	public layout(double height, double width) {
		windowHeight = height;
		windowWidth = width;
		factory = buttonFactory.getButtonFactory();
		imgFactory = imageFactory.getImageFactory();
	}

	public Scene getScene() {
		return scene;
	}
}
