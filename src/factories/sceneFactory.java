package factories;


import javafx.scene.Scene;
import layouts.EndGame;
import layouts.Game;
import layouts.Instructions;
import layouts.Pause;
import layouts.Start;
import layouts.layout;

public class sceneFactory {

	private static sceneFactory sceneFactory;

	private sceneFactory() {

	}

	public static sceneFactory getSceneFactory() {
		if (sceneFactory == null) {
			return sceneFactory = new sceneFactory();
		}

		return sceneFactory;
	}

	public Scene getScene(String name, double Height, double Width) {

		layout scene;

		switch (name) {
		case "Game":
			scene =  new Game(Height, Width);break;
		case "MainMenu":
			scene =  new Start(Height, Width);break;
		case "pause":
			scene =  new Pause(Height, Width);break;
//		case "MainOptions":
//			scene =  new mainOptions(Height, Width);break;
		case "Instructions":
			scene =  new Instructions(Height, Width);break;
		case "EndGame":
			scene =  new EndGame(Height, Width);break;
		default:
			return null;
		}

		return scene.getScene();

	}
}
