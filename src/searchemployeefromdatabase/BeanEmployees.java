package searchemployeefromdatabase;

import java.sql.Date;

public class BeanEmployees {

    private String employeeName;
    private String employeeSurname;
    private String employeeBranchID;
    private String employeePosition;
    private double employeeWage;
    private Date employeeHireDate;


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeBranchID() {
        return employeeBranchID;
    }

    public void setEmployeeBranchID(String employeeBranchID) {
        this.employeeBranchID = employeeBranchID;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getEmployeeWage() {
        return employeeWage;
    }

    public void setEmployeeWage(double employeeWage) {
        this.employeeWage = employeeWage;
    }

    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    @Override
    public String toString() {
        return employeeName + " " + employeeSurname + " " + employeeBranchID + " "
                + employeePosition + " " + employeeWage + " " + employeeHireDate;
    }


}
