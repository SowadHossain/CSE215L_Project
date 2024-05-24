package dbMangers;

import entity.*;
import util.Product;
import util.StockableProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


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
        Scanner fileReader = new Scanner(invertoryDataFile);
        while (fileReader.hasNext()){
            String catagory = String.valueOf(fileReader.next());
            if(catagory == "Movie"){
                int productId; String name; double price; int yearPublished; String genre; double discount; int numberOfItemsStocked; String director;
                productId = Integer.parseInt(String.valueOf(fileReader.next()));
                name = String.valueOf(fileReader.next());
                price = Double.parseDouble(String.valueOf(fileReader.next()));
                yearPublished = Integer.parseInt(String.valueOf(fileReader.next()));
                genre = String.valueOf(fileReader.next());
                discount = Double.parseDouble(String.valueOf(fileReader.next()));
                numberOfItemsStocked = Integer.parseInt(String.valueOf(fileReader.next()));
                director = String.valueOf(fileReader.next());
                LoadDataSaveData.getInventoryData().addItems(new Movie(productId,name,price,yearPublished,genre,discount,numberOfItemsStocked,director));
            }if(catagory == "Music"){
                int productId; String name; double price; int yearPublished; String genre; double discount; int numberOfItemsStocked; String artistName;
                productId = Integer.parseInt(String.valueOf(fileReader.next()));
                name = String.valueOf(fileReader.next());
                price = Double.parseDouble(String.valueOf(fileReader.next()));
                yearPublished = Integer.parseInt(String.valueOf(fileReader.next()));
                genre = String.valueOf(fileReader.next());
                discount = Double.parseDouble(String.valueOf(fileReader.next()));
                numberOfItemsStocked = Integer.parseInt(String.valueOf(fileReader.next()));
                artistName = String.valueOf(fileReader.next());
                LoadDataSaveData.getInventoryData().addItems(new Music(productId,name,price,yearPublished,genre,discount,numberOfItemsStocked,artistName));
            }if(catagory == "Game"){
                int productId; String name; double price; int yearPublished; String genre; double discount; int numberOfItemsStocked; String devoloper;
                productId = Integer.parseInt(String.valueOf(fileReader.next()));
                name = String.valueOf(fileReader.next());
                price = Double.parseDouble(String.valueOf(fileReader.next()));
                yearPublished = Integer.parseInt(String.valueOf(fileReader.next()));
                genre = String.valueOf(fileReader.next());
                discount = Double.parseDouble(String.valueOf(fileReader.next()));
                numberOfItemsStocked = Integer.parseInt(String.valueOf(fileReader.next()));
                devoloper = String.valueOf(fileReader.next());
                LoadDataSaveData.getInventoryData().addItems(new Game(productId,name,price,yearPublished,genre,discount,numberOfItemsStocked,devoloper));
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
        FileWriter fileWriter = new FileWriter(invertoryDataFile);

    for (Object product : inventoryData.getItems()) {
        if(product instanceof Music){
            Music music = (Music) product;
            fileWriter.write("Music");
            fileWriter.write(music.toString());
        }
        else if(product instanceof Movie){
            Movie movie = (Movie) product;
            fileWriter.write("Music");
            fileWriter.write(movie.toString());
        }else if(product instanceof Game){
            Game game = (Game) product;
            fileWriter.write("Music");
            fileWriter.write(game.toString());
        }
    }

    fileWriter.close();
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

/*


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

*/