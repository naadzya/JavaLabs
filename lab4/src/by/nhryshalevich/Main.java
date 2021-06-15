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
        ValueJewerly vj = new ValueJewerly("jewerly.json", "jewerly.bin");
        TransparentJewerly tj = new TransparentJewerly("jewerly.json", "jewerly.bin",
                                                       10, 50);
        vj.start();
        tj.start();
    }
}
