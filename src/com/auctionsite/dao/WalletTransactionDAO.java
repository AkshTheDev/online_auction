package com.auctionsite.dao;

import com.auctionsite.model.WalletTransaction;
import java.util.List;

public interface WalletTransactionDAO {
    void recordTransaction(WalletTransaction tx);
    List<WalletTransaction> getTransactionsByWallet(int walletId);
    void updateTransactionStatus(int transactionId, String newStatus);
}
