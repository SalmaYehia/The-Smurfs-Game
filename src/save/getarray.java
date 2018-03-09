package save;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import player.Player;
import shape.Shape;
import shape.shapeInt;

public class getarray {
	public Shape[] getShapeArray(ArrayList<Shape> shape) {
		Shape[] shapes = new Shape[shape.size()];
		for (int i = 0; i < shape.size(); i++) {
			shapes[i] = shape.get(i);
		}
		return shapes;
	}

	public ArrayList<Shape> getShapeList(Shape[] shape) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < shape.length; i++) {
			shapes.add(shape[i]);
		}
		return shapes;
	}

	public Player[] getPlayerArray(ArrayList<Player> player) {
		Player[] shapes = new Player[player.size()];
		for (int i = 0; i < player.size(); i++) {
			shapes[i] = player.get(i);
		}
		return shapes;
	}

	public LinkedList<Player> getPlayerList(Player[] player) {
		LinkedList<Player> v = new LinkedList<>();
		for (int i = 0; i < player.length; i++) {
			v.add(player[i]);
		}
		return v;
	}

	public Shape[] getShape(Stack<shapeInt> shape) {
		Shape[] shapes = new Shape[shape.size()];
		for (int i = 0; i < shape.size(); i++) {
			shapes[i] = (Shape) shape.get(i);
		}
		return shapes;
	}

	public Stack<shapeInt> getShapeStack(Shape[] shape) {
		Stack<shapeInt> v = new Stack<shapeInt>();
		for (int i = 0; i < shape.length; i++) {
			v.push((Shape) shape[i]);
		}
		return v;
	}

}
