package com.auctionsite;
import com.auctionsite.customExceptions.InvalidUserException;
import com.auctionsite.customExceptions.UserNotFoundException;
import com.auctionsite.dao.UserDAO;
import com.auctionsite.dao.UserDAOImp;
import com.auctionsite.service.UserService;
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
        UserService userService = new UserService();

        User user = new User("abc@gmail.com","9091112307","Akshansh","Sinha");

        try {
//            userService.registerUser(user);
            userService.login("abc@gmail.com");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}