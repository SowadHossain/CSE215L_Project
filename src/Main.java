import dbMangers.LoadDataSaveData;
import entity.*;
import gui.LoginForm;
import util.StockableProduct;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        Inventory inventory = LoadDataSaveData.getInventoryData();

        //loading data
        System.out.println("test" );
        try {
            LoadDataSaveData.loadInventoryData();
        }catch (Exception e){
            e.printStackTrace();
        }

        Invoice invoice = new Invoice();

        invoice.addProduct(inventory.getItem(101));
        invoice.addProduct(inventory.getItem(201));
        invoice.addProduct(inventory.getItem(301));

        invoice.getInvoice();

        System.out.println("test2");
        LoginForm loginForm = new LoginForm(null);
    }

}