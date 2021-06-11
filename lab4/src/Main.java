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
        IOJewerly testIO = new IOJewerly();

        try {
            testIO.jewerlyFromJsonToBin("jewerly.json", "jewerly.bin");
            System.out.println(Arrays.toString(testIO.readFromFile("jewerly.bin").getStones()));
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
