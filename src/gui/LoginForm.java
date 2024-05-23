package gui;

import entity.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JDialog {
    private JPanel LoginPanel;
    private JTextField usernameTxtField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton signInButton;
    private JTextField idTextField;
    private JButton submitButton;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(650,475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserName = usernameTxtField.getText();
                String userPassword = String.valueOf(passwordField1.getPassword());
                getAuthenticateUser(UserName,userPassword);
            }
        });
    }
    private Employee getAuthenticateUser(String username,String password){
        Employee employee = null;
        return employee;
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
    }

}
