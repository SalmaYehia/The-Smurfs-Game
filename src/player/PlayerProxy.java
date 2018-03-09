package player;
 
import java.io.Serializable;
 
import javafx.scene.input.KeyCode;
import observer.positionHandler;
 
public class PlayerProxy implements Serializable{
    private double positionX;
    private double positionY;
    private boolean mouseControl;
    private KeyCode leftButton;
    private KeyCode rightButton;
    public int score;
    public int type;
    private positionHandler PH;
    public PlayerProxy(double positionX,double positionY, boolean mouseControl,KeyCode leftButton,KeyCode rightButton,int score,positionHandler PH){
    	this.positionX=positionX;
    	this.positionY=positionY;
    	this.mouseControl=mouseControl;
    	this.leftButton=leftButton;
    	this.rightButton=rightButton;
    	this.score=score;
    	this.PH=PH;
    }
 
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public positionHandler getPositionHandler() {
		return this.PH;
	}
	public void setPositionHandler(positionHandler b) {
		this.PH = b;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public boolean isMouseControl() {
		return mouseControl;
	}
	public void setMouseControl(boolean mouseControl) {
		this.mouseControl = mouseControl;
	}
	public KeyCode getLeftButton() {
		return leftButton;
	}
	public void setLeftButton(KeyCode leftButton) {
		this.leftButton = leftButton;
	}
	public KeyCode getRightButton() {
		return rightButton;
	}
	public void setRightButton(KeyCode rightButton) {
		this.rightButton = rightButton;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
 