package src.Jewerly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.Stone.Stone;
import src.Gemstone.Gemstone;
import src.SemiGemstone.SemiGemstone;

public class IOJewerly {
    private static final String filepath = "./files/";
    private static final File targetDir = new File(filepath);

    public void writeToFile(Jewerly jewerly, String filename) throws IOException {
        File targetFile = new File(targetDir, filename);

        FileOutputStream fileOut = new FileOutputStream(targetFile, true);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

        objectOut.writeObject(jewerly);

        objectOut.close();
    }

    public Jewerly readFromFile(String filename) throws IOException, 
                                                        ClassNotFoundException {
        File targetFile = new File(targetDir, filename);
        FileInputStream fileIn = new FileInputStream(targetFile);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        Jewerly result = (Jewerly) objectIn.readObject();
        return result;
    }
}
