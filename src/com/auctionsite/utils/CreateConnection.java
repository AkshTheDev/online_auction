package com.auctionsite.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
   private static Connection con;
    public CreateConnection(String url, String user, String password) {
        try {
        con = DriverManager.getConnection(url, user, password);

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {
        return con;
    }
}
