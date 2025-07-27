package com.auctionsite.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bid {
    private int bidId;
    private int itemId;
    private int bidderId;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    // Constructor with all fields
    public Bid(int bidId, int itemId, int bidderId, BigDecimal amount, LocalDateTime timestamp) {
        this.bidId = bidId;
        this.itemId = itemId;
        this.bidderId = bidderId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Constructor without bidId (for insertion)
    public Bid(int itemId, int bidderId, BigDecimal amount) {
        this.itemId = itemId;
        this.bidderId = bidderId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // or leave null if DB handles it
    }

    // Getters and Setters
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", itemId=" + itemId +
                ", bidderId=" + bidderId +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
