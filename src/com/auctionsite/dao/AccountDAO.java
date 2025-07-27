package com.auctionsite.dao;

import com.auctionsite.model.Account;
import java.util.List;

public interface AccountDAO {
    void addAccount(Account account);
    Account getAccountById(int accountId);
    List<Account> getAccountsByUserId(int userId);
}
