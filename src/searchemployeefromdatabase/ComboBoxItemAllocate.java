package searchemployeefromdatabase;

import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class ComboBoxItemAllocate {

    private final DistinctValueFinder distinctValueFinder = new DistinctValueFinder();

    public void putBranchIDItems(ComboBox<String> cb) {
        IDistinctField branchID = new BranchID();
        String branchIDDistinctClause = branchID.getDistinctClause();
        ArrayList<String> listOfDistinctBranchIDs = distinctValueFinder.getListOfDistinctBranchIDValues(branchIDDistinctClause);

        for(String s : listOfDistinctBranchIDs){
            cb.getItems().add(s);
        }
        cb.getItems().add("Clear Selection");
    }

    public void putPositionItems(ComboBox<String> cb) {
        IDistinctField position = new Position();
        String positionDistinctClause = position.getDistinctClause();
        ArrayList<String> listOfDistinctPositions = distinctValueFinder.getListOfDistinctPositionValues(positionDistinctClause);

        for(String s : listOfDistinctPositions){
            cb.getItems().add(s);
        }
        cb.getItems().add("Clear Selection");
    }

    public void putWageItems(ComboBox<String> cb){
        cb.getItems().add("More than 1000$");
        cb.getItems().add("More than 5000$");
        cb.getItems().add("More than 15000$");
        cb.getItems().add("Clear Selection");
    }

    public void putHiredDateItems(ComboBox<String> cb) {
        cb.getItems().add("Within 2 years");
        cb.getItems().add("Within 6 years");
        cb.getItems().add("Within 12 years");
        cb.getItems().add("Clear Selection");
    }
}
