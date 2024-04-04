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
import rw.gov.employeeManagementSystem.model.Job;

/**
 *
 * @author ZIPTECH LTD
 */
public class JobDao {

    private String jdbcURL = "jdbc:mysql://localhost/employee_management_system_db";
    private String user = "root";
    Scanner input = new Scanner(System.in);

    public Integer register(Job jobObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "INSERT INTO job (name, department, description)  VALUES(?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, jobObj.getName());
            pst.setString(2, jobObj.getDepartmentName());
            pst.setString(3, jobObj.getDescription());

            int rowsAffected = pst.executeUpdate();
            connection.close();
            return rowsAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet allJobs() {
        try {

            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "SELECT * FROM job";
            PreparedStatement pst = connection.prepareStatement(sql);

            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer update(Job jobObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "  UPDATE job SET name = ?, department = ?, description = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, jobObj.getName());
            pst.setString(2, jobObj.getDepartmentName());
            pst.setString(3, jobObj.getDescription());
            pst.setInt(4, jobObj.getId());

            Integer rowsAffected = pst.executeUpdate();
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
            String sql = "DELETE FROM job WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, theId);

            Integer rowsAffected = pst.executeUpdate();
            connection.close();
            return rowsAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet search(String searchTxt) {
        try {

            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "SELECT * FROM job WHERE name LIKE ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + searchTxt + "%");

            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
