package by.nhryshalevich;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.Arrays;

import by.nhryshalevich.Stone.*;
import by.nhryshalevich.Gemstone.*;
import by.nhryshalevich.SemiGemstone.*;
import by.nhryshalevich.Jewerly.*;

class Main {
    public static void main(String args[]) {
        String inputfile = "jewerly.json",
               outfile = "jewerly.bin";
        IOJewerly jewStream = new IOJewerly();
        try {
            jewStream.jewerlyFromJsonToBin(inputfile, outfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        ValueJewerly vj = new ValueJewerly(outfile);
        TransparentJewerly tj = new TransparentJewerly(outfile, 10, 50);
        vj.start();
        tj.start();
    }
}
