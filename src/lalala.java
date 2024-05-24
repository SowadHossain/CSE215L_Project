package project;


import dbMangers.LoadDataSaveData;
import entity.*;
import util.Product;
import util.StockableProduct;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;



public class lalala {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Inventory inventory = LoadDataSaveData.getInventoryData();
        Invoice invoice = new Invoice();

        // taking input for Music objects
        System.out.println("Enter number of music items to add:");
        int numberOfMusicItems = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfMusicItems; i++) {
            System.out.println("Enter details for Music item " + (i + 1) + ":");
            System.out.print("Product ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Year: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Number of items in stock: ");
            int numberOfItemsInStock = input.nextInt();
            input.nextLine();
            System.out.print("Artist: ");
            String artist = input.nextLine();

            Music music = new Music(id, name, price, year, genre, discount, numberOfItemsInStock, artist);
            inventory.addItems(music);
        }

        //  taking input for Movie objects
        System.out.println("Enter number of movie items to add:");
        int numberOfMovieItems = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfMovieItems; i++) {
            System.out.println("Enter details for Movie item " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Year: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Number of items in stock: ");
            int numberOfItemsInStock = input.nextInt();
            input.nextLine();
            System.out.print("Director: ");
            String director = input.nextLine();

            Movie movie = new Movie(id, name, price, year, genre, discount, numberOfItemsInStock, director);
            inventory.addItems(movie);
        }

        // Example of taking input for Game objects
        System.out.println("Enter number of game items to add:");
        int numberOfGameItems = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfGameItems; i++) {
            System.out.println("Enter details for Game item " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            System.out.print("Year: ");
            int year = input.nextInt();
            input.nextLine();
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Discount: ");
            double discount = input.nextDouble();
            System.out.print("Number of items in stock: ");
            int numberOfItemsInStock = input.nextInt();
            input.nextLine();
            System.out.print("Developer: ");
            String developer = input.nextLine();

            Game game = new Game(id, name, price, year, genre, discount, numberOfItemsInStock, developer);
            inventory.addItems(game);
        }






        try (FileWriter writer = new FileWriter("output.txt")) {
            for (StockableProduct i : inventory.getItems()) {
                writer.write(i.getInfo() + System.lineSeparator());
            }

            writer.write("----------  End: Task 1 ----------" + System.lineSeparator());

            ArrayList<Product> productsForInvoice_task2 = new ArrayList<Product>();

            productsForInvoice_task2.add(inventory.getItem(101));
            productsForInvoice_task2.add(inventory.getItem(102));
            productsForInvoice_task2.add(inventory.getItem(201));
            productsForInvoice_task2.add(inventory.getItem(202));
            productsForInvoice_task2.add(inventory.getItem(301));
            productsForInvoice_task2.add(inventory.getItem(302));

            Invoice invoice_task2 = new Invoice(productsForInvoice_task2);

            ArrayList<Product> productsForInvoice_task10 = new ArrayList<Product>();  ////////////////
            productsForInvoice_task10.add(inventory.getItem(101));
            productsForInvoice_task10.add(inventory.getItem(102));
            productsForInvoice_task10.add(inventory.getItem(201));
            productsForInvoice_task10.add(inventory.getItem(202));
            productsForInvoice_task10.add(inventory.getItem(301));
            productsForInvoice_task10.add(inventory.getItem(302));                     ////////////////


            writer.write(invoice_task2.getInvoice() + System.lineSeparator());
            writer.write("----------  End: Task 2 ----------" + System.lineSeparator());

            ArrayList<Product> productsForInvoice_task3 = new ArrayList<Product>();

            productsForInvoice_task3.add(inventory.getItem(101));
            productsForInvoice_task3.add(inventory.getItem(102));
            productsForInvoice_task3.add(inventory.getItem(201));
            productsForInvoice_task3.add(inventory.getItem(202));
            productsForInvoice_task3.add(inventory.getItem(301));
            productsForInvoice_task3.add(inventory.getItem(302));

            Invoice invoice_task_3 = new Invoice(productsForInvoice_task3);

            writer.write(invoice_task_3.getInvoice() + System.lineSeparator());
            writer.write("----------  End: Task 3 ----------" + System.lineSeparator());

            for (StockableProduct i : inventory.getItems()) {
                if (i.getClass().getName().contains("Game")) {
                    if (i.getNumberOfItemsInStock() > 0) {
                        writer.write(i.getName() + System.lineSeparator());
                    }
                }
            }

            writer.write("----------  End: Task 4 ----------" + System.lineSeparator());

            inventory.sortByPrice();

            for (StockableProduct i : inventory.getItems()) {
                if (i.getClass().getName().contains("Music")) {
                    writer.write("Name: " + i.getName() + ", Price: " + i.getPrice() + System.lineSeparator());
                    break;
                }
            }

            writer.write("----------  End: Task 5 ----------" + System.lineSeparator());

            for (StockableProduct i : inventory.getItems()) {
                if (i.getClass().getName().contains("Movie")) {
                    if (i.getInfo().toLowerCase().contains(("Francis Ford Coppola").toLowerCase())) {
                        writer.write(i.getName() + System.lineSeparator());
                    }
                }
            }

            writer.write("----------  End: Task 6 ----------" + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Exception occured while writing!");
        }


        // reading from a file

        try(BufferedReader reader = new BufferedReader(new FileReader("output.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
        catch(IOException e) {
            System.out.println("Exception occured while reading!");
        }





    }



}


