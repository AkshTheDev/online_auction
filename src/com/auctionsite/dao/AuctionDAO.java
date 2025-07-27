package com.auctionsite.dao;
import com.auctionsite.model.Auction;
import java.util.List;

public interface AuctionDAO {
    List<Auction> getActiveAuctions();
    List<Auction> getAuctionsEndingWithinOneHour();
    void markAuctionAsCompleted(int auctionId);
}

