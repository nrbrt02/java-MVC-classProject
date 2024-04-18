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
            String sql = " SELECT * FROM employee INNER JOIN JOB ON employee.job_id = job.id";
            PreparedStatement pst = connection.prepareStatement(sql);

//            connection.close();
            return pst.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
