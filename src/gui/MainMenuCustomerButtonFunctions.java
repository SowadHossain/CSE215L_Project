package gui;

import Exceptions.CustomerNotFoundException;
import dbMangers.LoadDataSaveData;
import entity.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuCustomerButtonFunctions {
        Scanner scanner = new Scanner(System.in);
        static ArrayList<Customer> customers = LoadDataSaveData.getCustomerData();


        public static void addCustomer(){
            Scanner sc = new Scanner(System.in);
            System.out.print("Name : ");
            String name = sc.next();
            System.out.print("Id :");
            int id = sc.nextInt();
            System.out.print("email : ");
            String email = sc.next();
            Customer newCustomer = new Customer(name,id,0,0,email);
            LoadDataSaveData.getCustomerData().add(newCustomer);
        }
        public static void CustomerInfo(){
            Customer currentCustomer = null;
            try{
                LoadDataSaveData.loadCustomerData();
            }catch (Exception e){}

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter customer ID: ");
            int id = sc.nextInt();

            for(Customer c : LoadDataSaveData.getCustomerData()){
                if(c.getCustomerId() == id) {
                    currentCustomer = c;
                }
            }
            System.out.println("Customer Details:");
            System.out.println("Name: " + currentCustomer.getName());
            System.out.println("Customer ID: " + currentCustomer.getCustomerId());
            System.out.println("Total Spent: $" + currentCustomer.getTotalSpent());
            System.out.println("Number of Visits: " + currentCustomer.getNumberOfVisits());

    }
    public void updateCustomerInfo() throws CustomerNotFoundException {

        System.out.print("Customer ID:");
        int customerID = scanner.nextInt();

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                customer.setName(newName);

                System.out.println("Enter new total spent:");
                double newTotalSpent = Double.parseDouble(scanner.nextLine());
                customer.setTotalSpent(newTotalSpent);

                System.out.println("Enter new number of visits:");
                int newNumberOfVisits = Integer.parseInt(scanner.nextLine());
                customer.setNumberOfVisits(newNumberOfVisits);

                System.out.println("Enter new email:");
                String newEmail = scanner.nextLine();
                customer.setEmail(newEmail);

                System.out.println("Customer information updated successfully.");
                return;
            }
        }
        throw new CustomerNotFoundException("Customer with ID " + customerID + " not found.");
    }

    public void deleteCustomerData() throws CustomerNotFoundException {
        boolean found = false;
        System.out.println("Customer ID:");
        int customerID = scanner.nextInt();
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                customers.remove(customer);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new CustomerNotFoundException("Customer with ID " + customerID + " not found.");
        } else {
            System.out.println("Customer with ID " + customerID + " deleted successfully.");
            try {
                LoadDataSaveData.saveCustomerData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

