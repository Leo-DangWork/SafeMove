/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Dzung
 */
public class Contract {
    private int contractId;
    private int surveyRequestId;
    private int numStaff;
    private double depositAmount;
    private double totalAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private Integer vehicleId;

    public Contract() {
    }

    public Contract(int contractId, int surveyRequestId, int numStaff, double depositAmount, double totalAmount, LocalDateTime startDate, LocalDateTime endDate, String status, Integer vehicleId) {
        this.contractId = contractId;
        this.surveyRequestId = surveyRequestId;
        this.numStaff = numStaff;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.vehicleId = vehicleId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getSurveyRequestId() {
        return surveyRequestId;
    }

    public void setSurveyRequestId(int surveyRequestId) {
        this.surveyRequestId = surveyRequestId;
    }

    public int getNumStaff() {
        return numStaff;
    }

    public void setNumStaff(int numStaff) {
        this.numStaff = numStaff;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
    
}
