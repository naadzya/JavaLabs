package by.nhryshalevich.Jewerly;

import by.nhryshalevich.Stone.*;
import by.nhryshalevich.Jewerly.*;
import by.nhryshalevich.Gemstone.*;
import by.nhryshalevich.SemiGemstone.*;
import java.io.IOException;

public class TransparentJewerly extends Thread {

    private String binFilename;
    private int leftBound;
    private int rightBound;

    public TransparentJewerly(String binFilename,
                              int leftBound, int rightBound) {
        this.binFilename = binFilename;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    public void run() {
        IOJewerly jewStream = new IOJewerly();
        try {
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
