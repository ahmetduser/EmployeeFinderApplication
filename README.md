# Employee Finder Application

![alt text](https://github.com/ahmetduser/EmployeeFinderApplication/blob/master/ApplicationImage.png)


**Tools and Technologies used:**

- JDK 1.8
- JavaFX
- MySQL Connector java 8.0.22.jar [To Download](https://dev.mysql.com/downloads/connector/j/)
- Intellij IDEA
- SceneBuilder

DataBase tables:

```
CREATE TABLE Employee(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Name VARCHAR(45) NOT NULL,
    Surname VARCHAR(45),
    BranchID VARCHAR(15) NOT NULL,
    Position VARCHAR(30),
    Wage Double,
    HiredDate DATE
);
```