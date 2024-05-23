import dbMangers.LoadDataSaveData;
import entity.Employee;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("admin",123,"abc","pass");
        LoadDataSaveData.employeeData.add(e1);
        try {
            LoadDataSaveData.saveEmployeeData();
            LoadDataSaveData.loadEmployeeData();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}