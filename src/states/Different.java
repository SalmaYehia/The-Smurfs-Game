package states;

import java.util.Stack;

import shape.Shape;

public class Different implements StackState {
    PlayerStack stack;
     public Different(PlayerStack stack) {
		this.stack=stack;
	}
	@Override
	public Stack insert(Shape shape) {
		stack.stack.push(shape);
		return stack.stack;
	}

}
