package com.auctionsite.dao;

import com.auctionsite.model.AccountTransaction;
import java.util.List;

public interface AccountTransactionDAO {
    void recordTransaction(AccountTransaction transaction);
    List<AccountTransaction> getTransactionsByWallet(int walletId);
    void updateTransactionStatus(int transactionId, String newStatus);
}
