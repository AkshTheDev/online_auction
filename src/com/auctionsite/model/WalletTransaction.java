package com.auctionsite.model;
import com.auctionsite.utils.TransactionStatus;
import com.auctionsite.utils.WalletTransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WalletTransaction {

    private int walletTransactionId;
    private Integer fromWalletId;
    private Integer toWalletId;
    private BigDecimal amount;
    private WalletTransactionType transactionType;
    private TransactionStatus transactionStatus;
    private LocalDateTime createdAt;

    public WalletTransaction(int walletTransactionId, Integer fromWalletId, Integer toWalletId, BigDecimal amount,
                             WalletTransactionType walletTransactionType, TransactionStatus transactionStatus,
                             LocalDateTime createdAt) {
        this.walletTransactionId = walletTransactionId;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.transactionType = walletTransactionType;
        this.transactionStatus = transactionStatus;
        this.createdAt = createdAt;
    }

    // Constructor for inserting new transaction
    public WalletTransaction(Integer fromWalletId, Integer toWalletId, BigDecimal amount,
                             WalletTransactionType walletTransactionType, TransactionStatus transactionStatus) {
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.transactionType = walletTransactionType;
        this.transactionStatus = transactionStatus;
    }

    // Getters and Setters
    @Override
    public String toString() {
        return "WalletTransaction{" +
                "walletTransactionId=" + walletTransactionId +
                ", fromWalletId=" + fromWalletId +
                ", toWalletId=" + toWalletId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", transactionStatus=" + transactionStatus +
                ", createdAt=" + createdAt +
                '}';
    }
    public int getWalletTransactionId() {
        return walletTransactionId;
    }

    public void setWalletTransactionId(int walletTransactionId) {
        this.walletTransactionId = walletTransactionId;
    }

    public Integer getFromWalletId() {
        return fromWalletId;
    }

    public void setFromWalletId(Integer fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public Integer getToWalletId() {
        return toWalletId;
    }

    public void setToWalletId(Integer toWalletId) {
        this.toWalletId = toWalletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public WalletTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(WalletTransactionType walletTransactionType) {
        this.transactionType = walletTransactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // toString for logging/debugging

}
