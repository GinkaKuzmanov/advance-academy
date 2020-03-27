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
//TODO: Fix the functionality in jPanels when to appear and to hide;
//TODO: Then how to create new Orders and differentiate between tables;

public class AdvanceAcademyBarFrame extends JFrame {

    public Repository<Order, String> repo = new ExistingOrdersRepo();
    private LoginPanel loginPanel;
    private OperationPanel operationPanel;
    private TablePanel tablePanel;
    private ProductPanel productPanel;
    private BillPanel billPanel;
    public Waiter currentWaiter;
    public String currentTableNumber;
    public List<Product> products = new ArrayList<>();
    private CardLayout panelsCards;

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
        loginPanel = new LoginPanel(this);
        loginPanel.setSize(getWidth(), getHeight());
        add(loginPanel);
    }

    public void showOperationPanel() {
        loginPanel.setVisible(false);
        remove(loginPanel);

        operationPanel = new OperationPanel(this);
        add(operationPanel);

        operationPanel.setSize(getWidth(), getHeight());
        operationPanel.setVisible(true);

    }

    public void showTablePanel(int operationState) {
        //need another method to show for which table after billing
        operationPanel.setVisible(false);
        remove(operationPanel);
        tablePanel.operationState = operationState;
        tablePanel = new TablePanel(this);
        add(tablePanel);

        tablePanel.setSize(getWidth(), getHeight());
        tablePanel.setVisible(true);
    }

    public void showProductPanel() {
        tablePanel.setVisible(false);
        remove(tablePanel);
        productPanel = new ProductPanel(this);
        add(productPanel);

        productPanel.setSize(getWidth(), getHeight());
        productPanel.setVisible(true);
    }

    public void showBillPanel() {
        try {
            remove(productPanel);
            tablePanel.setVisible(false);
            billPanel = new BillPanel(this);
            add(billPanel);
            billPanel.setSize(getWidth(), getHeight());
            billPanel.setVisible(true);
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null,
                    "Add an order first!", "Error", JOptionPane.ERROR_MESSAGE);
            operationPanel.setVisible(true);
        }
    }

    public void returnToOperation() {
        productPanel.setVisible(false);
        remove(productPanel);
        tablePanel.setVisible(false);
        operationPanel.setSize(getWidth(), getHeight());
        operationPanel.setVisible(true);

    }


}
