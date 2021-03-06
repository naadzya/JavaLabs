package by.nhryshalevich;

import by.nhryshalevich.Jewerly.*;
import by.nhryshalevich.Gemstone.*;
import java.sql.*;
import java.io.Console;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Console console = System.console();
        char[] passwd = console.readPassword("Enter password for lab7user: ");
        String providedPassword = String.valueOf(passwd);

        DBConnector connector = new DBConnector("jdbc:mysql://172.17.18.111:3306/stonesdb", "lab7user", providedPassword);

        try {
            Jewerly jewerly = connector.getJewerlyUsingDB("gemstones",
                                                          "semigemstones",
                                                          "mybrand");
            System.out.print(jewerly.toString());
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Server error or provided password is wrong");
        }
    }
}
