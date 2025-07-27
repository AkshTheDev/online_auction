package com.auctionsite.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WalletTransactionBreakdown {

    private int breakdownId;
    private Integer walletTransactionId;
    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;

    public WalletTransactionBreakdown(int breakdownId, Integer walletTransactionId, BigDecimal amount,
                                      String description, LocalDateTime createdAt) {
        this.breakdownId = breakdownId;
        this.walletTransactionId = walletTransactionId;
        this.amount = amount;
        this.description = description;
        this.createdAt = createdAt;
    }

    public WalletTransactionBreakdown(Integer walletTransactionId, BigDecimal amount, String description) {
        this.walletTransactionId = walletTransactionId;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Breakdown{" +
                "breakdownId=" + breakdownId +
                ", walletTransactionId=" + walletTransactionId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
    public int getBreakdownId() {
        return breakdownId;
    }

    public void setBreakdownId(int breakdownId) {
        this.breakdownId = breakdownId;
    }

    public Integer getWalletTransactionId() {
        return walletTransactionId;
    }

    public void setWalletTransactionId(Integer walletTransactionId) {
        this.walletTransactionId = walletTransactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
