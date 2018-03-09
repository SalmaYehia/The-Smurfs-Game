package layouts;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logs.Logs;

public class Game extends layout {

    private GraphicsContext gc;
    private Group root;
    private Label timer;
    private Label score1;
    private Label score2;

    public Game(double height, double width) {
        super(height, width);
        Group root = setLayout();
        setMusicButton();
        timer = new Label();
        timer.setTextFill(Color.web("#FFCA28"));
        timer.setFont(Font.font("Cambria", FontWeight.BOLD, 60));
        timer.setLayoutX(width - 800);
        root.getChildren().add(timer);

        score1 = new Label();
        score1.setTextFill(Color.web("#FFCA28"));
        score1.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
        score1.setLayoutX(width - 1350);
        root.getChildren().add(score1);

        score2 = new Label();
        score2.setTextFill(Color.web("#FFCA28"));
        score2.setFont(Font.font("Cambria", FontWeight.BOLD, 40));
        score2.setLayoutX(width - 250);
        root.getChildren().add(score2);
        scene = new Scene(root, windowWidth, windowHeight);
        setKeyPress();
        setMouseMovement();
    }



    private void setMusicButton() {
        Button music = factory.getButton("music").getButton();
        music.setAlignment(Pos.TOP_LEFT);
        VBox v = new VBox();
        v.getChildren().add(music);
        v.setPadding(new Insets(30, 0, 0, 50));
        root.getChildren().add(v);
        Logs.log("Music button is set", "debug");
    }

    public Label getScore1Label() {
        return score1;
    }

    public Label getScore2Label() {
        return score2;
    }

    public Label getTimerLabel() {
        return timer;
    }

    private Group setLayout() {
        Image background = imgFactory.getImage("background");
        ImageView img = new ImageView(background);
        img.setPreserveRatio(true);
        img.setFitWidth(windowWidth);
        root = new Group();
        root.getChildren().add(img);
        Canvas canvas = new Canvas(windowWidth, windowHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        return root;
    }

    private void setKeyPress() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                handler.notifyKeyPressed(key);
            }
        });
    }

    private void setMouseMovement() {
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                handler.notifyMouseMoved(event.getX());
            }

        });
    }

    public GraphicsContext getGraphicContext() {
        return gc;
    }

    public double getWidth() {
        return windowWidth;
    }

    public double getHeight() {
        return windowHeight;
    }

    public Group getRoot() {
        return root;
    }

}