package entity;

public class Customer {
    private String name = "anonymous";
    private int customerId;
    private double totalSpent;
    private int numberOfVisits;

    public Customer(String name,int customerID){
        if(name != null) {
            this.name = name;
        }
        this.customerId = customerID;
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
}
