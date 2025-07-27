package com.auctionsite.model;
import com.auctionsite.utils.TransactionStatus;
import com.auctionsite.utils.AccountTransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountTransaction {

    private int accountTransactionId;
    private Integer walletId;
    private Integer bankAccountId;
    private BigDecimal amount;
    private AccountTransactionType transactionType;
    private TransactionStatus transactionStatus;
    private LocalDateTime createdAt;

    public AccountTransaction(int accountTransactionId, Integer walletId, Integer bankAccountId,
                              BigDecimal amount, AccountTransactionType transactionType,
                              TransactionStatus transactionStatus, LocalDateTime createdAt) {
        this.accountTransactionId = accountTransactionId;
        this.walletId = walletId;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
        this.createdAt = createdAt;
    }

    // Minimal constructor (e.g., for creating new transaction)
    public AccountTransaction(Integer walletId, Integer bankAccountId, BigDecimal amount,
                              AccountTransactionType transactionType, TransactionStatus transactionStatus) {
        this.walletId = walletId;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }
    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransactionId=" + accountTransactionId +
                ", walletId=" + walletId +
                ", bankAccountId=" + bankAccountId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", transactionStatus=" + transactionStatus +
                ", createdAt=" + createdAt +
                '}';
    }

    public int getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(int accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public AccountTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(AccountTransactionType transactionType) {
        this.transactionType = transactionType;
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

}
