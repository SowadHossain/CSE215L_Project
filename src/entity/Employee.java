package entity;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int employeeID;
    private String position;
    private String password;

    public Employee(String name, int id, String position,String password){
        this.name = name;
        this.employeeID = id;
        this.position = position;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPosition() {
        return position;
    }
}
