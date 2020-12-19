package javafxapplication;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import searchemployeefromdatabase.*;
import searchemployeefromdatabase.interfaces.ICheckInput;
import searchemployeefromdatabase.interfaces.IField;

import java.net.URL;
import java.sql.Date;
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
    private TableView<BeanEmployees> tableView;

    @FXML
    private TableColumn<BeanEmployees, String> nameColumn;
    @FXML
    private TableColumn<BeanEmployees, String> surnameColumn;
    @FXML
    private TableColumn<BeanEmployees, String> branchIDColumn;
    @FXML
    private TableColumn<BeanEmployees, String> positionColumn;
    @FXML
    private TableColumn<BeanEmployees, Double> wageColumn;
    @FXML
    private TableColumn<BeanEmployees, Date> hiredDateColumn;


    @FXML
    private Label lblError;

    //-----------------//
    private final ICheckInput textFieldCheck = new TextFieldCheck();
    private final ICheckInput comboBoxCheck = new ComboBoxCheck();

    private final QueryRunner queryRunner = new QueryRunner();
    private final SelectAll selectAll = new SelectAll();

    @FXML
    private void btnSearch(ActionEvent actionEvent) {
        ArrayList<String> listOfWhereClause = new ArrayList<>();

        if(textFieldCheck.isNotNull(txtName)) {
            String name = txtName.getText();
            IField nameField = new Name();
            String nameWhereClause = nameField.getWhereClause(name);

            listOfWhereClause.add(nameWhereClause);
            tableView.getItems().clear();
        }

        if(textFieldCheck.isNotNull(txtSurname)) {
            String surname = txtSurname.getText();
            IField surnameField = new Surname();
            String surnameWhereClause = surnameField.getWhereClause(surname);

            listOfWhereClause.add(surnameWhereClause);
            tableView.getItems().clear();
        }

        if(comboBoxCheck.isNotNull(combBoxBranchID)) {
            if (isNotClearSelection(combBoxBranchID)) {
                String branchId = combBoxBranchID.getSelectionModel().getSelectedItem();
                IField branchIDField = new BranchID();
                String branchIDWhereClause = branchIDField.getWhereClause(branchId);

                listOfWhereClause.add(branchIDWhereClause);
                tableView.getItems().clear();
            }
        }

        if(comboBoxCheck.isNotNull(combBoxPosition)) {
            if (isNotClearSelection(combBoxPosition)) {
                String positionId = combBoxPosition.getSelectionModel().getSelectedItem();
                IField positionField = new Position();
                String positionWhereClause = positionField.getWhereClause(positionId);

                listOfWhereClause.add(positionWhereClause);
                tableView.getItems().clear();
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
                tableView.getItems().clear();
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
                tableView.getItems().clear();
            }
        }

        String query = queryRunner.setQueryWithWhereClause(listOfWhereClause);
        ObservableList<BeanEmployees> results = queryRunner.getResult(query);

        setCellValueFactory();
        tableView.getItems().setAll(results);

        String errorMessage = queryRunner.getErrorMessage();
        lblError.setText(errorMessage);
    }
	
	@FXML
    private void btnDisplayAll(ActionEvent actionEvent){
        ObservableList<BeanEmployees> allEmployees = selectAll.getAllEmployees();
        tableView.getItems().clear();

        setCellValueFactory();
        tableView.getItems().setAll(allEmployees);
    }

    private void setCellValueFactory() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeSurname"));
        branchIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeBranchID"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("employeePosition"));
        wageColumn.setCellValueFactory(new PropertyValueFactory<>("employeeWage"));
        hiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("employeeHireDate"));
    }

    @FXML
    private void btnClearResults(ActionEvent actionEvent){
        tableView.getItems().clear();
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
        return !combBox.getSelectionModel().getSelectedItem().equals("Clear Selection");
    }

}
