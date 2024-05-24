/*
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
                Object ob = objectInputStream.readObject();
                System.out.println(ob.getClass().getName());
                if(ob instanceof Movie) {
                    Movie movie = (Movie)ob;
                    System.out.println("Reading objects");
                    inventoryData.addItems(movie);
                    System.out.println(movie.getInfo());
                }
                else if(ob instanceof Music) {
                    Music music = (Music)ob;
                    inventoryData.addItems(music);
                }
                else if(ob instanceof Game) {
                    Game game = (Game) ob;
                    inventoryData.addItems(game);
                }



            }catch (EOFException eofException){
                flag = false;
                objectInputStream.close();
            }catch (ClassNotFoundException e){
                System.out.println("Class not found");
                objectInputStream.close();
            }catch (Exception e){
                e.printStackTrace();

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

    for (Object product : inventoryData.getItems()) {
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
*/




// new LoadDataSaveData for toString() method with buffered reader and writer


package dbMangers;

import entity.*;
import util.StockableProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class LoadDataSaveData {
  public static HashMap<Integer, String> employeeLoginData = new HashMap<Integer, String>();
  public static ArrayList<Customer> customerData = new ArrayList<Customer>();
  public static ArrayList<Employee> employeeData = new ArrayList<Employee>();
  public static Inventory inventoryData = new Inventory(new ArrayList<StockableProduct>());

  static File employeeDataFile = new File("data/employee_data.txt");
  static File customerDataFile = new File("data/customer_data.txt");
  static File inventoryDataFile = new File("data/inventory_data.txt");

  public static void loadCustomerData() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(customerDataFile));
    String line;
    while ((line = reader.readLine()) != null) {
   
      Customer customer = parseCustomerData(line);
      customerData.add(customer);
    }
    reader.close();
  }

  public static void loadEmployeeData() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(employeeDataFile));
    String line;
    while ((line = reader.readLine()) != null) {
     
      Employee employee = parseEmployeeData(line);
      employeeData.add(employee);
      employeeLoginData.put(employee.getEmployeeID(), employee.getPassword());
    }
    reader.close();
  }


  // SaveData

  
  public static void saveCustomerData() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(customerDataFile));
    for (Customer customer : customerData) {
      
      writer.write(formatCustomerData(customer));
      writer.newLine();
    }
    writer.close();
  }


  public static void saveEmployeeData() throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(employeeDataFile));
    for (Employee employee : employeeData) {
      writer.write(formatEmployeeData(employee));
      writer.newLine();
    }
    writer.close();
  }
}

