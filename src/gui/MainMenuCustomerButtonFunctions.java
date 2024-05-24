package gui;

import dbMangers.LoadDataSaveData;
import entity.Customer;

import java.util.Scanner;

public class MainMenuCustomerButtonFunctions {

        public MainMenuCustomerButtonFunctions(){

        }
        public static void test(){
            System.out.println("Test");
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
        }
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

}

