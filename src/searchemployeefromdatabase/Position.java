package searchemployeefromdatabase;

import searchemployeefromdatabase.interfaces.IDistinctField;
import searchemployeefromdatabase.interfaces.IField;

public class Position implements IField, IDistinctField {

    @Override
    public String getWhereClause(String restrict) {
        return "e.Position = " +  "'" +  restrict + "'";
    }

    @Override
    public String getDistinctClause() {
        return "SELECT DISTINCT e.Position " +
                "FROM EmployeeTable e";
    }
}
