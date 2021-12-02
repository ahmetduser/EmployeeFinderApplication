package searchemployeefromdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class QueryRunner {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public String setQueryWithWhereClause(List<String> listOfWhereClause) {
        int indexOfLastItem = listOfWhereClause.size() - 1;

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SELECT e.Name, e.Surname, e.BranchID, e.Position, e.Wage, e.HiredDate ");
        strBuilder.append("FROM EmployeeTable e ");
        strBuilder.append("WHERE ");
        for (int i = 0; i < listOfWhereClause.size(); i++) {
            strBuilder.append(listOfWhereClause.get(i));

            if (listOfWhereClause.size() > 1) {
                // to avoid putting an extra AND keyword
                if (i != indexOfLastItem) {
                    strBuilder.append(" AND ");
                }
            }
        }
        return strBuilder.toString();
    }

    public ObservableList<BeanEmployees> getResult(String query) {
        ObservableList<BeanEmployees> result = FXCollections.observableArrayList();
        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            BeanEmployees emp = null;

            while (rs.next()) {
                emp = new BeanEmployees();

                emp.setEmployeeName(rs.getString("Name"));
                emp.setEmployeeSurname(rs.getString("Surname"));
                emp.setEmployeeBranchID(rs.getString("BranchID"));
                emp.setEmployeePosition(rs.getString("Position"));
                emp.setEmployeeWage(rs.getDouble("Wage"));
                emp.setEmployeeHireDate(rs.getDate("HiredDate"));

                result.add(emp);
                errorMessage = "";
            }

            if(result.size() == 0) {
                errorMessage = "Employee is not exists";
            }
        } catch (SQLException e) {
            errorMessage = "Please check your inputs";
        }
        return result;
    }
}
