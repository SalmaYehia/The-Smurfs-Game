package controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import logs.Logs;
import shape.Shape;

public class classLoading {

    private static classLoading cLoad = null;
    private ArrayList<Class> loadedShapes = new ArrayList<Class>();

    private classLoading() throws MalformedURLException, ClassNotFoundException {
        final File folder = new File("jars");
        listFilesForFolder(folder);
    }

    public static classLoading getInstance() throws MalformedURLException, ClassNotFoundException {
        if (cLoad == null)
            return cLoad = new classLoading();
        return cLoad;
    }

    public void listFilesForFolder(final File folder) throws MalformedURLException, ClassNotFoundException {
        for (final File jarEntry : folder.listFiles()) {
            String name = jarEntry.getName().substring(0, jarEntry.getName().lastIndexOf("."));
            ClassLoader cl;
            URL JarFile = jarEntry.toURI().toURL();
            URL[] urls = new URL[] { JarFile };
            cl = new URLClassLoader(urls);
            Class tmp = cl.loadClass("shape." + name);
            try {
                if (Shape.class.isAssignableFrom(tmp))
                    loadedShapes.add(tmp);
            } catch (Exception e) {
                Logs.log("problem with loading shapes", "error");
            }
        }
    }

    public ArrayList<Class> getLoadedShapes() {
        return loadedShapes;
    }

}
