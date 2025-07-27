package com.auctionsite.dao;

import com.auctionsite.model.AuditLog;
import com.auctionsite.utils.CreateConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuditLogDAOImp implements AuditLogDAO {
    private final Connection con = CreateConnection.getConnection();

    @Override
    public void logAction(AuditLog log) {
        String query = "INSERT INTO audit_logs (user_id, item_id, auction_id, action_type, action_title, details, ip_address, user_agent) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, log.getUserId());
            ps.setObject(2, log.getItemId());
            ps.setObject(3, log.getAuctionId());
            ps.setString(4, log.getActionType().toLowerCase());
            ps.setString(5, log.getActionTitle());
            ps.setString(6, log.getDetails().toString());
            ps.setString(7, log.getIpAddress());
            ps.setString(8, log.getUserAgent());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
