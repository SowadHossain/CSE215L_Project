package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        
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

        Inventory inventory = new Inventory();

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

        for (StockableProduct i : inventory) {
            System.out.println(i.getInfo());
        }
        
        System.out.println("----------  End: Task 1 ----------");

        
        
        ArrayList<Product> productsForInvoice_task2 = new ArrayList<Product>();

        productsForInvoice_task2.add(inventory.getItem(101));
        productsForInvoice_task2.add(inventory.getItem(102));
        productsForInvoice_task2.add(inventory.getItem(201));
        productsForInvoice_task2.add(inventory.getItem(202));
        productsForInvoice_task2.add(inventory.getItem(301));
        productsForInvoice_task2.add(inventory.getItem(302));

        Invoice invoice_task2 = new Invoice(productsForInvoice_task2);

        System.out.println(invoice_task2.getInvoice());

        
        System.out.println("----------  End: Task 2 ----------");


        
        ArrayList<Product> productsForInvoice_task3 = new ArrayList<Product>();

        productsForInvoice_task3.add(inventory.getItem(101));
        productsForInvoice_task3.add(inventory.getItem(102));
        productsForInvoice_task3.add(inventory.getItem(201));
        productsForInvoice_task3.add(inventory.getItem(202));
        productsForInvoice_task3.add(inventory.getItem(301));
        productsForInvoice_task3.add(inventory.getItem(302));

        Invoice invoice_task_3 = new Invoice(productsForInvoice_task3);

        System.out.println(invoice_task_3.getInvoice());

        
        System.out.println("----------  End: Task 3 ----------");

        

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Game")) {
                if (i.getNumberOfItemsInStock() > 0) {
                    System.out.println(i.getName());
                }
            }
        }
        
        
        System.out.println("----------  End: Task 4 ----------");        

        

        inventory.sortByPrice();

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Music")) {
                System.out.println("Name: " + i.getName() + ", Price: " + i.getPrice());
                break;
            }
        }
 
        
        System.out.println("----------  End: Task 5 ----------");

        

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Movie")) {
                if (i.getInfo().toLowerCase().contains(("Francis Ford Coppola").toLowerCase())) {
                    System.out.println(i.getName());
                }
            }
        }

        
        System.out.println("----------  End: Task 6 ----------");

    }
    
}
