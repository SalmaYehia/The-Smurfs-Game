package shape;
 
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import states.ShapeState;
 
public interface shapeInt {
 
    public void drawShape(GraphicsContext gc);
 
    public double getX();
 
    public void setSlope(double screenWidth, double screenheight);
 
    public void move(GraphicsContext gc, double shapeSpeed,double width, double fallingSpeed);
 
    public double getY();
 
    public void setX(double x);
 
    public void setY(double y);
 
    public void increaseSlopedY(double width, double fallingSpeed);
 
    public ShapeState getState();
 
    public void setState(ShapeState s);
 
    public Color getColor();
 
    public double getHeight();
 
    public double centerX();
 
    public double centerY();
 
}