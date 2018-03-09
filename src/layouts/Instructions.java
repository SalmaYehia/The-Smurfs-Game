package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import logs.Logs;

public class Instructions extends layout {

    private Group root = new Group();

    public Instructions(double height, double width) {
        super(height, width);
        addBackground();
        addButton();
        scene = new Scene(root, windowWidth, windowHeight);
    }

    private void addButton() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(windowHeight - 150, windowWidth / 2 - 70, 100, windowWidth / 2 - 140));
        vBox.getChildren().add(factory.getButton("Main Menu").getButton());
        root.getChildren().add(vBox);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
    }

    private void addBackground() {
        Logs.log("Instruction background added", "debug");
        Image background = imgFactory.getImage("howTo", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
    }

}
