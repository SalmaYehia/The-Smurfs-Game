package factories;

import button.ContinueGameButton;
import button.EasyButton;
import button.GameOptionsButton;
import button.HardButton;
import button.MainMenuButton;
import button.MediumButton;
import button.ReturnToPause;
import button.SaveGameButton;
import button.button;
import button.exitButton;
import button.instructionsButton;
import button.loadGameButton;
import button.musicButton;
import button.newGameButton;

public class buttonFactory {

	private static buttonFactory btnFactory;

	private buttonFactory() {

	}

	public static buttonFactory getButtonFactory() {

		if (btnFactory == null) {
			return btnFactory = new buttonFactory();
		}

		return btnFactory;
	}

	public button getButton(String type) {

		switch (type) {
		case "New Game":
			return new newGameButton();
		case "Load Game":
			return new loadGameButton();
		case "Instructions":
			return new instructionsButton();
		case "Exit":
			return new exitButton();
//		case "Main Options":
//			return new mainOptionsButton();
		case "Continue Game":
			return new ContinueGameButton();
		case "Main Menu":
			return new MainMenuButton();
		case "Game Options Return":
			return new ReturnToPause();
		case "Game Options":
			return new GameOptionsButton();
		case "save":
			return new SaveGameButton();
		case "music":
			return new musicButton();
		case "easy":
		    return new EasyButton();
		case "medium":
            return new MediumButton();
		case "hard":
            return new HardButton();

		default:
			return null;
		}
	}

}
