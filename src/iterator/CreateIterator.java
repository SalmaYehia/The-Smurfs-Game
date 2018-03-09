package iterator;
 
import java.util.ArrayList;
import java.util.LinkedList;
 
import player.Player;
import shape.Shape;
 
public interface CreateIterator {
public Iterator cteateIterator(ArrayList<Shape> shape);
public Iterator cteateIterator(Shape[] shape);
public Iterator cteateIterator(LinkedList<Player> player);
}