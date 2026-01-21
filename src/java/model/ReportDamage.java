/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dzung
 */
public class ReportDamage {
    private int damageId;
    private int contractId;
    private int responsibleStaffId;
    private String cause;
    private String description;
    private double compensation;

    public ReportDamage() {
    }

    public ReportDamage(int damageId, int contractId, int responsibleStaffId, String cause, String description, double compensation) {
        this.damageId = damageId;
        this.contractId = contractId;
        this.responsibleStaffId = responsibleStaffId;
        this.cause = cause;
        this.description = description;
        this.compensation = compensation;
    }

    public int getDamageId() {
        return damageId;
    }

    public void setDamageId(int damageId) {
        this.damageId = damageId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getResponsibleStaffId() {
        return responsibleStaffId;
    }

    public void setResponsibleStaffId(int responsibleStaffId) {
        this.responsibleStaffId = responsibleStaffId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCompensation() {
        return compensation;
    }

    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }
    
}
