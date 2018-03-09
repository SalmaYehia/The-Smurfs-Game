package save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import logs.Logs;
import player.BuildPlayerProxy;
import player.PlayerProxy;
import shape.BuildShapeProxy;
import shape.ShapeProxy;
import snapshot.Snapshot;

public class save {
    private getarray array = new getarray();
    private BuildShapeProxy buildShapeProxy = new BuildShapeProxy();
    private BuildPlayerProxy builtPlayerProxy = new BuildPlayerProxy();
    private int time[] = new int[7];
    private String gameStrategy;
    private boolean[] blockstacks = new boolean[4];

    public void save(Snapshot snapshot) {
        time[0] = snapshot.getCounter();
        time[1] = snapshot.getMinutes();
        time[2] = snapshot.getSeconds();
        time[3] = (int) snapshot.getPlayers().get(0).Stacks.get(0).getHight();
        time[4] = (int) snapshot.getPlayers().get(0).Stacks.get(1).getHight();
        time[5] = (int) snapshot.getPlayers().get(1).Stacks.get(0).getHight();
        time[6] = (int) snapshot.getPlayers().get(1).Stacks.get(1).getHight();
        gameStrategy = snapshot.getOptions().getGameStrategy();
        blockstacks[0] = snapshot.getPlayers().get(0).Stacks.get(0).isblocked();
        blockstacks[1] = snapshot.getPlayers().get(0).Stacks.get(1).isblocked();
        blockstacks[2] = snapshot.getPlayers().get(1).Stacks.get(0).isblocked();
        blockstacks[3] = snapshot.getPlayers().get(1).Stacks.get(1).isblocked();

        try {
            FileOutputStream fileOut1 = new FileOutputStream("car1");// creates
                                                                     // a
                                                                     // card
                                                                     // serial
                                                                     // file
                                                                     // in
                                                                     // output
                                                                     // stream
            FileOutputStream fileOut2 = new FileOutputStream("car2");
            FileOutputStream fileOut3 = new FileOutputStream("car3");
            FileOutputStream fileOut4 = new FileOutputStream("car4");
            FileOutputStream fileOut5 = new FileOutputStream("car5");
            FileOutputStream fileOut6 = new FileOutputStream("car6");
            FileOutputStream fileOut7 = new FileOutputStream("car7");
            FileOutputStream fileOut8 = new FileOutputStream("car8");
            FileOutputStream fileOut9 = new FileOutputStream("car9");
            FileOutputStream fileOut10 = new FileOutputStream("car10");

            ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);// routs
                                                                       // an
                                                                       // object
                                                                       // into
                                                                       // the
                                                                       // output
                                                                       // stream.
            ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
            ObjectOutputStream out3 = new ObjectOutputStream(fileOut3);
            ObjectOutputStream out4 = new ObjectOutputStream(fileOut4);
            ObjectOutputStream out5 = new ObjectOutputStream(fileOut5);
            ObjectOutputStream out6 = new ObjectOutputStream(fileOut6);
            ObjectOutputStream out7 = new ObjectOutputStream(fileOut7);
            ObjectOutputStream out8 = new ObjectOutputStream(fileOut8);
            ObjectOutputStream out9 = new ObjectOutputStream(fileOut9);
            ObjectOutputStream out10 = new ObjectOutputStream(fileOut10);

            out1.writeObject(buildShapeProxy.create(array.getShapeArray(snapshot.getShapes())));// we
                                                                                                // designate
                                                                                                // our
                                                                                                // array
                                                                                                // of
                                                                                                // cards
                                                                                                // to
                                                                                                // be
                                                                                                // routed
            out2.writeObject(buildShapeProxy.create(array.getShape(snapshot.getPlayers().get(0).Stacks.get(0).stack)));
            out3.writeObject(buildShapeProxy.create(array.getShape(snapshot.getPlayers().get(0).Stacks.get(1).stack)));
            out4.writeObject(buildShapeProxy.create(array.getShape(snapshot.getPlayers().get(1).Stacks.get(0).stack)));
            out5.writeObject(buildShapeProxy.create(array.getShape(snapshot.getPlayers().get(1).Stacks.get(1).stack)));
            out6.writeObject(builtPlayerProxy.create(snapshot.getPlayers().get(0), 0));
            out7.writeObject(builtPlayerProxy.create(snapshot.getPlayers().get(1), 1));
            out8.writeObject(this.time);
            out9.writeObject(gameStrategy);
            out10.writeObject(blockstacks);
            out1.close();// closes the data paths
            out2.close();
            out3.close();
            out4.close();
            out5.close();
            out6.close();
            out7.close();
            out8.close();
            out9.close();
            out10.close();
            fileOut1.close();// closes the data paths
            fileOut2.close();
            fileOut3.close();
            fileOut4.close();
            fileOut5.close();
            fileOut6.close();
            fileOut7.close();
            fileOut8.close();
            fileOut9.close();
            fileOut10.close();
        } catch (IOException i) {
            Logs.log("error is saving game", "error");
        }

    }

    public Object load1() {
        try// If this doesnt work throw an exception
        {
            FileInputStream fileIn1 = new FileInputStream("car1");// Read serial
                                                                  // file.
            FileInputStream fileIn2 = new FileInputStream("car2");
            FileInputStream fileIn3 = new FileInputStream("car3");
            FileInputStream fileIn4 = new FileInputStream("car4");
            FileInputStream fileIn5 = new FileInputStream("car5");
            FileInputStream fileIn6 = new FileInputStream("car6");
            FileInputStream fileIn7 = new FileInputStream("car7");

            ObjectInputStream in1 = new ObjectInputStream(fileIn1);// input the
                                                                   // read
                                                                   // file.
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            ObjectInputStream in3 = new ObjectInputStream(fileIn3);
            ObjectInputStream in4 = new ObjectInputStream(fileIn4);
            ObjectInputStream in5 = new ObjectInputStream(fileIn5);
            ShapeProxy[][] b = new ShapeProxy[5][1];
            b[0] = (ShapeProxy[]) in1.readObject();// allocate it to the object
                                                   // file already
                                                   // instanciated.
            b[1] = (ShapeProxy[]) in2.readObject();
            b[2] = (ShapeProxy[]) in3.readObject();
            b[3] = (ShapeProxy[]) in4.readObject();
            b[4] = (ShapeProxy[]) in5.readObject();

            in1.close();// closes the input stream.
            in2.close();
            in3.close();
            in4.close();
            in5.close();
            fileIn1.close();// closes the file data stream.
            fileIn2.close();
            fileIn3.close();
            fileIn4.close();
            fileIn5.close();
            return b;
        } catch (Exception i) {
            Logs.log("Error in loading game", "error");
            return null;
        }
    }

    public Object load2() {
        try// If this doesnt work throw an exception
        {
            FileInputStream fileIn6 = new FileInputStream("car6");
            FileInputStream fileIn7 = new FileInputStream("car7");

            ObjectInputStream in6 = new ObjectInputStream(fileIn6);
            ObjectInputStream in7 = new ObjectInputStream(fileIn7);
            PlayerProxy[] b = new PlayerProxy[2];
            b[0] = (PlayerProxy) in6.readObject();// allocate it to the object
                                                  // file already
                                                  // instanciated.
            b[1] = (PlayerProxy) in7.readObject();

            in6.close();
            in7.close();
            fileIn6.close();
            fileIn7.close();
            return b;
        } catch (Exception i) {
            Logs.log("error in loading files", "error");
            return null;
        }
    }

    public Object load3() {
        try// If this doesnt work throw an exception
        {
            FileInputStream fileIn8 = new FileInputStream("car8");// Read serial
                                                                  // file.

            ObjectInputStream in8 = new ObjectInputStream(fileIn8);
            int[] h = (int[]) in8.readObject();

            in8.close();

            fileIn8.close();
            return h;
        } catch (Exception i) {
            Logs.log("error in loading files", "error");
            return null;
        }
    }

    public String load4() {
        try// If this doesnt work throw an exception
        {
            FileInputStream fileIn9 = new FileInputStream("car9");// Read serial
                                                                  // file.

            ObjectInputStream in9 = new ObjectInputStream(fileIn9);
            String h = (String) in9.readObject();
            in9.close();
            fileIn9.close();
            return h;
        } catch (Exception i) {
            Logs.log("error in loading files", "error");
            return null;
        }
    }

    public boolean[] load5() {
        try// If this doesnt work throw an exception
        {
            FileInputStream fileIn10 = new FileInputStream("car10");// Read
                                                                    // serial
                                                                    // file.

            ObjectInputStream in10 = new ObjectInputStream(fileIn10);
            boolean[] h = (boolean[]) in10.readObject();
            in10.close();
            fileIn10.close();

            return h;
        } catch (Exception i) {
            Logs.log("error in loading files", "error");
            return null;
        }
    }

}