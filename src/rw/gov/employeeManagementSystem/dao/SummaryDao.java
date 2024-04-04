package rw.gov.employeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SummaryDao {

    private String jdbcURL = "jdbc:mysql://localhost/employee_management_system_db";
    private String user = "root";

    public ResultSet allSummary() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, user, "");
            String sql = " SELECT * FROM employee INNER JOIN job ON employee.job_id = job.id INNER JOIN salary ON salary.job_name = job.name;";
            PreparedStatement pst = connection.prepareStatement(sql);

//            connection.close();
            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
