package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.Class.forName;

public class ConnectionUtil {
    public static ConnectionUtil connectionUtil = new ConnectionUtil();


    public ConnectionUtil() {
        super();
    }

    public static ConnectionUtil getConnectionUtil() {
        return connectionUtil;
    }

    public Connection getConnection() {


        try {
            Class.forName("org.postgresql.Driver");
            Properties prop = new Properties();
            prop.load(new FileReader("/Users/navroophundal/Documents/Revature/Project 1 TRMS/Project 1/src/main/resources/database.properties"));
            return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}