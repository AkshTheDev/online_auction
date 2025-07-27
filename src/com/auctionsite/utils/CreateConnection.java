package com.auctionsite.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {
    private static final String url = "jdbc:mysql://localhost:3306/online_auction";
    private static final String user = "root";
    private static final String password = "tiger";
    private static Connection con;

    public static Connection getConnection() {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url,user,password);
            }catch(Exception e){
                e.printStackTrace();
            }
        return con;
    }
}
