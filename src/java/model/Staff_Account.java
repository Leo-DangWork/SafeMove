/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dzung
 */
public class Staff_Account {
    private int staffAccId;
    private int leaderStaffId;
    private String username;
    private String password;

    public Staff_Account() {
    }

    public Staff_Account(int staffAccId, int leaderStaffId, String username, String password) {
        this.staffAccId = staffAccId;
        this.leaderStaffId = leaderStaffId;
        this.username = username;
        this.password = password;
    }

    public int getStaffAccId() {
        return staffAccId;
    }

    public void setStaffAccId(int staffAccId) {
        this.staffAccId = staffAccId;
    }

    public int getLeaderStaffId() {
        return leaderStaffId;
    }

    public void setLeaderStaffId(int leaderStaffId) {
        this.leaderStaffId = leaderStaffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
