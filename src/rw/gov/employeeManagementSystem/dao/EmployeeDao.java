/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.employeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import rw.gov.employeeManagementSystem.model.Employee;

/**
 *
 * @author ZIPTECH LTD
 */
public class EmployeeDao {

    private String jdbcURL = "jdbc:mysql://localhost/employee_management_system_db";
    private String user = "root";
    Scanner input = new Scanner(System.in);

    public Integer register(Employee empObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "INSERT INTO employee (names, gender, email, job_id)  VALUES(?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, empObj.getNames());
            pst.setString(2, empObj.getGender());
            pst.setString(3, empObj.getEmail());
            pst.setInt(4, empObj.getJob_id());

            int rowsAffected = pst.executeUpdate();
            connection.close();

            return rowsAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet allEmp() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "SELECT employee.id, employee.names, employee.gender, employee.email, job.id as jId FROM employee, job WHERE employee.job_id = job.id";
            PreparedStatement pst = connection.prepareStatement(sql);

            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer update(Employee empObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "UPDATE employee SET names = ?, gender = ?, email = ?, job_id = ? WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, empObj.getNames());
            pst.setString(2, empObj.getGender());
            pst.setString(3, empObj.getEmail());
            pst.setInt(4, empObj.getJob_id());
            pst.setInt(5, empObj.getId());

            int rowsAffected = pst.executeUpdate();
            connection.close();

            return rowsAffected;
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
        public Integer delete(int theId) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, theId);

            int rowsAffected = pst.executeUpdate();
            connection.close();

            return rowsAffected;
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
        
    public ResultSet searchEmp(String searchTxt) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
//            String query = "SELECT DISTINCT employee.id, employee.names, employee.gender, employee.email, job.name\n"
//                    + "FROM employee\n"
//                    + "INNER JOIN job ON employee.job_id = job.id\n"
//                    + "WHERE employee.names LIKE ? OR employee.email LIKE ? OR job.name LIKE ?";
            String query = "SELECT employee.id, employee.names, employee.gender, employee.email, job.id as jId FROM employee, job WHERE employee.job_id = job.id AND employee.names LIKE ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "%" + searchTxt + "%");
//            pst.setString(2, "%" + searchTxt + "%");
//            pst.setString(3, "%" + searchTxt + "%");

            ResultSet rs =  pst.executeQuery();
//            connection.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
        
}
