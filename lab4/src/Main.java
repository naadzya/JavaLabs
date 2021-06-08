package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import src.Stone.*;
import src.Gemstone.*;
import src.SemiGemstone.*;
import src.Jewerly.Jewerly;

public class Main {
    public static void main(String args[]) {
        IOStone testIO = new IOStone();

        Gemstone test = new Gemstone("Diamond", 1, 1, 1, 1);
        SemiGemstone test2 = new SemiGemstone("Opal", 2, 2, 2, 2);
        try {
            testIO.writeToFile(test, "gemstone.bin");
            //testIO.writeToFile(test2, "gemstone.bin");
            System.out.println(testIO.readFromFile("gemstone.bin").toString());
            //System.out.println(testIO.readFromFile("gemstone.bin").toString());
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
