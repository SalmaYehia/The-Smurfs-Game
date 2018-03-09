package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class loadGameButton extends button {

	@Override
	public void setName() {
		File file = new File("src\\images\\LOADGAME.png");
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);
	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				handler.loadGame();
			}
		});
	}
}
