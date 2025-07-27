package com.auctionsite.dao;
import com.auctionsite.model.User;

public interface UserDAO {
    void saveUser(User user);
    User getUserById(int userId);
    User getUserByEmail(String email);
    boolean exist(User user);
}
