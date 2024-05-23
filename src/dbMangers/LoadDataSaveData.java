package dbMangers;

import entity.Customer;
import entity.Employee;
import entity.Inventory;
import util.StockableProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LoadDataSaveData {
    static HashMap<Integer,String> employeeLoginData = new HashMap<Integer,String>();
    static ArrayList<Customer> customerData = new ArrayList<Customer>();
    static ArrayList<Employee> employeeData = new ArrayList<Employee>();
    private static ArrayList<StockableProduct> inventoryData = new ArrayList<StockableProduct>();
    static File employeeDataFile = new File("data/employee_data.txt");
    static File customerDataFile = new File("data/customer_data.txt");
    static File invertoryDataFile = new File("data/inventory_data.txt");
    public static void loadCustomerData() throws IOException {
        boolean flag = true;
        FileInputStream fileInputStream = new FileInputStream(customerDataFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (flag){
            try{
                Customer customer = (Customer) objectInputStream.readObject();
                customerData.add(customer);
            }catch (EOFException eofException){
                flag = false;
                objectInputStream.close();
            }catch (Exception e){
                objectInputStream.close();
            }
        }

//
//        Scanner sc = new Scanner(customerDataFile);
//        while (sc.hasNext()){
//            String name = sc.next();
//            int id =  sc.nextInt();
//            double totalSpent  = sc.nextDouble();
//            int numberOfVisits = sc.nextInt();
//            customerData.add(new Customer(name,id,totalSpent,numberOfVisits));
//        }
    }
    public static void loadEmployeeData() throws IOException {
        boolean flag = true;
        FileInputStream fileInputStream = new FileInputStream(employeeDataFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (flag){
            try{
                Employee employee = (Employee) objectInputStream.readObject();
                employeeData.add(employee);
                employeeLoginData.put(employee.getEmployeeID(),employee.getPassword());
            }catch (EOFException eofException){
                flag = false;
                objectInputStream.close();
            }catch (Exception e){
                objectInputStream.close();
            }
        }

//        Scanner sc = new Scanner(employeeDataFile);
//        while (sc.hasNext()){
//            String UserName = sc.next();
//            String Password = sc.next();
//            int UserID =  sc.nextInt();
//            String UserPosition = sc.next();
//            employeeLoginData.put(UserID,Password);
//            employeeData.add(new Employee(UserName,UserID,UserPosition,Password));
//        }
    }
    public static void loadInventoryData() throws IOException {
        boolean flag = true;
        FileInputStream fileInputStream = new FileInputStream(invertoryDataFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (flag){
            try{
                StockableProduct stockableProduct = (StockableProduct) objectInputStream.readObject();
                inventoryData.add(stockableProduct);
            }catch (EOFException eofException){
                flag = false;
                objectInputStream.close();
            }catch (Exception e){
                objectInputStream.close();
            }
        }
    }

}
