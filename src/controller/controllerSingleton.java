package controller;

import java.util.ArrayList;

import factories.shapeFactory;
import javafx.application.Application;
import layouts.View;
import logs.Logs;

public class controllerSingleton {
    private static ArrayList<Class> loadedShapes;
    private static controllerSingleton controller;
    private String[] args;
    private static View view;
    private eventHandler handler;

    private controllerSingleton(String[] args) {
        this.args = args;
        view = new View();
        handler = eventHandler.getInstance();
        handler.setView(view);
    }

    public static controllerSingleton getInstance(String[] args) {
        if (controller == null)
            controller = new controllerSingleton(args);
        return controller;
    }

    public void startGame() {
        loadShapes();
        Logs.log("shapes is loaded", "info");
        Application.launch(View.class, args);
    }

    private static void loadShapes() {
        try {
            loadedShapes = classLoading.getInstance().getLoadedShapes();
            shapeFactory.getShapeFactory().setLoadedClasses(loadedShapes);
        } catch (Exception e) {
            Logs.log("Shapes can't be loaded", "error");
        }
    }

    public static void main(String[] args) {
        controllerSingleton.getInstance(args).startGame();
    }
}