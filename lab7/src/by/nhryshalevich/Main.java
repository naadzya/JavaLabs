package by.nhryshalevich;

import by.nhryshalevich.Jewerly.*;
import java.sql.*;

public class Main {
    public static void main(String args[]) {
        DBConnector connector = new DBConnector("jdbc:mysql://172.17.18.111:3306/stonesdb", "lab7user", "P@ssW0rd");

        try {
            connector.getGemstones("gemstones");
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
