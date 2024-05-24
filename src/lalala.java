

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


import java.util.Collections;
import java.util.Comparator;

////////////////////


public class lalala {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Music m1 = new Music(101, "submarine", 20.0, 2011, "Indie", 2.00, 50, "Alex_Turner");
        Music m2 = new Music(102, "AM ", 10.0, 2010, "Indie", 2.00, 50, "Kodaline");


        Movie v1 = new Movie(201, "Good Will Hunting", 5.0, 1997, "Drama", 3.0, 50, "Gus_Van_Sant");
        Movie v2 = new Movie(202, "Life Is Beautiful", 20, 1997, "Comedy-Drama", 2.6, 126, "Roberto_Benigni");

        Game g1 = new Game(301, "Red Dead Redemption 2", 29, 2018, "Survival", 3.7, 560, "RockStar");
        Game g2 = new Game(302, "God of War", 12, 2018, "Action", 5.6, 567, "Javaground");
        ArrayList<StockableProduct> st = new ArrayList<StockableProduct>();
        Inventory inventory = new Inventory(st);

        inventory.addItems(m1);
        inventory.addItems(m2);


        inventory.addItems(v1);
        inventory.addItems(v2);


        inventory.addItems(g1);
        inventory.addItems(g2);


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


            writer.write("----------  End: Task 5 ----------");

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

