/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.Contract;
import java.sql.*;
import utils.DButil;
/**
 *
 * @author Dzung
 */
public class ContractDAO extends DButil{
    public void createContract(Contract c) throws Exception {
        String sql = """
            INSERT INTO Contract
            (s_request_id, num_staff, deposit_amount, total_amount,
             start_date, end_date, status, vehicle_id)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, c.getSurveyRequestId());
            ps.setInt(2, c.getNumStaff());
            ps.setDouble(3, c.getDepositAmount());
            ps.setDouble(4, c.getTotalAmount());
            ps.setTimestamp(5, Timestamp.valueOf(c.getStartDate()));
            ps.setTimestamp(6, Timestamp.valueOf(c.getEndDate()));
            ps.setString(7, c.getStatus());
            ps.setObject(8, c.getVehicleId(), Types.INTEGER);

            ps.executeUpdate();
        }
    }

    public void updateStatus(int contractId, String status) throws Exception {
        String sql = "UPDATE Contract SET status = ? WHERE contract_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, contractId);
            ps.executeUpdate();
        }
    }
}
