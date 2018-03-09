package factories;

import java.io.File;

import javafx.scene.image.Image;

public class imageFactory {

	private static imageFactory imgFactory;

	private imageFactory() {

	}

	public static imageFactory getImageFactory() {

		if (imgFactory == null) {
			return imgFactory = new imageFactory();
		}

		return imgFactory;
	}

	public Image getImage(String name, double width, double height) {
		File file = getFile(name);
		return new Image(file.toURI().toString(), width, height, false, true);

	}

	public Image getImage(String name) {
		File file = getFile(name);
		return new Image(file.toURI().toString());
	}

	private File getFile(String name) {
		switch (name) {
		case "background":
			return new File("src\\images\\back2.png");
		case "smurfette":
            return new File("src\\images\\2.png");
        case "smurff":
            return new File("src\\images\\1.png");
		case "mainMenu":
			return new File("src\\images\\mainMenu.jpg");
		case "howTo":
		    return new File("src\\images\\HowTo.png");
		case "pause":
            return new File("src\\images\\pause.jpg");
		case "rock":
			return new File("src\\images\\ROCK.png");
		case "end":
            return new File("src\\images\\endGame.jpg");
		case "mainOptions":
		    return new File("src\\images\\MainOptions.jpg");
		default:
			return null;
		}
	}

}
