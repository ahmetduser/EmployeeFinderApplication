package searchemployeefromdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SelectAll {

    public ObservableList<BeanEmployees> getAllEmployees(){
        ObservableList<BeanEmployees> result = FXCollections.observableArrayList();

        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            String QUERY = "SELECT e.Name, e.Surname, e.BranchID, e.Position, e.Wage, e.HiredDate " +
                           "FROM EmployeeTable e";
            ResultSet rs = statement.executeQuery(QUERY);

            BeanEmployees emp = null;

            while(rs.next()) {
                emp = new BeanEmployees();

                emp.setEmployeeName(rs.getString("Name"));
                emp.setEmployeeSurname(rs.getString("Surname"));
                emp.setEmployeeBranchID(rs.getString("BranchID"));
                emp.setEmployeePosition(rs.getString("Position"));
                emp.setEmployeeWage(rs.getDouble("Wage"));
                emp.setEmployeeHireDate(rs.getDate("HiredDate"));

                result.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        return result;
    }
}
