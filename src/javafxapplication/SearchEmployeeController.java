package javafxapplication;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import searchemployeefromdatabase.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchEmployeeController implements Initializable {

    @FXML
    private ComboBox<String> combBoxBranchID;

    @FXML
    private ComboBox<String> combBoxPosition;

    @FXML
    private ComboBox<String> combBoxWageRange;

    @FXML
    private ComboBox<String> combBoxHiredDate;


    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurname;


    @FXML
    private ListView<String> resultListView;

    @FXML
    private Label lblError;

    private final ICheckInput textFieldCheck = new TextFieldCheck();
    private final ICheckInput comboBoxCheck = new ComboBoxCheck();

    private final QueryRunner queryRunner = new QueryRunner();

    @FXML
    private void btnSearch(ActionEvent actionEvent) {
        ArrayList<String> listOfWhereClause = new ArrayList<>();

        if(textFieldCheck.isNotNull(txtName)) {
            String name = txtName.getText();
            IField nameField = new Name();
            String nameWhereClause = nameField.getWhereClause(name);

            listOfWhereClause.add(nameWhereClause);
            resultListView.getItems().clear();
        }

        if(textFieldCheck.isNotNull(txtSurname)) {
            String surname = txtSurname.getText();
            IField surnameField = new Surname();
            String surnameWhereClause = surnameField.getWhereClause(surname);

            listOfWhereClause.add(surnameWhereClause);
            resultListView.getItems().clear();
        }

        if(comboBoxCheck.isNotNull(combBoxBranchID)) {
            if (isNotClearSelection(combBoxBranchID)) {
                String branchId = combBoxBranchID.getSelectionModel().getSelectedItem();
                IField branchIDField = new BranchID();
                String branchIDWhereClause = branchIDField.getWhereClause(branchId);

                listOfWhereClause.add(branchIDWhereClause);
                resultListView.getItems().clear();
            }
        }

        if(comboBoxCheck.isNotNull(combBoxPosition)) {
            if (isNotClearSelection(combBoxPosition)) {
                String positionId = combBoxPosition.getSelectionModel().getSelectedItem();
                IField positionField = new Position();
                String positionWhereClause = positionField.getWhereClause(positionId);

                listOfWhereClause.add(positionWhereClause);
                resultListView.getItems().clear();
            }
        }

        if(comboBoxCheck.isNotNull(combBoxWageRange)) {
            if(isNotClearSelection(combBoxWageRange)) {
                String wageRange = combBoxWageRange.getSelectionModel().getSelectedItem();
                // used regex to delete non digits and get only the digit value
                wageRange = wageRange.replaceAll("\\D+", "");
                IField wageField = new Wage();
                String wageRageWhereClause = wageField.getWhereClause(wageRange);

                listOfWhereClause.add(wageRageWhereClause);
                resultListView.getItems().clear();
            }
        }

        if(comboBoxCheck.isNotNull(combBoxHiredDate)){
            if(isNotClearSelection(combBoxHiredDate)){
                String hiredDate = combBoxHiredDate.getSelectionModel().getSelectedItem();
                // used regex to delete non digits and get only the digit value
                hiredDate = hiredDate.replaceAll("\\D+","");
                IField hiredDateField = new HiredDate();
                String hiredDateWhereClause = hiredDateField.getWhereClause(hiredDate);

                listOfWhereClause.add(hiredDateWhereClause);
                resultListView.getItems().clear();
            }
        }

        String query = queryRunner.setQueryWithWhereClause(listOfWhereClause);
        ObservableList<String> results = queryRunner.getResult(query);

        for (String s : results) {
            resultListView.getItems().add(s);
        }

        String errorMessage = queryRunner.getErrorMessage();
        lblError.setText(errorMessage);
    }

    @FXML
    private void btnClearResults(ActionEvent actionEvent){
        resultListView.getItems().clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ComboBoxItemAllocate combBoxItemAllocate = new ComboBoxItemAllocate();
        combBoxItemAllocate.putBranchIDItems(combBoxBranchID);
        combBoxItemAllocate.putPositionItems(combBoxPosition);
        combBoxItemAllocate.putWageItems(combBoxWageRange);
        combBoxItemAllocate.putHiredDateItems(combBoxHiredDate);
    }

    private boolean isNotClearSelection(ComboBox<String> combBox) {
        return combBox.getSelectionModel().getSelectedItem() != "Clear Selection";
    }

}
