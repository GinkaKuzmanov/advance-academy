package bg.baradvance;

import bg.baradvance.interfaces.Repository;
import bg.baradvance.models.Order;
import bg.baradvance.models.Product;
import bg.baradvance.models.Waiter;
import bg.baradvance.panels.*;
import bg.baradvance.repositories.ExistingOrdersRepo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AdvanceAcademyBarFrame extends JFrame {

    public ExistingOrdersRepo repo = new ExistingOrdersRepo();
    public LoginPanel loginPanel;
    public OperationPanel operationPanel;
    public TablePanel tablePanel;
    public ProductPanel productPanel;
    public BillPanel billPanel;
    public Waiter currentWaiter;
    public String currentTableNumber;
    public List<Product> products = new ArrayList<>();
    public Order order = new Order();


    //static -> to be independent of instances
    public static int operationState;


    public AdvanceAcademyBarFrame() {
        super("Bar Advance Academy");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        showLoginPanel();

    }

    public void showLoginPanel() {
        //Panel for login
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(), getHeight());
        add(loginPanel);
    }

    public void hideLoginPanel(){
        loginPanel.setVisible(false);
        remove(loginPanel);
    }


    public void showOperationPanel() {
        //Panel with options menu
        operationPanel = new OperationPanel(this);
        operationPanel.setSize(getWidth(), getHeight());
        add(operationPanel);
    }
    public void hideOperationPanel(){
        operationPanel.setVisible(false);
        remove(operationPanel);
    }

    public void showTablePanel() {
        tablePanel = new TablePanel(this);
        tablePanel.setSize(getWidth(), getHeight());
        add(tablePanel);
    }

    public void hideTablePanel(){
        tablePanel.setVisible(false);
        remove(tablePanel);
    }

    public void showProductPanel() {
        //Panel with products/items
        productPanel = new ProductPanel(this);
        productPanel.setSize(getWidth(), getHeight());
        add(productPanel);
    }
    public void hideProductPanel(){
        productPanel.setVisible(false);
        remove(productPanel);
    }

    public void showBillPanel() {
            billPanel = new BillPanel(this);
            billPanel.setSize(getWidth(), getHeight());
            add(billPanel);
    }
    public void hideBillPanel() {
        billPanel.setVisible(false);
        remove(billPanel);
    }



}
