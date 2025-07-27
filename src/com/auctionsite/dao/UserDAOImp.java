package com.auctionsite.dao;
import com.auctionsite.model.User;
import com.auctionsite.utils.CreateConnection;

import java.sql.*;

import com.auctionsite.utils.KycStatus;

public class UserDAOImp implements UserDAO {
    private final Connection con = CreateConnection.getConnection();

    public void RegisterUser(User user) {
        try{
        PreparedStatement ps = con.prepareStatement("INSERT INTO users (email, phone, first_name, last_name) VALUES(?,?,?,?)");
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getPhone());
        ps.setString(3,user.getFirst_name());
        ps.setString(4,user.getLast_name());
        ps.executeUpdate();
        System.out.println();
        ps.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public User getUserByEmail(String email){
        String query = "SELECT * FROM users WHERE email = ?";
        try{
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,email);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            mapUser(rs);

        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    };

    public User getUserById(int userId){
        String query = "SELECT * FROM users WHERE user_id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                mapUser(rs);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean exist(User user){
        String query = "SELECT * FROM users WHERE user_id = ?";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,user.getUser_id());
            ResultSet rs = ps.executeQuery();
            if(rs.next() && rs.getInt("user_id") == user.getUser_id()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("user_id"),rs.getString("email"),
                rs.getString("phone"),rs.getString("first_name"),rs.getString("last_name"),
                KycStatus.valueOf(rs.getString("kyc_status")), rs.getTimestamp("kyc_verified_at").toLocalDateTime(),
                rs.getTimestamp("created_at").toLocalDateTime(),rs.getTimestamp("updated_at").toLocalDateTime());
    }
}
