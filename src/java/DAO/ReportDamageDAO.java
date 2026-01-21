/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.ReportDamage;
import utils.DButil;
import java.sql.*;
/**
 *
 * @author Dzung
 */
public class ReportDamageDAO {
    public void reportDamage(ReportDamage r) throws Exception {
        String sql = """
            INSERT INTO Report_Damage
            (contract_id, cause, responsible_staff_id, description, compensation)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection con = DButil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getContractId());
            ps.setString(2, r.getCause());
            ps.setInt(3, r.getResponsibleStaffId());
            ps.setString(4, r.getDescription());
            ps.setDouble(5, r.getCompensation());

            ps.executeUpdate();
        }
    }
}
