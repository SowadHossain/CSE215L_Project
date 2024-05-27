package gui;

import dbMangers.LoadDataSaveData;
import entity.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginForm extends JDialog {
    private JPanel LoginPanel;
    private JTextField usernameTxtField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton signInButton;
    private JTextField idTextField;
    private JButton submitButton;
    private Employee employee;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(650,475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId =Integer.parseInt(usernameTxtField.getText());
                String userPassword = String.valueOf(passwordField1.getPassword());

                employee = getAuthenticateUser(userId,userPassword);
                if(employee.getEmployeeID() != 0){
                    dispose();
                    System.out.println("Login Successful:");
                    System.out.println((employee.getEmployeeID()));
                    System.out.println(employee.getName());
                    HomePage homePage = new HomePage(null);
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Invalid ID or Password",
                            "Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    private Employee getAuthenticateUser(int id,String password){
        Employee employee = new Employee(null,0,null,null);
        try {
            LoadDataSaveData.loadEmployeeData();
        }catch (Exception e){
            e.printStackTrace();
        }

        final HashMap<Integer, String> map = LoadDataSaveData.getEmployeeLoginData();
        if(map.containsKey(id) & (password.compareTo(map.get(id)) == 0)){
            employee.setEmployeeID(id);
            employee.setPassword(map.get(id));
        }

        return employee;
    }
}
