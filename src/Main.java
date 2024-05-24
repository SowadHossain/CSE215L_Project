import dbMangers.LoadDataSaveData;
import entity.*;
import gui.LoginForm;
import util.StockableProduct;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //loading data
        System.out.println("test" );
        try {
            System.out.println("test" );
            LoadDataSaveData.loadCustomerData();
            System.out.println("test" );
            LoadDataSaveData.loadInventoryData();
            System.out.println("test" );
            LoadDataSaveData.loadEmployeeData();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("test2");
        LoginForm loginForm = new LoginForm(null);
    }

}