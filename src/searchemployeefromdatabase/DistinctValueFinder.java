package searchemployeefromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DistinctValueFinder {

    public ArrayList<String> getListOfDistinctPositionValues(String query) {
        ArrayList<String> distinctPosition = new ArrayList<>();
        getList(query, distinctPosition, "Position");
        return distinctPosition;
    }

    public ArrayList<String> getListOfDistinctBranchIDValues(String query) {
        ArrayList<String> distinctBranchID = new ArrayList<>();
        getList(query, distinctBranchID, "BranchID");

        return distinctBranchID;
    }

    private void getList(String query, ArrayList<String> distinctPosition, String field) {
        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String employeePosition = results.getString(field);
                distinctPosition.add(employeePosition);
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
