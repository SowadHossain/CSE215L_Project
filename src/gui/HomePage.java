package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JDialog {
    private JButton newCustomerButton;
    private JButton productUpdateButton;
    private JButton updateCustomerButton;
    private JButton customerDetailsButton;
    private JButton deleteCustomerDataButton;
    private JButton newProductButton;
    private JButton deleteProductButton;
    private JButton productDetailsButton;
    private JButton billingButton;
    private JButton logoutButton;
    private JButton closeApplicationButton;
    private JPanel MenuPanel;


    public HomePage(JFrame parent) {
        super(parent);
        setTitle("Main Menu");
        setContentPane(MenuPanel);
        setMinimumSize(new Dimension(900,575));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        newCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New customer button pressed");
            }
        });

        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        customerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteCustomerDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        newProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        productUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        productDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        billingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test t = new test(null);
            }
        });
        setVisible(true);
    }

    public void main(String[] args) {
        dispose();
        HomePage homePage = new HomePage(null);

    }
}
