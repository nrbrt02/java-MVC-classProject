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
public class Job {

    private int id;
    private String name;
    private String description;
    private String departmentName;

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Job(int id, String name, String description, String departmentName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.departmentName = departmentName;
    }

    

}
