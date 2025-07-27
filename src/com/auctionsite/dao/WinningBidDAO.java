package com.auctionsite.dao;

import com.auctionsite.model.WinningBid;
import com.auctionsite.utils.TransactionStatus;

import java.util.List;

public interface WinningBidDAO {
    void recordWinningBid(WinningBid winBid);
    WinningBid getByItemId(int itemId);
    List<WinningBid> getAllWinningBids();
    void updatePaymentStatus(int winId, TransactionStatus newStatus); // or use enum
}
