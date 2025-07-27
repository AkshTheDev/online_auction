package com.auctionsite.model;
import com.auctionsite.utils.AuctionStatus;
import java.time.LocalDateTime;

public class Auction {
    private int auction_id;
    private String auction_name;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private AuctionStatus auction_status;
    private LocalDateTime created_at;
    public Auction(int auction_id,String auction_name,LocalDateTime start_time,LocalDateTime end_time,AuctionStatus auction_status,LocalDateTime created_at){
        this.auction_id = auction_id;
        this.auction_name = auction_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.auction_status = auction_status;
        this.created_at = created_at;

    }
    @Override
    public String toString() {
        return "Auction{" +
                "auction_id=" + auction_id +
                ", auction_name='" + auction_name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", auction_status=" + auction_status +
                ", created_at=" + created_at +
                '}';
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        if(auction_id <= 0){
            throw new IllegalArgumentException("auction_id must be a positive number");
        }
        this.auction_id = auction_id;
    }

    public String getAuction_name() {
        return auction_name;
    }

    public void setAuction_name(String auction_name) {
        this.auction_name = auction_name;
    }
    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public AuctionStatus getAuction_status() {
        return auction_status;
    }

    public void setAuction_status(AuctionStatus auction_status) {
        this.auction_status = auction_status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
