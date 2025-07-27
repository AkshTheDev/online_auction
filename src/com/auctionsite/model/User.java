package com.auctionsite.model;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.auctionsite.utils.KycStatus;

public class User {
    private int user_id;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
    private KycStatus kyc_status;
    private LocalDateTime kyc_verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    public User(int user_id, String email, String phone, String first_name, String last_name, KycStatus kyc_status, LocalDateTime kyc_verified_at, LocalDateTime created_at, LocalDateTime updated_at){
        this.user_id = user_id;
        this.email = email;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.kyc_status = kyc_status;
        this.kyc_verified_at = kyc_verified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public User(String email,String phone,String first_name,String last_name){
        this.email = email;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    @Override
    public String toString(){
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", kyc_status=" + kyc_status +
                ", kyc_verified_at=" + kyc_verified_at +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
    public int getUser_id() {
        return user_id;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public KycStatus getKyc_status() {
        return kyc_status;
    }
    public LocalDateTime getKyc_verified_at() {
        return kyc_verified_at;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setKyc_status(KycStatus kyc_status) {
        this.kyc_status = kyc_status;
    }
    public void setKyc_verified_at(LocalDateTime kyc_verified_at) {
        this.kyc_verified_at = kyc_verified_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
