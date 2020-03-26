package bg.baradvance;

import bg.baradvance.models.Product;
import bg.baradvance.models.Waiter;
import bg.baradvance.panels.LoginPanel;
import bg.baradvance.panels.OperationPanel;
import bg.baradvance.panels.ProductPanel;
import bg.baradvance.panels.TablePanel;
import bg.baradvance.repositories.ProductRepo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class AdvanceAcademyBarFrame extends JFrame {

    LoginPanel loginPanel;
    OperationPanel operationPanel;
    TablePanel tablePanel;
    ProductPanel productPanel;
    public Waiter currentWaiter;
    public int currentTableNumber;
    List<Product> products = new ArrayList<>();
    //must hold the current waiter,
    // current table number,current and chosenProducts as a list
    //static -> to be independent of instances
    public static int operationState = 0;


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
        operationPanel = new OperationPanel(this);
        add(operationPanel);
        remove(loginPanel);
        operationPanel.setSize(getWidth(), getHeight());
        operationPanel.setVisible(true);

    }

    public void showTablePanel(){
        operationPanel.setVisible(false);
        tablePanel = new TablePanel(this);
        add(tablePanel);
        remove(operationPanel);
        tablePanel.setSize(getWidth(),getHeight());
        tablePanel.setVisible(true);
    }

    public void showProductPanel(){
        tablePanel.setVisible(false);
        productPanel = new ProductPanel(this);
        add(productPanel);
        remove(tablePanel);
        productPanel.setSize(getWidth(),getHeight());
        productPanel.setVisible(true);

    }


}
