package gui;

import entity.Invoice;
import util.Product;
import util.StockableProduct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveProductFromBill extends JDialog {
    private Invoice invoice = new Invoice();
    private Product selectedproduct;
    private int quantity;
    private JTextField productIDTextField;
    private JTextField NameTextField;
    private JTextField quantityTextField;
    private JTextField unitPriceTextField;
    private JButton updateButton;
    private JPanel removePanel;

    public RemoveProductFromBill(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(removePanel);
        setMinimumSize(new Dimension(650,475));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        productIDTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(productIDTextField.getText());
                for (Product product : invoice.getCart())
                    if (id == product.getProductId()) {
                        selectedproduct = product;
                        NameTextField.setText(product.getName());
                        unitPriceTextField.setText(String.valueOf(product.getPrice()));
                    }
            }
        });

        NameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (productIDTextField.getText());
                for (Product product : invoice.getCart())
                    if (name == productIDTextField.getName()) {
                        selectedproduct = product;
                        NameTextField.setText(product.getName());
                        unitPriceTextField.setText(String.valueOf(product.getPrice()));
                    }
            }
        });
        quantityTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity = Integer.parseInt(quantityTextField.getText());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                invoice.removeProduct(selectedproduct);
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        RemoveProductFromBill rm = new RemoveProductFromBill(null);
    }

}
