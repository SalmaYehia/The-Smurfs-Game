package iterator;
 
 
import shape.Shape;
 
public class ShapeiteratorArray implements Iterator{
	  Shape[] shapes;
	   int current=-1;
	    public ShapeiteratorArray( Shape[] shape) {
			this.shapes=shape;
		}
		@Override
		public boolean hasNext() {
		    if(shapes==null||current>=shapes.length-1||shapes[current+1]==null){
			return false;
			}
		    return true;
 
		}
 
		@Override
		public Object Next() {
 
			current++;
			return shapes[current];
		}
}