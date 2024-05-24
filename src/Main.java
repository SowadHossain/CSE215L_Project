import dbMangers.LoadDataSaveData;
import entity.*;
import util.StockableProduct;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ///products
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

        Inventory inventory = LoadDataSaveData.getInventoryData();

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

        System.out.println(inventory.getItem(202).getInfo());
        //

        System.out.println("main");

    }

}