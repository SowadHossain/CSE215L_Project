package entity;

public class Employee {
    private String name;
    private int employeeID;
    private String position;

    public Employee(String name, int id, String position){
        this.name = name;
        this.employeeID = id;
        this.position = position;
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
