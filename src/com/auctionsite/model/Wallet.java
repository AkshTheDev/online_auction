package com.auctionsite.model;

import com.auctionsite.utils.WalletStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {

    private int wallet_id;
    private int user_id;
    private BigDecimal balance;
    private WalletStatus status;
    private LocalDateTime created_at;


    public Wallet(int wallet_id, int user_id, BigDecimal balance, WalletStatus status, LocalDateTime created_at) {
        this.wallet_id = wallet_id;
        this.user_id = user_id;
        this.balance = balance;
        this.status = status;
        this.created_at = created_at;
    }


    public Wallet(int user_id, BigDecimal balance, WalletStatus status) {
        this.user_id = user_id;
        this.balance = balance;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Wallet{" +
                "wallet_id=" + wallet_id +
                ", user_id=" + user_id +
                ", balance=" + balance +
                ", status=" + status +
                ", created_at=" + created_at +
                '}';
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public WalletStatus getStatus() {
        return status;
    }

    public void setStatus(WalletStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }


}
