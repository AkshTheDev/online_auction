package com.auctionsite;
import com.auctionsite.dao.UserDAOImp;
import com.auctionsite.utils.CreateConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.auctionsite.utils.KycStatus;
import com.auctionsite.model.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String User = "root";
        String password = "tiger";
        String url = "jdbc:mysql://localhost:3306/online_auction";
        CreateConnection con = new CreateConnection(url, User, password);
        UserDAOImp userDAO = new UserDAOImp(con);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter First Name: ");
        String first_name = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String last_name = sc.nextLine();
        User user = new User(email,phone,first_name,last_name);
        userDAO.RegisterUser(user);
//        System.out.println(userDAO.getUserByEmail("akshansh@gmail.com").toString());
    }
}