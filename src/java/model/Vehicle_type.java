/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dzung
 */
public class Vehicle_type {
    private int vehicleTypeId;
    private String name;
    private int capacity;
    private String description;

    public Vehicle_type() {
    }

    public Vehicle_type(int vehicleTypeId, String name, int capacity, String description) {
        this.vehicleTypeId = vehicleTypeId;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
