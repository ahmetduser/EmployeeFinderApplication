package searchemployeefromdatabase;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DataBaseConnectorTest {

    Connection con= DataBaseConnector.getDBConnection();

    @Test
    void DBConnectionIsNotNull() {
        assertNotNull(con);
    }

    @Test
    void queryAgainstDataBase() throws SQLException {
        Statement stat = con.createStatement();

        String query = "SELECT * FROM EmployeeTable";

        String employeeName = null;
        String employeeSurname;
        String employeeBranchID;
        String employeePosition;
        Double employeeWage;
        Date employeeHireDate;


        ResultSet rs = stat.executeQuery(query);
        while(rs.next()) {
            employeeName = rs.getString("Name");
            employeeSurname = rs.getString("Surname");
            employeeBranchID = rs.getString("BranchID");
            employeePosition = rs.getString("Position");
            employeeWage = rs.getDouble("Wage");
            employeeHireDate = rs.getDate("HiredDate");

            assertNotNull(employeeName);
            System.out.println(employeeName);
        }
    }
}