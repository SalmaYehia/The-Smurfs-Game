package states;

import java.util.Stack;

import observer.positionHandler;
import player.Player;
import shape.Shape;
import shape.shapeInt;

public class PlayerStack {

	private StackState currentstate;
	private StackState Different;
	private StackState Same;
	private boolean block;
	private double hight;
	public Stack<shapeInt> stack;
	public Player player;
	public positionHandler PH = new positionHandler();

	public PlayerStack(double hight, Player player) {
		Different = new Different(this);
		Same = new Same(this);
		this.currentstate = Different;
		stack = new Stack<shapeInt>();
		this.hight = hight;
		this.player = player;
		block = false;
	}

	public double getHight() {
		return hight;
	}

	public Player getParetPlayer() {
		return this.player;
	}

	public void set(PlayerStack newState) {
		currentstate = (StackState) newState;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}

	private boolean sameShapes(Shape shape) {
		if (stack.size() < 2) {
			return false;
		}
		Shape shape1 = (Shape) stack.pop();
		Shape shape2 = (Shape) stack.pop();
		stack.push(shape2);
		stack.push(shape1);
		if (shape1.getColor() != null && shape2.getColor() != null && shape.getColor() != null) {
			if (shape.getColor().equals(shape1.getColor()) && shape.getColor().equals(shape2.getColor())) {
				return true;
			}
		}
		return false;
	}

	public Stack add(Shape shape) {
		setHight(getHight() + shape.getHeight());
		PH.registerObserver(shape);
		if (sameShapes(shape)) {
			currentstate = Same;
		} else {
			currentstate = Different;
		}
		return currentstate.insert(shape);
	}

	public void blockStack() {
		block = true;
	}

	public boolean isblocked() {
		return block;
	}
}
