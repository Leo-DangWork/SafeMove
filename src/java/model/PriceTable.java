/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dzung
 */
public class PriceTable {
    private int priceId;
    private int serviceId;
    private double minDistanceKm;
    private double maxDistanceKm;
    private double pricePerKm;

    public PriceTable() {
    }

    public PriceTable(int priceId, int serviceId, double minDistanceKm, double maxDistanceKm, double pricePerKm) {
        this.priceId = priceId;
        this.serviceId = serviceId;
        this.minDistanceKm = minDistanceKm;
        this.maxDistanceKm = maxDistanceKm;
        this.pricePerKm = pricePerKm;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getMinDistanceKm() {
        return minDistanceKm;
    }

    public void setMinDistanceKm(double minDistanceKm) {
        this.minDistanceKm = minDistanceKm;
    }

    public double getMaxDistanceKm() {
        return maxDistanceKm;
    }

    public void setMaxDistanceKm(double maxDistanceKm) {
        this.maxDistanceKm = maxDistanceKm;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }
    
}
