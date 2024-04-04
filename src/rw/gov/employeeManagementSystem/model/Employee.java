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
public class Employee {
    private int id;
    private String names;
    private String gender;
    private String email;
    private int job_id;

    public Employee() {
    }

    public Employee(int id, String names, String gender, String email, int job_id) {
        this.id = id;
        this.names = names;
        this.gender = gender;
        this.email = email;
        this.job_id = job_id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
    
    
    
}
