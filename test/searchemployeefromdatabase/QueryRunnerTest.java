package searchemployeefromdatabase;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import searchemployeefromdatabase.interfaces.IField;

import java.util.ArrayList;
import java.util.List;


class QueryRunnerTest {

    QueryRunner fQuery = new QueryRunner();
    List<String> wheres = new ArrayList<>();


    @Test
    void testBranchIDWhereClause(){
        IField branch = new BranchID();
        String strBranch = branch.getWhereClause("TR122");
        wheres.add(strBranch);
        wheres.add("e.Position = 'AppleDesk'");
        String str = fQuery.setQueryWithWhereClause(wheres);
        System.out.println(str);
    }

    @Test
    void testQueryWithBranchIDWhereClause() {
        IField branch = new BranchID();
        String strBranch = branch.getWhereClause("TR122");
        wheres.add(strBranch);
        wheres.add("e.Position = 'AppleDesk'");
        String str = fQuery.setQueryWithWhereClause(wheres);
        fQuery.getResult(str);

    }

    @Test
    void testQueryWithPositionWhereClause() {
        IField position = new Position();
        String strPosition = position.getWhereClause("AppleDesk");
        wheres.add(strPosition);
        String str = fQuery.setQueryWithWhereClause(wheres);
        fQuery.getResult(str);
    }

    @Test
    void testQueryWithPositionAndBranchIDWhereClause() {

        IField branchID = new BranchID();
        String strBranchID = branchID.getWhereClause("TR122");

        IField position = new Position();
        String strPosition = position.getWhereClause("Soft. Eng");

        wheres.add(strBranchID);
        wheres.add(strPosition);

        String str = fQuery.setQueryWithWhereClause(wheres);
        System.out.println(fQuery.getResult(str));

    }

    @Test
    void testQueryWithNameWhereClause() {
        IField name = new Name();
        String strName = name.getWhereClause("Ahmet");
        wheres.add(strName);
        String str = fQuery.setQueryWithWhereClause(wheres);
        fQuery.getResult(str);

    }

    @Test
    void testQueryWithSurnameWhereClause() {
        IField surname = new Surname();
        String strName = surname.getWhereClause("Duser");
        wheres.add(strName);
        String str = fQuery.setQueryWithWhereClause(wheres);
        fQuery.getResult(str);

    }

    @Test
    void testQueryWithHiredDateWhereClause(){
        IField hiredDate = new HiredDate();
        String strDate = hiredDate.getWhereClause("10");
        wheres.add(strDate);
        String str = fQuery.setQueryWithWhereClause(wheres);
        ObservableList<String> list = fQuery.getResult(str);
        for(String s : list){
            System.out.println(s);
        }
    }

    @Test
    void testQueryWageWhereClause(){
        IField wage = new Wage();
        String strWage = wage.getWhereClause("12000");
        wheres.add(strWage);
        String str = fQuery.setQueryWithWhereClause(wheres);
        fQuery.getResult(str);
    }

}