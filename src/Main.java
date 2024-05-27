import dbMangers.LoadDataSaveData;
import entity.*;
import gui.LoginForm;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Inventory inventory = LoadDataSaveData.getInventoryData();
        try {
            LoadDataSaveData.loadCustomerData();
            LoadDataSaveData.loadCustomerData();
            LoadDataSaveData.loadInventoryData();
        }catch (Exception e){

        }

        Invoice invoice = new Invoice();

        invoice.addProduct(inventory.getItem(101));
        invoice.addProduct(inventory.getItem(201));
        invoice.addProduct(inventory.getItem(102));


        LoginForm loginForm = new LoginForm(null);
    }

}