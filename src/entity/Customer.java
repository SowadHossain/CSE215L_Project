package entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private int customerId;
    private double totalSpent;
    private int numberOfVisits;
    private String email;

    public Customer(String name,int customerID,double totalSpent, int numberOfVisits,String email){
        this.name = name;
        this.customerId = customerID;
        this.totalSpent = totalSpent;
        this.numberOfVisits = numberOfVisits;
        this.email = email;
    }
    public void addVisit(){
        setNumberOfVisits(getNumberOfVisits() + 1);
    }
    public void addSpent(double spent){
        setTotalSpent(getTotalSpent() + spent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int cutomerId) {
        this.customerId = cutomerId;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    public String getEmail() {
        return this.email;
    }
}
