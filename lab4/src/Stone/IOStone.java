package src.Stone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOStone {
    private static final String filepath = "./";

    public void writeToFile(Stone gemstone, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filepath + filename);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        objectOut.writeObject(gemstone);
        
        objectOut.close();
    }

    public Stone readFromFile(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filepath + filename);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        Stone result = (Stone) objectIn.readObject();

        return result;
    }

}
