/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.ContractStaff;
import utils.DButil;
import java.sql.*;
/**
 *
 * @author Dzung
 */
public class ContractStaffDAO {
    public void assignStaff(ContractStaff cs) throws Exception {
        String sql = "INSERT INTO Contract_Staff(contract_id, staff_id) VALUES (?, ?)";
        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cs.getContractId());
            ps.setInt(2, cs.getStaffId());
            ps.executeUpdate();
        }
    }
}
