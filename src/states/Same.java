package states;

import java.util.Stack;

import controller.gameController;
import shape.Shape;

public class Same implements StackState{
    PlayerStack stack;
    public Same(PlayerStack stack) {
		this.stack=stack;
	}
	@Override
	public Stack insert(Shape shape) {
		stack.stack.push(shape);
		for(int i=0;i<3;i++){
		Shape shape1=(Shape) stack.stack.pop();
	    stack.setHight(stack.getHight()-shape1.getHeight());
	    gameController.pool.returnObject(shape1);
		}
		this.stack.getParetPlayer().setScore((this.stack.getParetPlayer().getScore())+1);
		return stack.stack;
	}
}
