package searchemployeefromdatabase;

public class Surname implements IField {


    @Override
    public String getWhereClause(String restrict) {
        return "e.Surname = " + "'" + restrict + "'";
    }
}
