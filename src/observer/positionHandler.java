package observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import iterator.CreateIterator;
import iterator.Iterator;
import iterator.PlayerIterator;
import iterator.Shapeiterator;
import iterator.ShapeiteratorArray;
import logs.Logs;
import player.Player;
import shape.Shape;

public class positionHandler implements CreateIterator {

	private Stack<Shape> observers;

	public positionHandler() {
		observers = new Stack<Shape>();
	}

	public void registerObserver(Shape o) {
		Logs.log("new shape is added to observers", "debug");
		observers.push(o);
	}

	public void removeObserver(Shape o) {
		int i = observers.indexOf(o);
		if (i >= 0)
			observers.remove(i);
	}

	public void notifyObservers(double x, int s) {
		if (s == 0)
			for (Shape crnt : observers)
				crnt.update(x);
		else
			for (Shape crnt : observers)
				crnt.update(x + 185);
	}

	public void createObserverList(Shape[] r) {
		Iterator j = this.cteateIterator(r);
		while (j.hasNext()) {
			this.observers.push((Shape) j.Next());
		}
	}

	@Override
	public Iterator cteateIterator(LinkedList<Player> player) {

		return new PlayerIterator(player);
	}

	@Override
	public Iterator cteateIterator(ArrayList<Shape> shape) {

		return new Shapeiterator(shape);
	}

	@Override
	public Iterator cteateIterator(Shape[] shape) {

		return new ShapeiteratorArray(shape);
	}

}
