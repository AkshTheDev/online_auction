package com.auctionsite.model;
import com.auctionsite.utils.ItemStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private BigDecimal startPrice;
    private BigDecimal reservePrice;
    private int sellerId;
    private int auctionId;
    private ItemStatus status;
    private BigDecimal listingFee;
    private BigDecimal resHideFee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Item(int itemId, String itemName, String description, BigDecimal startPrice,
                BigDecimal reservePrice, int sellerId, int auctionId, ItemStatus status,
                BigDecimal listingFee, BigDecimal resHideFee,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.startPrice = startPrice;
        this.reservePrice = reservePrice;
        this.sellerId = sellerId;
        this.auctionId = auctionId;
        this.status = status;
        this.listingFee = listingFee;
        this.resHideFee = resHideFee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", startPrice=" + startPrice +
                ", status=" + status +
                ", auctionId=" + auctionId +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be positive");
        }
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public BigDecimal getListingFee() {
        return listingFee;
    }

    public void setListingFee(BigDecimal listingFee) {
        this.listingFee = listingFee;
    }

    public BigDecimal getResHideFee() {
        return resHideFee;
    }

    public void setResHideFee(BigDecimal resHideFee) {
        this.resHideFee = resHideFee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}

