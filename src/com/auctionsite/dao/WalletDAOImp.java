package com.auctionsite.dao;

import com.auctionsite.model.Wallet;
import com.auctionsite.utils.CreateConnection;
import com.auctionsite.utils.WalletStatus;

import java.sql.Connection;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletDAOImp implements WalletDAO {
    private Connection con = CreateConnection.getConnection();
    @Override
    public Wallet getWalletByUser(int userId){
        String query = "select * from wallet where user_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               return mapWallet(rs);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    };
    @Override
    public void updateBalance(int walletId, BigDecimal newBalance){
        String query = "update wallet set balance = ? where wallet_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBigDecimal(1, newBalance);
            ps.setInt(2,walletId);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    };
    @Override
    public void activateWallet(int walletId){
        updateWalletStatus(walletId, WalletStatus.active);
    };
    @Override
    public void blockWallet(int walletId){
        updateWalletStatus(walletId, WalletStatus.blocked);

    };
    @Override
    public void suspendWallet(int walletId){
        updateWalletStatus(walletId, WalletStatus.suspended);

    };
    @Override
    public void createWalletForUser(int userId) {
        String query = "INSERT INTO wallet (user_id) VALUES (?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateWalletStatus(int walletId, WalletStatus status) {
        String query = "UPDATE wallet SET status = ? WHERE wallet_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, status.name());
            ps.setInt(2, walletId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Wallet mapWallet(ResultSet rs) throws SQLException {
        return new Wallet(
                rs.getInt("wallet_id"),
                rs.getInt("user_id"),
                rs.getBigDecimal("balance"),
                WalletStatus.valueOf(rs.getString("status")),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}
