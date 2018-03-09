package shape;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class ShapeProxy implements Serializable {
    private String color;
    private double x;
    private double y;
    private double height;
    private float slope;
    private int type;
    private String state;

    public ShapeProxy(double x, double y, int type, double height, float slope, String state, String color) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
        this.height = height;
        this.slope = slope;
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color.equals(Color.RED)) {
            this.color = "RED";
        }
        if (color.equals(Color.BLUE)) {
            this.color = "BLUE";
        }
        if (color.equals(Color.PINK)) {
            this.color = "PINK";
        }
        if (color.equals(Color.CYAN)) {
            this.color = "CYAN";
        }
        if (color.equals(Color.GOLD)) {
            this.color = "GOLD";
        }
        if (color.equals(Color.BLUEVIOLET)) {
            this.color = "BLUEVIOLET";
        }
        if (color.equals(Color.GREENYELLOW)) {
            this.color = "GREENYELLOW";
        }
        if (color.equals(Color.DEEPPINK)) {
            this.color = "DEEPPINK";
        }
        if (color.equals(Color.BLACK)) {
            this.color = "BLACK";
        }
        if (color.equals(Color.DARKGREEN)) {
            this.color = "DARKGREEN";
        }

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getSlope() {
        return slope;
    }

    public void setSlope(float slope) {
        this.slope = slope;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
