package gui;

import dbMangers.LoadDataSaveData;
import entity.Customer;

import java.util.Scanner;

public class MainMenuCustomerButtonFunctions {

        public void CustomerInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer ID: ");
        Customer currentCustomer = null;
        String name = sc.next();
        int id = sc.nextInt();

        for(Customer c : LoadDataSaveData.getCustomerData()){
            if(c.getName() == name && c.getCustomerId() == id) {
                currentCustomer = c;
            }
        }
            System.out.println("Customer Details:");
            System.out.println("Name: " + currentCustomer.getName());
            System.out.println("Customer ID: " + currentCustomer.getCustomerId());
            System.out.println("Total Spent: $" + currentCustomer.getTotalSpent());
            System.out.println("Number of Visits: " + currentCustomer.getNumberOfVisits());
        }
        public void
    }

}

