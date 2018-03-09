package layouts;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import logs.Logs;

public class mainOptions extends layout {

	private Group root = new Group();

	public mainOptions(double height, double width) {

		super(height, width);
		addBackground();
		addButton();
		addLevel();
		scene = new Scene(root, windowWidth, windowHeight);

	}

	private void addKeyControls() {
		final ToggleGroup group = new ToggleGroup();
		RadioButton button1 = new RadioButton("player1 with keyBoard and player2 with mouse");
		button1.setToggleGroup(group);
		button1.setSelected(true);
		RadioButton button2 = new RadioButton("player2 with keyBoard and player1 with mouse");
		button2.setToggleGroup(group);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(button1, button2);
		root.getChildren().add(vbox);
	}

	private void addLevel() {
		StackPane pane = new StackPane();
		final ToggleGroup group = new ToggleGroup();
		RadioButton button1, button2, button3;
		String current = handler.getOptions().getGameStrategy();
		String[] names = { "easy", "medium", "difficult" };
		///////first
		String key = names[0];
		button1 = new RadioButton(key);
		button1.setUserData(key);
		button1.setToggleGroup(group);
		button1.setSelected(current.equals(key));
	//	button1.setPadding(new Insets(0, 0,0,0));
		//pane.getChildren().add(button1);
		/////second
		 key = names[1];
		button2 = new RadioButton(key);
		button2.setUserData(key);
		button2.setToggleGroup(group);
		button2.setSelected(current.equals(key));
	//	button2.setPadding(new Insets(0, 0,0, 300));
		//pane.getChildren().add(button2);
		//third
		 key = names[2];
		button3 = new RadioButton(key);
		button3.setUserData(key);
		button3.setToggleGroup(group);
		button3.setSelected(current.equals(key));
	//	button3.setPadding(new Insets(0, 0,0,600));
		pane.getChildren().addAll(button1, button2, button3);

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (group.getSelectedToggle() != null) {
					handler.setLevel(group.getSelectedToggle().getUserData().toString());
				}
			}
		});
		pane.setPadding(new Insets(250, 0,0,400));
		root.getChildren().add(pane);
	}

	private void addButton() {
		VBox vBox = new VBox();
		vBox.getChildren().add(factory.getButton("Main Menu").getButton());
		vBox.setPadding(new Insets(windowHeight * .8, windowWidth * .5, 100, windowWidth / 2 - 140));
		root.getChildren().add(vBox);
	}

	private void addBackground() {
		Logs.log("Options background added", "debug");
		Image background = imgFactory.getImage("mainOptions", windowWidth, windowHeight);
		ImageView img = new ImageView(background);
		root.getChildren().add(img);

	}

}
