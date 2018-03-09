package layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Pause extends layout {

    private Group root = new Group();
    private static final String[] BUTTONS = { "Continue Game", "save", "Main Menu"};

    public Pause(double height, double width) {
        super(height, width);
        addBackground();
        addButton();
        scene = new Scene(root, windowWidth, windowHeight);
    }

    private void addButton() {
        VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(windowHeight *.25 , windowWidth *.5, 150,
         windowWidth / 2 - 150));
        for (String crnt : BUTTONS)
            vbox.getChildren().add(factory.getButton(crnt).getButton());
        root.getChildren().add(vbox);
        vbox.setAlignment(Pos.CENTER);
    }

    private void addBackground() {
        Image background = imgFactory.getImage("pause", windowWidth, windowHeight);
        ImageView img = new ImageView(background);
        root.getChildren().add(img);
    }
}
