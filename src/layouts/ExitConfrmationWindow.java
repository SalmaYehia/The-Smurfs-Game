package layouts;

import controller.eventHandler;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitConfrmationWindow {
	private static Stage window;
	private static eventHandler handler = eventHandler.getInstance();

	public static void display() {
		window = new Stage();

		// Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Confirm Exit");
		window.setMinWidth(250);
		window.setHeight(150);

		Label label = new Label();
		label.setText("Do you want to quit?");
		Button YesButton = setYesButton();
		Button NoButton = setNoButton();

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, YesButton, NoButton);
		layout.setAlignment(Pos.CENTER);

		// Display window and wait for it to be closed before returning
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	private static Button setYesButton() {
		Button YesButton = new Button("Yes");
		YesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				window.close();
				handler.EndProgram();
			}
		});
		return YesButton;
	}
	private static Button setNoButton() {
		Button NoButton = new Button("No");
		NoButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				window.close();
			}
		});
		return NoButton;
	}
}
