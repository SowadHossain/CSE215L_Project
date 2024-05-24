package gui;

import dbMangers.LoadDataSaveData;
import entity.Game;
import entity.Movie;
import entity.Music;

import java.util.Scanner;

public class MainMenuProductButtonFunctions {
    Scanner scanner = new Scanner(System.in);

    MainMenuProductButtonFunctions() {
        System.out.println("Enter product category(game, music, movie): ");
        String category = scanner.nextLine();
        if (category.equalsIgnoreCase("game")) {
            System.out.println("Enter product id: ");
            int productId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter year published: ");
            int yearPublished = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.println("Enter discount: ");
            double discount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter number of items stocked: ");
            int numberOfItemsStocked = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter developer: ");
            String developer = scanner.nextLine();

            System.out.println("Enter how many products you want to add: ");
            int numberOfProducts = Integer.parseInt(scanner.nextLine());

            Game game = new Game(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, developer);
            LoadDataSaveData.getInventoryData().addItems(game);
            LoadDataSaveData.getInventoryData().addProductStock(game.getProductId(), numberOfProducts);
        }
        else if (category.equalsIgnoreCase("music")) {
            // Code for creating Music object
            System.out.println("Enter product id: ");
            int productId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter year published: ");
            int yearPublished = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.println("Enter discount: ");
            double discount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter number of items stocked: ");
            int numberOfItemsStocked = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter artist name: ");
            String artistName = scanner.nextLine();

            System.out.println("Enter how many products you want to add: ");
            int numberOfProducts = Integer.parseInt(scanner.nextLine());

            Music music = new Music(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, artistName);
            LoadDataSaveData.getInventoryData().addItems(music);
            LoadDataSaveData.getInventoryData().addProductStock(music.getProductId(), numberOfProducts);

        }
        else if (category.equalsIgnoreCase("movie")) {
            // Code for creating Movie object
            System.out.println("Enter product id: ");
            int productId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter year published: ");
            int yearPublished = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.println("Enter discount: ");
            double discount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter number of items stocked: ");
            int numberOfItemsStocked = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter director: ");
            String director = scanner.nextLine();

            System.out.println("Enter how many products you want to add: ");
            int numberOfProducts = Integer.parseInt(scanner.nextLine());

            Movie movie = new Movie(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, director);
            LoadDataSaveData.getInventoryData().addItems(movie);
            LoadDataSaveData.getInventoryData().addProductStock(movie.getProductId(), numberOfProducts);
        }


    }
}
