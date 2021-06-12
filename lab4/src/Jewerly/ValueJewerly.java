package src.Jewerly;

import src.Stone.*;
import src.Gemstone.*;
import src.SemiGemstone.*;
import src.Jewerly.*;
import java.io.IOException;

public class ValueJewerly extends Thread {

    private String jsonFilename;
    private String binFilename;

    public ValueJewerly(String jsonFilename, String binFilename) {
        this.jsonFilename = jsonFilename;
        this.binFilename = binFilename;
    }

    public void run() {
        IOJewerly jewStream = new IOJewerly();

        try {
            jewStream.jewerlyFromJsonToBin(jsonFilename, binFilename);
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
