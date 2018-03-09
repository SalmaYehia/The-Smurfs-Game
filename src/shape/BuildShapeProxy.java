package shape;

public class BuildShapeProxy {
    public ShapeProxy create(Shape r) {
        return new ShapeProxy(r.getX(), r.getY(), r.gettype(), r.getHeight(), r.slope, r.getState().getstate(),
                r.getColorname());
    }

    public ShapeProxy[] create(Shape[] t) {
        ShapeProxy shapeProxy[] = new ShapeProxy[t.length];
        for (int i = 0; i < t.length; i++) {
            shapeProxy[i] = this.create(t[i]);

        }
        return shapeProxy;
    }

}