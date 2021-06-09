package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.Arrays;

import src.Stone.*;
import src.Gemstone.*;
import src.SemiGemstone.*;
import src.Jewerly.*;

public class Main {
    public static void main(String args[]) {
        //IOStone testIO = new IOStone();
        IOJewerly testIO = new IOJewerly();

        Gemstone test = new Gemstone("Diamond", 1, 1, 1, 1);
        SemiGemstone test2 = new SemiGemstone("Opal", 2, 2, 2, 2);
        
        Jewerly testjw = new Jewerly(new Stone[] {test, test2}, "mybrand");

        try {
            testIO.writeToFile(testjw, "jewerly.bin");
            //testIO.writeToFile(test2, "stones.bin");
            //System.out.println(Arrays.toString(testIO.readFromFile("jewerly.bin")));
            System.out.println(Arrays.toString(testIO.readFromFile("jewerly.bin").getStones()));
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
