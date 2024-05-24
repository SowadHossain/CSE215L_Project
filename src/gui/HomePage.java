package gui;

import dbMangers.LoadDataSaveData;
import entity.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class HomePage extends JDialog {
    private MainMenuCustomerButtonFunctions btnFucntion = new MainMenuCustomerButtonFunctions();
    private static boolean buttonPressed = false;
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
        setMinimumSize(new Dimension(1100,575));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        customerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                btnFucntion.CustomerInfo();
                setVisible(true);
            }
        });
        productUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                btnFucntion.test();
                setVisible(true);
            }
        });


        newCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                btnFucntion.addCustomer();
                setVisible(true);
            }
                //MainMenuCustomerButtonFunctions;

        });
//
//        updateCustomerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        customerDetailsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        deleteCustomerDataButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        newProductButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        productUpdateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        productDetailsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        deleteProductButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        billingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage(null);
    }

}
