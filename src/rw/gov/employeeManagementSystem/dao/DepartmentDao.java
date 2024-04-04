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
import rw.gov.employeeManagementSystem.model.Department;

/**
 *
 * @author ZIPTECH LTD
 */
public class DepartmentDao {

    private String jdbcURL = "jdbc:mysql://localhost/employee_management_system_db";
    private String user = "root";
    Scanner input = new Scanner(System.in);

    public Integer register(Department bookObj) {

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "INSERT INTO department (name)  VALUES(?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, bookObj.getName());

            int rowsAffected = pst.executeUpdate();
            connection.close();
            return rowsAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public ResultSet allDepartments() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String query = "SELECT * FROM department";
            PreparedStatement pst = connection.prepareStatement(query);

            return pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer update(Department dptObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "UPDATE department SET name = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, dptObj.getName());
            pst.setInt(2, dptObj.getId());

            int rowAffected = pst.executeUpdate();
            connection.close();
            return rowAffected;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer delete(int theId) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "DELETE FROM department WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, theId);

            int rowAffected = pst.executeUpdate();
            connection.close();
            return rowAffected;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet searchDepartments(String searchTxt) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String query = "SELECT * FROM department where name LIKE  ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "%" + searchTxt + "%");

            return pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
