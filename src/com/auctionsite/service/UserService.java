package com.auctionsite.service;
import com.auctionsite.dao.UserDAOImp;
import com.auctionsite.model.User;

public class UserService {
    UserDAOImp userDAO = new UserDAOImp();
    public void Register(User user) {
        if(userDAO.exist(user)){
            userDAO.RegisterUser(user);
        }else{
            throw new IllegalArgumentException("Account already exist!");
        }
    }

}
