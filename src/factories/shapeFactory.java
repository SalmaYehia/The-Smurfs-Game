package factories;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

import shape.Shape;
import shape.shapeInt;

public class shapeFactory {
	private Random randomize = new Random();
	private ArrayList<Class> shapeShuffler;

	private static shapeFactory shapeFactory = null;

	private shapeFactory() {

	}

	public static shapeFactory getShapeFactory() {

		if (shapeFactory == null) {
			return shapeFactory = new shapeFactory();
		}

		return shapeFactory;
	}

	public Shape getShapeInstance() {
		Class shuffle = shapeShuffler.get(randomize.nextInt(shapeShuffler.size()));
		Constructor<?>[] con = shuffle.getConstructors();
        shapeInt crnt = null;
        try {
            crnt = (shapeInt) con[0].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return (Shape) crnt;
	}

	public void setLoadedClasses(ArrayList<Class> loadedShapes) {
	    this.shapeShuffler = loadedShapes;
	}

}
