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
        try {
            LoadDataSaveData.loadCustomerData();
            LoadDataSaveData.loadInventoryData();
            LoadDataSaveData.loadEmployeeData();
        }catch (Exception e){
            e.printStackTrace();
        }
        LoginForm loginForm = new LoginForm(null);
    }

}