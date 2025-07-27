package com.auctionsite.dao;

import com.auctionsite.model.WalletTransactionBreakdown;
import java.util.List;

public interface WalletTransactionBreakdownDAO {
    void addBreakdown(WalletTransactionBreakdown breakdown);
    List<WalletTransactionBreakdown> getBreakdownsForTransaction(int walletTransactionId);
}
