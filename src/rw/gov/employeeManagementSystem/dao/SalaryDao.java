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
import rw.gov.employeeManagementSystem.model.Salary;

/**
 *
 * @author ZIPTECH LTD
 */
public class SalaryDao {

    private String jdbcURL = "jdbc:mysql://localhost/employee_management_system_db";
    private String user = "root";
    Scanner input = new Scanner(System.in);

    public Integer register(Salary salaryObj) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "INSERT INTO salary (job_name, amount, anual, bonus)  VALUES(?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, salaryObj.getJobName());
            pst.setInt(2, salaryObj.getAmount());
            pst.setInt(3, salaryObj.getAnual());
            pst.setInt(4, salaryObj.getBonus());

            int rowsAffected = pst.executeUpdate();
            connection.close();
            return rowsAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public ResultSet allSalaries() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "SELECT salary.id, salary.amount, salary.anual, salary.bonus, salary.job_name FROM salary";
            PreparedStatement pst = connection.prepareStatement(sql);

//            connection.close();
            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer update(Salary salaryObj) {

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "UPDATE salary SET job_name = ?,  amount = ?, anual = ?, bonus = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, salaryObj.getJobName());
            pst.setInt(2, salaryObj.getAmount());
            pst.setInt(3, salaryObj.getAnual());
            pst.setInt(4, salaryObj.getBonus());
            pst.setInt(5, salaryObj.getId());

            int rowAffected = pst.executeUpdate();
            connection.close();
            return rowAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public Integer delete(int theId) {

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = "DELETE FROM salary WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, theId);

            int rowAffected = pst.executeUpdate();
            connection.close();
            return rowAffected;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public ResultSet searchSalary(String searchTxt) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String query = "SELECT * FROM salary WHERE amount LIKE ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, "%" + searchTxt + "%");

            return pst.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
