/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dzung
 */
public class Vehicle {
    private int vehicleId;
    private int vehicleManagerStaffId;
    private int vehicleTypeId;
    private String plateNumber;
    private String status;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, int vehicleManagerStaffId, int vehicleTypeId, String plateNumber, String status) {
        this.vehicleId = vehicleId;
        this.vehicleManagerStaffId = vehicleManagerStaffId;
        this.vehicleTypeId = vehicleTypeId;
        this.plateNumber = plateNumber;
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getVehicleManagerStaffId() {
        return vehicleManagerStaffId;
    }

    public void setVehicleManagerStaffId(int vehicleManagerStaffId) {
        this.vehicleManagerStaffId = vehicleManagerStaffId;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
