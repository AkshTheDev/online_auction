package com.auctionsite.dao;

import com.auctionsite.model.Bid;
import com.auctionsite.utils.CreateConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BidDAOImp implements BidDAO {
    private final Connection connection = CreateConnection.getConnection();

    @Override
    public void placeBid(Bid bid) {
        String query = "INSERT INTO bids (item_id, bidder_id, amount, timestamp) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, bid.getItemId());
            ps.setInt(2, bid.getBidderId());
            ps.setBigDecimal(3, bid.getAmount());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bid getHighestBid(int itemId) {
        String query = "SELECT * FROM bids WHERE item_id = ? ORDER BY amount DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapBid(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Bid> getBidHistory(int itemId) {
        List<Bid> bids = new ArrayList<>();
        String query = "SELECT * FROM bids WHERE item_id = ? ORDER BY timestamp DESC";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bids.add(mapBid(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bids;
    }

    @Override
    public int countBidsByUserInPeriod(int userId, LocalDateTime start, LocalDateTime end) {
        String query = "SELECT COUNT(*) FROM bids WHERE bidder_id = ? AND timestamp BETWEEN ? AND ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setTimestamp(2, Timestamp.valueOf(start));
            ps.setTimestamp(3, Timestamp.valueOf(end));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Bid mapBid(ResultSet rs) throws SQLException {
        return new Bid(
                rs.getInt("bid_id"),
                rs.getInt("item_id"),
                rs.getInt("bidder_id"),
                rs.getBigDecimal("amount"),
                rs.getTimestamp("timestamp").toLocalDateTime()
        );
    }
}
