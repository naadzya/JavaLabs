package src.Stone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOStone {
    private static final String filepath = "./files/";
    private static final File targetDir = new File(filepath);

    public void writeToFile(Stone gemstone, String filename) throws IOException {
        File targetFile = new File(targetDir, filename);

        FileOutputStream fileOut = new FileOutputStream(targetFile, true);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        objectOut.writeObject(gemstone);
        
        objectOut.close();
    }

    public Stone[] readFromFile(String filename) throws IOException, ClassNotFoundException {
        File targetFile = new File(targetDir, filename);
        FileInputStream fileIn = new FileInputStream(targetFile);

        Stone[] result = {};

        while (true) {
            try {
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Stone stone = (Stone) objectIn.readObject();
                Stone[] temp = new Stone[result.length + 1];
                for (int j = 0; j < result.length; j++) {
                    temp[j] = result[j];
                }
                temp[result.length] = stone;
                result = temp;
            }
            catch (EOFException e) {
                break;
            }
        }

        return result;
    }

}
