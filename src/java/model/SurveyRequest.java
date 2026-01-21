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
public class SurveyRequest {
    private int requestId;
    private int customerId;
    private int serviceId;
    private String pickupAddress;
    private String destinationAddress;
    private LocalDateTime startDate;
    private int numStaff;
    private double estimatedPrice;
    private double estimatedDistanceKm;
    private String status;

    public SurveyRequest() {
    }

    public SurveyRequest(int requestId, int customerId, int serviceId, String pickupAddress, String destinationAddress, LocalDateTime startDate, int numStaff, double estimatedPrice, double estimatedDistanceKm, String status) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.startDate = startDate;
        this.numStaff = numStaff;
        this.estimatedPrice = estimatedPrice;
        this.estimatedDistanceKm = estimatedDistanceKm;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int getNumStaff() {
        return numStaff;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public double getEstimatedDistanceKm() {
        return estimatedDistanceKm;
    }

    public String getStatus() {
        return status;
    }
    
    
    
}
