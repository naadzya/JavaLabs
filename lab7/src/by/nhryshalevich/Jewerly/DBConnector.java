package by.nhryshalevich.Jewerly;

import by.nhryshalevich.Stone.*;
import by.nhryshalevich.Gemstone.*;
import by.nhryshalevich.SemiGemstone.*;
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

    public void getGemstones(String tablename) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, passwd);
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT name, mass FROM " + tablename);

        while (result.next()) {
            System.out.println(result.getString("name") + "\t" + result.getString("mass"));
        }
    }
}
