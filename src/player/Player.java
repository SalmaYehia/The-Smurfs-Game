package player;

import java.io.Serializable;
import java.util.LinkedList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import observer.positionHandler;
import states.PlayerStack;

public class Player implements Serializable {

	public ImageView imageView;
	private static final int CHARHIGHT = 330;
	private double positionX;
	private double positionY;
	public LinkedList<PlayerStack> Stacks;
	private boolean mouseControl;
	private KeyCode leftButton;
	private KeyCode rightButton;
	public positionHandler PH;
	public int score;

	public Player(Image image, boolean mouseControl) {
		imageView = new ImageView(image);
		this.mouseControl = mouseControl;
		Stacks = new LinkedList<states.PlayerStack>();
		Stacks.add(new PlayerStack(CHARHIGHT, this));
		Stacks.add(new PlayerStack(CHARHIGHT, this));
		score = 0;
	}

	public void positionChanged() {
		notifyStacks();
	}

	private void notifyStacks() {

		for (PlayerStack crnt : Stacks) {
			crnt.PH.notifyObservers(positionX, Stacks.indexOf(crnt));
		}
	}

	public void setScore(int newScore) {
		score = newScore;
	}

	public int getScore() {
		return score;
	}

	public double getX() {
		return positionX;
	}

	public void setX(double x) {
		imageView.setX(x);
		positionX = x;
		positionChanged();
	}

	public double getY() {
		return positionY;
	}

	public void setY(double y) {
		imageView.setY(y);
		positionY = y;
	}

	public void MoveByKey(double speed) {
		setX(getX() + speed);
		positionChanged();
	}
	
	public LinkedList<PlayerStack> getStacks() {
		return Stacks;
	}

	public void setRightButton(KeyCode button) {
		this.rightButton = button;
	}

	public void setLeftButton(KeyCode button) {
		this.leftButton = button;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public boolean getMouseControl() {
		return mouseControl;
	}

	public KeyCode getLeftButton() {
		return leftButton;
	}

	public KeyCode getrightButton() {
		return rightButton;
	}

}