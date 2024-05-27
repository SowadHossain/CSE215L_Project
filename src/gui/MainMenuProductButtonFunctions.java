package gui;

import Exceptions.ProductNotFoundException;
import dbMangers.LoadDataSaveData;
import entity.Game;
import entity.Movie;
import entity.Music;
import util.Product;
import util.StockableProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuProductButtonFunctions {
    Scanner scanner = new Scanner(System.in);
    static ArrayList inventory = LoadDataSaveData.getInventoryData().getItems();


    public  void addNewProduct() {
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

            Game game = new Game(productId, name, price, yearPublished, genre, discount, numberOfItemsStocked, developer);
            LoadDataSaveData.getInventoryData().addItems(game);
            //LoadDataSaveData.getInventoryData().addProductStock(game.getProductId(), numberOfProducts);
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
    public void getProductDetails() throws ProductNotFoundException {

        System.out.print("Product Id: ");
        int productId = scanner.nextInt();
        for (Object object : inventory) {
            if (object instanceof Music) {
                Music music = (Music) object;
                if (music.getProductId() == productId) {
                    System.out.println("Product ID: " + music.getProductId());
                    System.out.println("Name: " + music.getName());
                    System.out.println("Price: " + music.getPrice());
                    System.out.println("Year Published: " + music.getYearPublished());
                    System.out.println("Genre: " + music.getGenre());
                    System.out.println("Discount: " + music.getDiscount());
                    System.out.println("Number of Items Stocked: " + music.getNumberOfItemsInStock());
                    System.out.println("Artist Name: " + music.getArtistName());
                } else if (object instanceof Movie) {
                    Movie movie = (Movie) object;
                    if (movie.getProductId() == productId) {
                        System.out.println("Product ID: " + movie.getProductId());
                        System.out.println("Name: " + movie.getName());
                        System.out.println("Price: " + movie.getPrice());
                        System.out.println("Year Published: " + movie.getYearPublished());
                        System.out.println("Genre: " + movie.getGenre());
                        System.out.println("Discount: " + movie.getDiscount());
                        System.out.println("Number of Items Stocked: " + movie.getNumberOfItemsInStock());
                        System.out.println("Director Name: " + movie.getDirector());

                    }
                } else if (object instanceof Game) {
                    Game game = (Game) object;
                    if (game.getProductId() == productId) {
                        System.out.println("Product ID: " + game.getProductId());
                        System.out.println("Name: " + game.getName());
                        System.out.println("Price: " + game.getPrice());
                        System.out.println("Year Published: " + game.getYearPublished());
                        System.out.println("Genre: " + game.getGenre());
                        System.out.println("Discount: " + game.getDiscount());
                        System.out.println("Number of Items Stocked: " + game.getNumberOfItemsInStock());
                        System.out.println("Developer Name: " + game.getDeveloper());

                    }
                    return;
                }
            }
            throw new ProductNotFoundException("Product with ID " + productId + " not found.");
        }
    }
    public void updateProductInfo() throws ProductNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product Id: ");
        int productId = scanner.nextInt();
        for (Object object : inventory) {
            if(object instanceof Music){
                Music music = (Music)object;
                if (music.getProductId() == productId) {
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    music.setName(newName);

                    System.out.println("Enter new price:");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    music.setPrice(newPrice);

                    System.out.println("Enter new year published:");
                    int newYearPublished = Integer.parseInt(scanner.nextLine());
                    music.setYearPublished(newYearPublished);

                    System.out.println("Enter new genre:");
                    String newGenre = scanner.nextLine();
                    music.setGenre(newGenre);

                    System.out.println("Enter new discount:");
                    double newDiscount = Double.parseDouble(scanner.nextLine());
                    music.setDiscount(newDiscount);

                    System.out.println("Enter new stock quantity:");
                    int newStockQuantity = Integer.parseInt(scanner.nextLine());
                    music.editStock(newStockQuantity);

                    System.out.println("Product information updated successfully.");

                } else if (object instanceof Game) {
                Game game = (Game)object;
                    if (game.getProductId() == productId) {
                        System.out.println("Enter new name:");
                        String newName = scanner.nextLine();
                        game.setName(newName);

                        System.out.println("Enter new price:");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        game.setPrice(newPrice);

                        System.out.println("Enter new year published:");
                        int newYearPublished = Integer.parseInt(scanner.nextLine());
                        game.setYearPublished(newYearPublished);

                        System.out.println("Enter new genre:");
                        String newGenre = scanner.nextLine();
                        game.setGenre(newGenre);

                        System.out.println("Enter new discount:");
                        double newDiscount = Double.parseDouble(scanner.nextLine());
                        game.setDiscount(newDiscount);

                        System.out.println("Enter new stock quantity:");
                        int newStockQuantity = Integer.parseInt(scanner.nextLine());
                        game.editStock(newStockQuantity);


                        System.out.println("Product information updated successfully.");

            } else {
                Movie movie = (Movie)object;
                        if (movie.getProductId() == productId) {
                            System.out.println("Enter new name:");
                            String newName = scanner.nextLine();
                            movie.setName(newName);

                            System.out.println("Enter new price:");
                            double newPrice = Double.parseDouble(scanner.nextLine());
                            movie.setPrice(newPrice);

                            System.out.println("Enter new year published:");
                            int newYearPublished = Integer.parseInt(scanner.nextLine());
                            movie.setYearPublished(newYearPublished);

                            System.out.println("Enter new genre:");
                            String newGenre = scanner.nextLine();
                            movie.setGenre(newGenre);

                            System.out.println("Enter new discount:");
                            double newDiscount = Double.parseDouble(scanner.nextLine());
                            movie.setDiscount(newDiscount);

                            System.out.println("Enter new stock quantity:");
                            int newStockQuantity = Integer.parseInt(scanner.nextLine());
                            movie.editStock(newStockQuantity);

                            System.out.println("Product information updated successfully.");

                        }
                        try {
                            LoadDataSaveData.saveInventoryData();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                return;
            }
        }
        throw new ProductNotFoundException("Product with ID " + productId + " not found.");
    }
}
}
