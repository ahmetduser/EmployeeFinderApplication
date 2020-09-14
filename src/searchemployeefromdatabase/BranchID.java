package searchemployeefromdatabase;


public class BranchID implements IField, IDistinctField{

    @Override
    public String getWhereClause(String restrict) {
        return "e.BranchID = " + "'" +restrict + "'";
    }

    @Override
    public String getDistinctClause() {
        return "SELECT DISTINCT e.BranchID " +
                "FROM EmployeeTable e";
    }
}
