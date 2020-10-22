package searchemployeefromdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SelectAll {

    private final String QUERY = "SELECT e.Name, e.Surname, e.BranchID, e.Position, e.Wage, e.HiredDate FROM EmployeeTable e";

    public ObservableList<String> getAllEmployees(){
        ObservableList<String> result = FXCollections.observableArrayList();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(QUERY);

            String employeeName;
            String employeeSurname;
            String employeeBranchID;
            String employeePosition ;
            double employeeWage;
            Date employeeHireDate;

            while (rs.next()) {
                employeeName = rs.getString("Name");
                employeeSurname = rs.getString("Surname");
                employeeBranchID = rs.getString("BranchID");
                employeePosition = rs.getString("Position");
                employeeWage = rs.getDouble("Wage");
                employeeHireDate = rs.getDate("HiredDate");

                result.addAll(employeeName + " | " + employeeSurname + " | " + employeeBranchID
                        + " | " + employeePosition + " | " + employeeWage + " | " + employeeHireDate);
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return result;
    }

}
