/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.employeeManagementSystem.model;

/**
 *
 * @author ZIPTECH LTD
 */
public class Salary {
    private int id;
    private String jobName;
    private int amount;
    private int anual;
    private int bonus;

    public Salary() {
    }

    
    
    public Salary(int id, String jobName, int amount, int anual, int bonus) {
        this.id = id;
        this.jobName = jobName;
        this.amount = amount;
        this.anual = anual;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAnual() {
        return anual;
    }

    public void setAnual(int anual) {
        this.anual = anual;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    
    

    
}
