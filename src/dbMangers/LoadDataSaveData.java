package dbMangers;

import entity.*;
import util.StockableProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class LoadDataSaveData {
    public static HashMap<Integer,String> employeeLoginData = new HashMap<Integer,String>();
    public static ArrayList<Customer> customerData = new ArrayList<Customer>();
    public static ArrayList<Employee> employeeData = new ArrayList<Employee>();
    public  static Inventory inventoryData = new Inventory(new ArrayList<StockableProduct>());
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
            }catch (ClassNotFoundException e){
                System.out.println("Class not found");
                objectInputStream.close();
                flag = false;
            }catch (Exception e){
                e.printStackTrace();
                flag= false;
            }
        }

    }
    public static void loadInventoryData() throws IOException {
        boolean flag = true;
        System.out.println("test loadinvertory 1");
        FileInputStream fileInputStream = new FileInputStream(invertoryDataFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        while (flag){
            try{
                System.out.println("IN try block");
                Object ob = objectInputStream.readObject();
                if(ob.getClass().getName().contains("Movie")) {
                    Movie movie = (Movie) ob;
                    inventoryData.addItems(movie);
                }
                else if(ob.getClass().getName().contains("Music")) {
                    Music music = (Music) ob;
                    inventoryData.addItems(music);
                }
                else if(ob.getClass().getName().contains("Game")) {
                    Game game = (Game) ob;
                    inventoryData.addItems(game);
                }


            }catch (EOFException eofException){
                flag = false;
                objectInputStream.close();
            }catch (ClassNotFoundException e){
                System.out.println("Class not found");
                objectInputStream.close();
                flag = false;
            }catch (Exception e){
                e.printStackTrace();
                flag= false;
            }
        }
    }

// SaveData 
      public static void saveCustomerData() throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(customerDataFile);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    for (Customer customer : customerData) {
      objectOutputStream.writeObject(customer);
    }

    objectOutputStream.close();
    fileOutputStream.close();
  }

  public static void saveEmployeeData() throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(employeeDataFile);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    for (Employee employee : employeeData) {
      objectOutputStream.writeObject(employee);
    }

    objectOutputStream.close();
    fileOutputStream.close();
  }

  public static void saveInventoryData() throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(invertoryDataFile);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    for (StockableProduct product : inventoryData.getItems()) {
        objectOutputStream.writeObject(product);
    }

    objectOutputStream.close();
    fileOutputStream.close();
  }


    public static HashMap<Integer, String> getEmployeeLoginData() {
        return employeeLoginData;
    }

    public static ArrayList<Customer> getCustomerData() {
        return customerData;
    }

    public static ArrayList<Employee> getEmployeeData() {
        return employeeData;
    }

    public static Inventory getInventoryData() {
        return inventoryData;
    }
}