package com.auctionsite.dao;

import com.auctionsite.model.Auction;
import com.auctionsite.dao.AuctionDAO;
import com.auctionsite.utils.AuctionStatus;
import com.auctionsite.utils.CreateConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuctionDAOImp implements AuctionDAO {
    private final Connection con = CreateConnection.getConnection();
    @Override
    public List<Auction> getActiveAuctions(){
        String query = "SELECT * FROM auctions WHERE status = ?";
        List<Auction> auctions = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, AuctionStatus.ongoing.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                auctions.add(mapAuction(rs));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return auctions;
    };
    @Override
    public List<Auction> getAuctionsEndingWithinOneHour(){
        String query = "SELECT * FROM auctions WHERE end_time BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 1 HOUR)";
        List<Auction> auctions = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                auctions.add(mapAuction(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auctions;
    };
    @Override
    public void markAuctionAsCompleted(int auctionId) {
        String query = "UPDATE auctions SET status = ? WHERE auction_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, AuctionStatus.completed.toString());
            ps.setInt(2, auctionId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Auction mapAuction(ResultSet rs ) throws SQLException {
        return new Auction(
                rs.getInt("auction_id"),
                rs.getString("auction_name"),
                rs.getTimestamp("start_time").toLocalDateTime(),
                rs.getTimestamp("end_time").toLocalDateTime(),
                AuctionStatus.valueOf(rs.getString("status")),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
