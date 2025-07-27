package com.auctionsite.model;

import java.time.LocalDateTime;

public class AuditLog {
    private int logId;
    private Integer userId;
    private Integer itemId;
    private Integer auctionId;
    private String actionType;     // Optionally use Enum
    private String actionTitle;
    private String details;        // Stored as JSON string
    private String ipAddress;
    private String userAgent;
    private LocalDateTime createdAt;

    // --- Constructor ---
    public AuditLog(Integer userId, Integer itemId, Integer auctionId, String actionType,
                    String actionTitle, String details, String ipAddress, String userAgent) {
        this.userId = userId;
        this.itemId = itemId;
        this.auctionId = auctionId;
        this.actionType = actionType;
        this.actionTitle = actionTitle;
        this.details = details;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.createdAt = LocalDateTime.now(); // Can also be handled by DB
    }

    // --- Getters and Setters ---
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionTitle() {
        return actionTitle;
    }

    public void setActionTitle(String actionTitle) {
        this.actionTitle = actionTitle;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "AuditLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", auctionId=" + auctionId +
                ", actionType='" + actionType + '\'' +
                ", actionTitle='" + actionTitle + '\'' +
                ", details='" + details + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
