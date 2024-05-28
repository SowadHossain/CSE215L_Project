import dbMangers.LoadDataSaveData;
import entity.*;
import util.Product;
import util.StockableProduct;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<StockableProduct> st = new ArrayList<>();
        Inventory inventory = new Inventory(st);

        // Adding Music items
//        System.out.println("Enter number of Music items to add:");
//        int musicCount = input.nextInt();
//        input.nextLine();
//        for (int i = 0; i < musicCount; i++) {
//            System.out.println("Enter details for Music item " + (i + 1));
//            System.out.print("ID: ");
//            int id = input.nextInt();
//            input.nextLine();
//            System.out.print("Name: ");
//            String name = input.nextLine();
//            System.out.print("Price: ");
//            double price = input.nextDouble();
//            System.out.print("Release Year: ");
//            int year = input.nextInt();
//            input.nextLine();
//            System.out.print("Genre: ");
//            String genre = input.nextLine();
//            System.out.print("Discount: ");
//            double discount = input.nextDouble();
//            System.out.print("Stock: ");
//            int stock = input.nextInt();
//            input.nextLine();
//            System.out.print("Artist: ");
//            String artist = input.nextLine();
//
//            Music music = new Music(id, name, price, year, genre, discount, stock, artist);
//            inventory.addItems(music);
//        }
//
//        // Adding Movie items
//        System.out.println("Enter number of Movie items to add:");
//        int movieCount = input.nextInt();
//        input.nextLine();
//
//        for (int i = 0; i < movieCount; i++) {
//            System.out.println("Enter details for Movie item " + (i + 1));
//            System.out.print("ID: ");
//            int id = input.nextInt();
//            input.nextLine();
//            System.out.print("Name: ");
//            String name = input.nextLine();
//            System.out.print("Price: ");
//            double price = input.nextDouble();
//            System.out.print("Release Year: ");
//            int year = input.nextInt();
//            input.nextLine();
//            System.out.print("Genre: ");
//            String genre = input.nextLine();
//            System.out.print("Discount: ");
//            double discount = input.nextDouble();
//            System.out.print("Stock: ");
//            int duration = input.nextInt();
//            input.nextLine();
//            System.out.print("Director: ");
//            String director = input.nextLine();
//
//            Movie movie = new Movie(id, name, price, year, genre, discount, duration, director);
//            inventory.addItems(movie);
//        }
//
//        // Adding Game items
//        System.out.println("Enter number of Game items to add:");
//        int gameCount = input.nextInt();
//        input.nextLine();
//
//        for (int i = 0; i < gameCount; i++) {
//            System.out.println("Enter details for Game item " + (i + 1));
//            System.out.print("ID: ");
//            int id = input.nextInt();
//            input.nextLine();
//            System.out.print("Name: ");
//            String name = input.nextLine();
//            System.out.print("Price: ");
//            double price = input.nextDouble();
//            System.out.print("Release Year: ");
//            int year = input.nextInt();
//            input.nextLine();
//            System.out.print("Genre: ");
//            String genre = input.nextLine();
//            System.out.print("Discount: ");
//            double discount = input.nextDouble();
//            System.out.print("Stock: ");
//            int stock = input.nextInt();
//            input.nextLine();
//            System.out.print("Publisher: ");
//            String publisher = input.nextLine();
//
//            Game game = new Game(id, name, price, year, genre, discount, stock, publisher);
//            inventory.addItems(game);
//        }
//

        Music m1 = new Music(101, "Kodaline", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");
        Music m2 = new Music(102, "Kodaline2", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");
        Music m3 = new Music(103, "Kodaline3", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");
        Music m4 = new Music(104, "Kodaline4", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");
        Music m5 = new Music(105, "Kodaline5", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");
        Music m6 = new Music(106, "Kodaline6", 5.00, 2010, "Inde", 2.00, 50, "Alex Turner");

        Movie v1 = new Movie(201, "Good Will Hunting", 5.0, 1997, "Drama", 3.0, 50, "Gus Van Sant");
        Movie v2 = new Movie(202, "Life Is Beautiful", 20, 1997, "Comedy-Drama", 2.6, 126, "Roberto Benigni");
        Movie v3 = new Movie(203, "what's eating gilbert grape", 20, 1993, "Drama", 6.4, 122, "Lasse Hallstrom");
        Movie v4 = new Movie(204, "The Godfather", 15, 1972, "Crime", .01, 125, "Francis Ford Coppola");
        Movie v5 = new Movie(205, "The Rainmaker", 5, 1997, "Crime", 12, 127, "Francis Ford Coppola");
        Movie v6 = new Movie(206, "Apocalypse Now", 24, 1979, "Drama", 4.9, 121, "Francis Ford Coppola");
        Movie v7 = new Movie(207, "Leon the Professional", 21, 1994, "Drama", 2.7, 124, "Luc Besson");

        Game g1 = new Game(301, "Red Dead Redemption 2", 29, 2018, "Survival", 3.7, 560, "RockStar");
        Game g2 = new Game(302, "God of War", 12, 2018, "Action", 5.6, 567, "Javaground");
        Game g3 = new Game(303, "Grand Theft Auto V", 13, 2017, "Action", 2.3, 565, "RockStar");


        inventory.addItems(m1);
        inventory.addItems(m2);
        inventory.addItems(m3);
        inventory.addItems(m4);
        inventory.addItems(m5);
        inventory.addItems(m6);

        inventory.addItems(v1);
        inventory.addItems(v2);
        inventory.addItems(v3);
        inventory.addItems(v4);
        inventory.addItems(v5);
        inventory.addItems(v6);
        inventory.addItems(v7);

        inventory.addItems(g1);
        inventory.addItems(g2);
        inventory.addItems(g3);

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
            inventory.sortByPrice();
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
