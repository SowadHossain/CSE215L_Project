package dbMangers;

import entity.*;
import util.Product;
import util.StockableProduct;

import java.io.*;
import java.util.*;


public class LoadDataSaveData {
    public static HashMap<Integer,String> employeeLoginData = new HashMap<Integer,String>();
    public static ArrayList<Customer> customerData = new ArrayList<Customer>();
    public static ArrayList<Employee> employeeData = new ArrayList<Employee>();
    public  static Inventory inventoryData = new Inventory(new ArrayList<StockableProduct>());
    static File employeeDataFile = new File("data/employee_data.txt");
    static File customerDataFile = new File("data/customer_data.txt");
    static File invertoryDataFile = new File("data/inventory_data.txt");
    public static void loadCustomerData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(customerDataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int customerID = Integer.parseInt(data[1]);
                double totalSpent = Double.parseDouble(data[2]);
                int numberOfVisits = Integer.parseInt(data[3]);
                String email = data[4];
                customerData.add(new Customer(name, customerID, totalSpent, numberOfVisits, email));
            }
        }
    }

    public static void loadEmployeeData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(employeeDataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) { // Ensure all fields are present
                    String name = data[0];
                    int id = Integer.parseInt(data[1]);
                    String position = data[2];
                    String password = data[3];
                    employeeData.add(new Employee(name, id, position, password));
                    employeeLoginData.put(id,password);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void loadInventoryData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(invertoryDataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String category = data[0];
                int productId = Integer.parseInt(data[1]);
                String name = data[2];
                double price = Double.parseDouble(data[3]);
                int yearPublished = Integer.parseInt(data[4]);
                String genre = data[5];
                double discount = Double.parseDouble(data[6]);
                int numberOfItemsStocked = Integer.parseInt(data[7]);
                String additionalField = data[8]; // This will be different based on the category

                if (category.contains("Movie")) {
                    LoadDataSaveData.getInventoryData().addItems(new Movie(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, additionalField));
                } else if (category.contains("Music")) {
                    LoadDataSaveData.getInventoryData().addItems(new Music(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, additionalField));
                } else if (category.contains("Game")) {
                    LoadDataSaveData.getInventoryData().addItems(new Game(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, additionalField));
                }
            }
        }
    }

    // SaveData
    public static void saveCustomerData() throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerDataFile))) {
            for (Customer customer : customerData) {
                StringBuilder sb = new StringBuilder();
                sb.append(customer.getName()).append(",")
                        .append(customer.getCustomerId()).append(",")
                        .append(customer.getTotalSpent()).append(",")
                        .append(customer.getNumberOfVisits()).append(",")
                        .append(customer.getEmail()).append("\n");
                writer.write(sb.toString());
            }
        }
    }

  public static void saveEmployeeData() throws IOException {

      try (FileWriter writer = new FileWriter(employeeDataFile)) {
          for (Employee employee : employeeData) {
              StringBuilder sb = new StringBuilder();
              sb.append(employee.getName()).append(",");
              sb.append(employee.getEmployeeID()).append(",");
              sb.append(employee.getPosition()).append(",");
              sb.append(employee.getPassword()).append("\n");
              writer.append(sb.toString());
          }
          writer.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public static void saveInventoryData() throws IOException {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(invertoryDataFile))) {
          for (Object product : inventoryData.getItems()) {
              StringBuilder sb = new StringBuilder();
              if (product instanceof Movie) {
                  Movie movie = (Movie) product;
                  sb.append("Movie");
                  sb.append(",").append(movie.getProductId())
                          .append(",").append(movie.getName())
                          .append(",").append(movie.getPrice())
                          .append(",").append(movie.getYearPublished())
                          .append(",").append(movie.getGenre())
                          .append(",").append(movie.getDiscount())
                          .append(",").append(movie.getNumberOfItemsInStock())
                          .append(",").append(movie.getDirector())
                          .append("\n");
                            writer.write(sb.toString());
              } else if (product instanceof Music) {

                  Music music = (Music) product;
                  sb.append("Music");
                  sb.append(",").append(music.getProductId())
                          .append(",").append(music.getName())
                          .append(",").append(music.getPrice())
                          .append(",").append(music.getYearPublished())
                          .append(",").append(music.getGenre())
                          .append(",").append(music.getDiscount())
                          .append(",").append(music.getNumberOfItemsInStock())
                          .append(",").append(music.getArtistName())
                          .append("\n");
                  writer.write(sb.toString());
              } else if (product instanceof Game) {

                  Game game = (Game) product;
                  sb.append("Game");
                  sb.append(",").append(game.getProductId())
                          .append(",").append(game.getName())
                          .append(",").append(game.getPrice())
                          .append(",").append(game.getYearPublished())
                          .append(",").append(game.getGenre())
                          .append(",").append(game.getDiscount())
                          .append(",").append(game.getNumberOfItemsInStock())
                          .append(",").append(game.getDeveloper())
                          .append("\n");
                  writer.write(sb.toString());
              }

          }
      }
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
