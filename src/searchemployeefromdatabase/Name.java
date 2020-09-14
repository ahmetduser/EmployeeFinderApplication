package searchemployeefromdatabase;

public class Name implements IField {


    @Override
    public String getWhereClause(String restrict) {
        return "e.Name = " + "'" + restrict + "'";
    }

}
