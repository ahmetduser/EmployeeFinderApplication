package searchemployeefromdatabase;

import searchemployeefromdatabase.interfaces.IField;

public class Name implements IField {

    @Override
    public String getWhereClause(String restrict) {
        return "e.Name = " + "'" + restrict + "'";
    }
}
