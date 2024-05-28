package gui;
import dbMangers.LoadDataSaveData;
import entity.Inventory;
import entity.Invoice;
import util.Product;

import java.sql.SQLOutput;
import java.util.Scanner;

import javax.swing.*;

public class Billing {
    public Billing() {
    }

    Inventory inventory= LoadDataSaveData.getInventoryData();
    Invoice invoice = new Invoice();

    Scanner scanner = new Scanner(System.in);

    public void createBill(){

        while (true) {
            System.out.println("Enter product id (or type 'exit' to quit or type 'show' to show invoice): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("show")) {
                System.out.println(invoice.getInvoice());
                continue;
            }

            try {
                int productId = Integer.parseInt(input);

                System.out.println("How many products you want to add: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < quantity; i++) {
                    invoice.addProduct(inventory.getItem(productId));
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid product id and quantity.");
            }
        }
    }
}
