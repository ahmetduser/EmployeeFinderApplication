package searchemployeefromdatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DistinctValueFinder {

    public ArrayList<String> getListOfDistinctPositionValues(String query) {
        ArrayList<String> distinctPositionList = new ArrayList<>();
        getList(query, distinctPositionList, "Position");
        return distinctPositionList;
    }

    public ArrayList<String> getListOfDistinctBranchIDValues(String query) {
        ArrayList<String> distinctBranchIDList = new ArrayList<>();
        getList(query, distinctBranchIDList, "BranchID");

        return distinctBranchIDList;
    }

    private void getList(String query, ArrayList<String> distinctValues, String field) {
        try (Connection connection = DataBaseConnector.getDBConnection()) {
            Statement statement = connection.createStatement();

            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String val = results.getString(field);
                distinctValues.add(val);
            }
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
