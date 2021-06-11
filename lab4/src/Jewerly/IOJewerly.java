package src.Jewerly;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.Stone.Stone;
import src.Gemstone.Gemstone;
import src.SemiGemstone.SemiGemstone;

import java.util.Arrays;

public class IOJewerly {
    private static final String filepath = "./files/";
    private static final File targetDir = new File(filepath);

    public void writeToFile(Jewerly jewerly, String filename) throws IOException {
        File targetFile = new File(targetDir, filename);

        FileOutputStream fileOut = new FileOutputStream(targetFile, false); //overwrite
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
     
    public void jewerlyFromJsonToBin(String jsonFilename, String destfilename)
        				 throws IOException {
        File targetFile = new File(targetDir, jsonFilename);
        FileInputStream fis = new FileInputStream(targetFile);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String content = sb.toString();

        JSONObject jsonJewerly = new JSONObject(content);

        String brand = (String) jsonJewerly.get("brand");
        JSONArray jsonGemstones = (JSONArray) jsonJewerly.get("gemstones");
        JSONArray jsonSemiGemstones = (JSONArray) jsonJewerly.get("semigemstones");

        Stone stones[] = new Stone[jsonGemstones.length() + jsonSemiGemstones.length()];
        for (int i = 0; i < jsonGemstones.length(); i++) {
            stones[i] = new Gemstone(jsonGemstones.getJSONObject(i));
        }

        for (int i = 0; i < jsonSemiGemstones.length(); i++) {
            stones[i + jsonGemstones.length()] = new SemiGemstone(jsonSemiGemstones.getJSONObject(i));
        }

        writeToFile(new Jewerly(stones, brand), destfilename);
    }
}
