package gui;

import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.LoginFailedException;
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

                try {
                    employee = getAuthenticateUser(userId, userPassword);
                        dispose();
                        System.out.println("Login Successful:");
                        System.out.println((employee.getEmployeeID()));
                        System.out.println(employee.getName());
                        HomePage homePage = new HomePage(null);
                } catch (LoginFailedException ex) {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Invalid ID or Password",
                            "Try Again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            try {
                setVisible(false);
                SignIn.signIn();
                setVisible(true);
            } catch (EmployeeAlreadyExistsException ex) {
                ex.printStackTrace();
                setVisible(true);
            }
            }
        });

        setVisible(true);
    }

    private Employee getAuthenticateUser(int id,String password) throws LoginFailedException {
        Employee employee = new Employee(null,0,null,null);
        try {
            LoadDataSaveData.loadEmployeeData();
        }catch (Exception e){
            e.printStackTrace();
        }

        final HashMap<Integer, String> map = LoadDataSaveData.getEmployeeLoginData();
        System.out.println(id + password + map.containsKey(id) + (password.compareTo(map.get(id)) == 0));
        if(map.containsKey(id) & (password.compareTo(map.get(id)) == 0)){
            employee.setEmployeeID(id);
            employee.setPassword(map.get(id));
            return employee;
        }
        throw new LoginFailedException();
    }
}

