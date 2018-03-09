package shape;

import java.io.Serializable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import states.Stored;

public class plate extends Shape implements shapeInt, Serializable {
	private Polygon platePolygon;
	private Double[] vertices = { 0.0, 0.0, 20.0, 16.0, 50.0, 16.0, 70.0, 0.0 };
	private double[] xVertices = { vertices[0], vertices[2], vertices[4], vertices[6] };
	private double[] yVertices = { vertices[1], vertices[3], vertices[5], vertices[7] };

	public plate() {
		Color c = colors[randomize.nextInt(colors.length)];
		this.color = c;
		platePolygon = new Polygon();
		platePolygon.getPoints().addAll(vertices);
		platePolygon.setFill(color);
		this.state = Stored.getStoredInstance();
		this.height = 16.0;
		type = 2;
	}

	@Override
	public void drawShape(GraphicsContext gc) {
		gc.setFill(this.color);
		gc.fillPolygon(xVertices, yVertices, 4);
	}

	@Override
	public double centerX() {
		return this.x;
	}

	@Override
	public double centerY() {
		return this.y;
	}

	@Override
	public void setX(double x) {
		this.vertices[0] = x - 35;
		this.vertices[2] = x - 15.0;
		this.vertices[4] = x + 15.0;
		this.vertices[6] = x + 35.0;
		this.xVertices[0] = x - 35;
		this.xVertices[1] = x - 15.0;
		this.xVertices[2] = x + 15.0;
		this.xVertices[3] = x + 35.0;
		platePolygon.getPoints().addAll(vertices);
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.vertices[1] = y;
		this.vertices[3] = y + 16.0;
		this.vertices[5] = y + 16.0;
		this.vertices[7] = y;
		this.yVertices[0] = y;
		this.yVertices[1] = y + 16.0;
		this.yVertices[2] = y + 16.0;
		this.yVertices[3] = y;
		platePolygon.getPoints().addAll(vertices);
		this.y = y;
	}


}