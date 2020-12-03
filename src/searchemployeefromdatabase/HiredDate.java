package searchemployeefromdatabase;

import searchemployeefromdatabase.interfaces.IField;

public class HiredDate implements IField {


    @Override
    public String getWhereClause(String restrict) {
        return "e.HiredDate > " + "date_sub(now(), interval " + restrict + " year)";
    }
}
