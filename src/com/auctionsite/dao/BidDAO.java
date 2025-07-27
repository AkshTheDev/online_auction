package com.auctionsite.dao;
import com.auctionsite.model.Bid;
import java.util.List;
import java.time.LocalDateTime;

public interface BidDAO {
    void placeBid(Bid bid);
    Bid getHighestBid(int itemId);
    List<Bid> getBidHistory(int itemId);
    int countBidsByUserInPeriod(int userId, LocalDateTime start, LocalDateTime end);
}

