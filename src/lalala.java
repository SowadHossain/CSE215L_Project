import entity.*;
import util.Product;
import util.StockableProduct;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import util.Product;
import util.StockableProduct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;



public class lalala {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<StockableProduct> st = new ArrayList<>();
        Inventory inventory = new Inventory(st);

        // Adding Music items
        System.out.println("Enter number of Music items to add:");
        int musicCount = input.nextInt();
        input.nextLine();  
        for (int i = 0; i < musicCount; i++) {
            System.out.println("Enter details for Music item " + (i + 1));
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine();  
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Release Year: ");
            int year = input.nextInt();
            input.nextLine();  
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Stock: ");
            int stock = input.nextInt();
            input.nextLine();  
            System.out.print("Artist: ");
            String artist = input.nextLine();

            Music music = new Music(id, name, price, year, genre, discount, stock, artist);
            inventory.addItems(music);
        }

        // Adding Movie items
        System.out.println("Enter number of Movie items to add:");
        int movieCount = input.nextInt();
        input.nextLine();  

        for (int i = 0; i < movieCount; i++) {
            System.out.println("Enter details for Movie item " + (i + 1));
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine(); 
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Release Year: ");
            int year = input.nextInt();
            input.nextLine();  
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Stock: ");
            int duration = input.nextInt();
            input.nextLine();  
            System.out.print("Director: ");
            String director = input.nextLine();

            Movie movie = new Movie(id, name, price, year, genre, discount, duration, director);
            inventory.addItems(movie);
        }

        // Adding Game items
        System.out.println("Enter number of Game items to add:");
        int gameCount = input.nextInt();
        input.nextLine();  

        for (int i = 0; i < gameCount; i++) {
            System.out.println("Enter details for Game item " + (i + 1));
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine();  
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Release Year: ");
            int year = input.nextInt();
            input.nextLine();  
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Stock: ");
            int stock = input.nextInt();
            input.nextLine();  
            System.out.print("Publisher: ");
            String publisher = input.nextLine();

            Game game = new Game(id, name, price, year, genre, discount, stock, publisher);
            inventory.addItems(game);
        }
        
        System.out.println("Enter the director's name to search for movies:");
        String directorName = input.nextLine().toLowerCase();

        // Writing to a file
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (StockableProduct i : inventory.getItems()) {
                writer.write(i.getInfo() + System.lineSeparator());
            }
            writer.write(System.lineSeparator());
            writer.write("----------  Input Completed ----------" + System.lineSeparator());
            writer.write(System.lineSeparator());

            ArrayList<Product> productsForInvoice_task2 = new ArrayList<>();
            
            int[] itemIds = {101, 102, 201, 202, 301, 302};
            for (int id : itemIds) {
                Product product = inventory.getItem(id);
                if (product != null) {
                    productsForInvoice_task2.add(product);
                }
            }

            Invoice invoice_task2 = new Invoice(productsForInvoice_task2);
            writer.write(invoice_task2.getInvoice() + System.lineSeparator());
            writer.write(System.lineSeparator());
            writer.write("----------  This is the invoice ----------" + System.lineSeparator());
            writer.write(System.lineSeparator());

            for (StockableProduct i : inventory.getItems()) {
                if (i instanceof Game && i.getNumberOfItemsInStock() > 0) {
                    writer.write(i.getName() + System.lineSeparator());
                }
            }
            writer.write(System.lineSeparator());
            writer.write("----------  These are the available games ----------" + System.lineSeparator());
            writer.write(System.lineSeparator());

            for (StockableProduct i : inventory.getItems()) {
                if (i instanceof Movie && i.getInfo().toLowerCase().contains(directorName)) {
                    writer.write(i.getName() + System.lineSeparator());
                }
            }
            writer.write(System.lineSeparator());
            writer.write("----------  These are the movies available of the above mentioned director ----------" + System.lineSeparator());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Exception occurred while writing!");
        }

        // Reading from a file
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while reading!");
        }
    }
}
