package searchemployeefromdatabase;

import searchemployeefromdatabase.interfaces.IField;

public class Wage implements IField {

    @Override
    public String getWhereClause(String restrict) {
        return "e.Wage > " + restrict;
    }
}
