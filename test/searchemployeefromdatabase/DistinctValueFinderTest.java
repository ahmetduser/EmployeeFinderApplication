package searchemployeefromdatabase;

import org.junit.jupiter.api.Test;
import searchemployeefromdatabase.interfaces.IDistinctField;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistinctValueFinderTest {

    private DistinctValueFinder finder = new DistinctValueFinder();

    @Test
    void testDistinctPositionValues(){
        IDistinctField position = new Position();
        String positionDistinctClause = position.getDistinctClause();
        List<String> positionList = finder.getListOfDistinctPositionValues(positionDistinctClause);
        System.out.println(positionList.get(1));
    }

    @Test
    void testBranchIDValues(){
        IDistinctField branchID = new BranchID();
        String branchIDDistinctClause = branchID.getDistinctClause();
        List<String> branchIDList = finder.getListOfDistinctBranchIDValues(branchIDDistinctClause);
        System.out.println(branchIDList.get(1));
    }

}