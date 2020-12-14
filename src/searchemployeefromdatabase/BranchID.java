package searchemployeefromdatabase;


import searchemployeefromdatabase.interfaces.IDistinctField;
import searchemployeefromdatabase.interfaces.IField;

public class BranchID implements IField, IDistinctField {

    @Override
    public String getWhereClause(String s) {
        return "e.BranchID = " + "'" +s + "'";
    }

    @Override
    public String getDistinctClause() {
        return "SELECT DISTINCT e.BranchID " +
                "FROM EmployeeTable e";
    }
}
