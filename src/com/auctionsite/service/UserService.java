package com.auctionsite.service;
import com.auctionsite.dao.UserDAOImp;
import com.auctionsite.model.User;
import com.auctionsite.customExceptions.InvalidUserException;
public class UserService {
    UserDAOImp userDAO = new UserDAOImp();
    public void registerUser(User user) throws InvalidUserException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidUserException("Email is required");
        }

        if (!user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new InvalidUserException("Invalid email format");
        }

        if (user.getPhone() == null || !user.getPhone().matches("^[6-9]\\d{9}$")) {
            throw new InvalidUserException("Invalid Indian phone number");
        }

        if (user.getFirst_name() != null && user.getFirst_name().length() > 100) {
            throw new InvalidUserException("First name too long");
        }

        if (user.getLast_name() != null && user.getLast_name().length() > 100) {
            throw new InvalidUserException("Last name too long");
        }


        userDAO.saveUser(user);
    }

//
//    public void Login(User user) {
//
//    }

}
