package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class newGameButton extends button {

    @Override
    public void setAction() {
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                handler.NewGame();
            }
        });
    }

    @Override
    public void setName() {
        File file = new File("src\\images\\NEWGAME.png");
        Image img = new Image(file.toURI().toString());
        image = new ImageView(img);
    }

}
