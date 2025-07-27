package com.auctionsite.model;

import com.auctionsite.utils.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WinningBid {
    private int win_id;
    private int item_id;
    private int bid_id;
    private BigDecimal conversion_fee;
    private BigDecimal transaction_fee;
    private TransactionStatus payment_status; // enum: 'pending', 'paid', 'failed'
    private LocalDateTime created_at;

    // Constructor with all fields (used when loading from DB)
    public WinningBid(int win_id, int item_id, int bid_id, BigDecimal conversion_fee,
                      BigDecimal transaction_fee, TransactionStatus payment_status, LocalDateTime created_at) {
        this.win_id = win_id;
        this.item_id = item_id;
        this.bid_id = bid_id;
        this.conversion_fee = conversion_fee;
        this.transaction_fee = transaction_fee;
        this.payment_status = payment_status;
        this.created_at = created_at;
    }

    // Constructor without win_id and created_at (used when inserting new win)
    public WinningBid(int item_id, int bid_id, BigDecimal conversion_fee,
                      BigDecimal transaction_fee, TransactionStatus payment_status) {
        this.item_id = item_id;
        this.bid_id = bid_id;
        this.conversion_fee = conversion_fee;
        this.transaction_fee = transaction_fee;
        this.payment_status = payment_status;
    }

    // Getters and Setters
    public int getWin_id() {
        return win_id;
    }

    public void setWin_id(int win_id) {
        this.win_id = win_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getBid_id() {
        return bid_id;
    }

    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    public BigDecimal getConversion_fee() {
        return conversion_fee;
    }

    public void setConversion_fee(BigDecimal conversion_fee) {
        this.conversion_fee = conversion_fee;
    }

    public BigDecimal getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(BigDecimal transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public TransactionStatus getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(TransactionStatus payment_status) {
        this.payment_status = payment_status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
