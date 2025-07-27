package com.auctionsite.dao;
import com.auctionsite.model.Wallet;
import java.math.BigDecimal;

public interface WalletDAO {
    Wallet getWalletByUser(int userId);
    void updateBalance(int walletId, BigDecimal newBalance);
    void activateWallet(int walletId);
    void blockWallet(int walletId);
    void suspendWallet(int walletId);
    void createWalletForUser(int userId);
}
