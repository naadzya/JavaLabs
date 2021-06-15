package by.nhryshalevich.Jewerly;

import by.nhryshalevich.Stone.*;
import by.nhryshalevich.Gemstone.*;
import by.nhryshalevich.SemiGemstone.*;
import by.nhryshalevich.Jewerly.*;
import java.io.IOException;

public class ValueJewerly extends Thread {

    private String binFilename;

    public ValueJewerly(String binFilename) {
        this.binFilename = binFilename;
    }

    public void run() {
        IOJewerly jewStream = new IOJewerly();
        try {
            Jewerly jewerly = jewStream.readFromFile(binFilename);
            jewerly.sortStonesByValue();
            for (Stone stone: jewerly.getStones()) {
                System.out.println(stone.getName() + " with value "
                                   + String.valueOf(stone.getValue()));
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
