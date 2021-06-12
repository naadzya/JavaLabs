package src.Jewerly;

import src.Stone.*;
import src.Jewerly.*;
import src.Gemstone.*;
import src.SemiGemstone.*;
import java.io.IOException;

public class TransparentJewerly extends Thread {

    private String jsonFilename;
    private String binFilename;
    private int leftBound;
    private int rightBound;

    public TransparentJewerly(String jsonFilename, String binFilename,
                              int leftBound, int rightBound) {
        this.jsonFilename = jsonFilename;
        this.binFilename = binFilename;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    public void run() {
        IOJewerly jewStream = new IOJewerly();

        try {
            jewStream.jewerlyFromJsonToBin(jsonFilename, binFilename);
            Jewerly jewerly = jewStream.readFromFile(binFilename);
            Stone[] transparentStones = jewerly.getTransparentStones(leftBound,
                                                                     rightBound);
            for (Stone stone: transparentStones) {
                System.out.println(stone.getName() + " with transparency "
                                   + String.valueOf(stone.getTransparency()));
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
