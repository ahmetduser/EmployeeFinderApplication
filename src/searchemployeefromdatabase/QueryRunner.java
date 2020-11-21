package searchemployeefromdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class QueryRunner {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public String setQueryWithWhereClause(List<String> listOfWhereClause){
        int indexOfLastItem = listOfWhereClause.size() - 1;

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SELECT e.Name, e.Surname, e.BranchID, e.Position, e.Wage, e.HiredDate ");
        strBuilder.append("FROM EmployeeTable e ");
        strBuilder.append("WHERE ");
        for(int i=0; i<listOfWhereClause.size(); i++){
            strBuilder.append(listOfWhereClause.get(i));

            if(listOfWhereClause.size() > 1){
                // to avoid putting an extra AND keyword
                if(i != indexOfLastItem){
                    strBuilder.append(" AND ");
                }
            }
        }
        return strBuilder.toString();
    }

    public ObservableList<String> getResult(String query) {
        ObservableList<String> result = FXCollections.observableArrayList();
        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

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
				
				errorMessage = "";
            }
            if(result.size() == 0){
                result.add("Employee is not exists");
            }
        } catch (SQLException e) {
            errorMessage = "Please check your inputs";
        }
        return result;
    }
}
