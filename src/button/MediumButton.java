package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MediumButton extends button{

    @Override
    public void setName() {
        File file = new File("src\\images\\MEDIUM.png");
        Image img = new Image(file.toURI().toString());
        image = new ImageView(img);

    }

    @Override
    protected void setStyle() {
        image.setFitHeight(40);
        image.setFitWidth(100);
        b.setGraphic(image);
        b.setStyle("-fx-background-color:#ffb833;" + "-fx-background-radius: 10;" + "-fx-padding: 5 5 5 5");
    }

    @Override
    public void setAction() {
    	b.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                handler.setLevel("medium");
                handler.NewGame();
            }
        });

    }

}
