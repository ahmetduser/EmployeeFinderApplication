package searchemployeefromdatabase;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.sql.Date;

public class BeanEmployees {

    private SimpleStringProperty employeeName = new SimpleStringProperty();
    private SimpleStringProperty employeeSurname = new SimpleStringProperty();
    private SimpleStringProperty employeeBranchID = new SimpleStringProperty();
    private SimpleStringProperty employeePosition = new SimpleStringProperty();
    private SimpleDoubleProperty employeeWage = new SimpleDoubleProperty();
    private ObjectProperty<Date> employeeHireDate = new SimpleObjectProperty<>();

    public BeanEmployees(){
    }

    public BeanEmployees(String employeeName, String employeeSurname, String employeeBranchID,
                         String employeePosition, double employeeWage, Date employeeHireDate) {
        setEmployeeName(employeeName);
        setEmployeeSurname(employeeSurname);
        setEmployeeBranchID(employeeBranchID);
        setEmployeePosition(employeePosition);
        setEmployeeWage(employeeWage);
        setEmployeeHireDate(employeeHireDate);
    }

    public String getEmployeeName() {
        return employeeName.get();
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName.set(employeeName);
    }

    public String getEmployeeSurname() {
        return employeeSurname.get();
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname.set(employeeSurname);
    }

    public String getEmployeeBranchID() {
        return employeeBranchID.get();
    }

    public void setEmployeeBranchID(String employeeBranchID) {
        this.employeeBranchID.set(employeeBranchID);
    }

    public String getEmployeePosition() {
        return employeePosition.get();
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition.set(employeePosition);
    }

    public double getEmployeeWage() {
        return employeeWage.get();
    }

    public void setEmployeeWage(double employeeWage) {
        this.employeeWage.set(employeeWage);
    }

    public Date getEmployeeHireDate() {
        return employeeHireDate.get();
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate.set(employeeHireDate);
    }
}
