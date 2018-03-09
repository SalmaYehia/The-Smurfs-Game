package shape;

import javafx.scene.paint.Color;
import states.FallingFromLeft;
import states.FallingFromRight;

public class BuildShape {
	public Shape create(ShapeProxy r) {
		Shape t = null;

		if (r.getType() == 1) {
			t = new ellipse();
		}
		if (r.getType() == 2) {
			t = new plate();
		}
		if (r.getType() == 3) {
			t = new block();
		}
		t.setX(r.getX());
		t.setY(r.getY());
		t.slope = r.getSlope();
		if (r.getState().equals("left")) {
			t.setState(FallingFromLeft.getFallingFromLeftInstance());
		}
		if (r.getState().equals("right")) {
			t.setState(FallingFromRight.getFallingFromRightInstance());
		}
		t.color = this.getcolor(r.getColor());
		return t;
	}

	public Shape[] create(ShapeProxy[] t) {
		Shape shape[] = new Shape[t.length];
		for (int i = 0; i < t.length; i++) {
			shape[i] = this.create(t[i]);
		}
		return shape;
	}

	public Color getcolor(String color) {

		if (color != null) {

			if (color.equals("RED")) {
				return Color.RED;
			}
			if (color.equals("BLUE")) {
				return Color.BLUE;
			}
			if (color.equals("PINK")) {
				return Color.PINK;
			}
			if (color.equals("CYAN")) {
				return Color.CYAN;
			}
			if (color.equals("GOLD")) {
				return Color.GOLD;
			}
			if (color.equals("BLUEVIOLET")) {
				return Color.BLUEVIOLET;
			}
			if (color.equals("GREENYELLOW")) {
				return Color.GREENYELLOW;
			}
			if (color.equals("DEEPPINK")) {
				return Color.DEEPPINK;
			}
			if (color.equals("BLACK")) {
				return Color.BLACK;
			}
			if (color.equals("DARKGREEN")) {
				return Color.DARKGREEN;
			}
		}
		return null;

	}
}