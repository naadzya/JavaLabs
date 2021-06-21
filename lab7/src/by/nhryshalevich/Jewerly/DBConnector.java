package by.nhryshalevich.Jewerly;

import by.nhryshalevich.Stone.*;
import by.nhryshalevich.Gemstone.*;
import by.nhryshalevich.SemiGemstone.*;
import java.util.ArrayList;
import java.sql.*;

public class DBConnector {
    String url;
    String username;
    String passwd;

    public DBConnector(String url, String username, String passwd) {
        this.url = url;
        this.username = username;
        this.passwd = passwd;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Gemstone[] getGemstonesFromDB(String tablename)
                                throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, passwd);
        Statement stmt = conn.createStatement();
        ResultSet dbResult = stmt.executeQuery("SELECT name, mass, cost, value, transparency FROM " + tablename);

        ArrayList<Gemstone> stones = new ArrayList<Gemstone>();

        while (dbResult.next()) {
            stones.add(new Gemstone(dbResult.getString("name"),
                                    dbResult.getDouble("mass"),
                                    dbResult.getDouble("cost"),
                                    dbResult.getInt("value"),
                                    dbResult.getInt("transparency")
                                    ));
        }
        return stones.toArray(new Gemstone[0]);
    }

    public SemiGemstone[] getSemiGemstonesFromDB(String tablename)
                                throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, passwd);
        Statement stmt = conn.createStatement();
        ResultSet dbResult = stmt.executeQuery("SELECT name, mass, cost, value, transparency FROM " + tablename);

        ArrayList<SemiGemstone> stones = new ArrayList<SemiGemstone>();

        while (dbResult.next()) {
            stones.add(new SemiGemstone(dbResult.getString("name"),
                                        dbResult.getDouble("mass"),
                                        dbResult.getDouble("cost"),
                                        dbResult.getInt("value"),
                                        dbResult.getInt("transparency")
                                        ));
        }
        return stones.toArray(new SemiGemstone[0]);
    }

    public Jewerly getJewerlyUsingDB(String gemTablename, String semigemTablename,
                                     String brand) throws SQLException,
                                                          ClassNotFoundException {
        Gemstone[] gemstones = getGemstonesFromDB(gemTablename);
        SemiGemstone[] semigemstones = getSemiGemstonesFromDB(semigemTablename);
        ArrayList<Stone> allStones = new ArrayList<Stone>();

        for (Gemstone stone: gemstones) {
            allStones.add(stone);
        }
        for (SemiGemstone stone: semigemstones) {
            allStones.add(stone);
        }
        return new Jewerly(allStones.toArray(new Stone[0]), brand);
    }
}
