package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Order;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablePanel extends JPanel implements ActionListener {

    private JButton table10Btn;
    private JButton table15Btn;
    private JButton table20Btn;
    private JButton table25Btn;
    private JButton table30Btn;
    private JButton table35Btn;
    private JButton table40Btn;
    private JButton table45Btn;
    private JButton table50Btn;


    AdvanceAcademyBarFrame barFrame;

    public TablePanel(AdvanceAcademyBarFrame barFrame) {
        this.barFrame = barFrame;
        this.table10Btn = new JButton("10");
        add(table10Btn);
        table10Btn.addActionListener(this);
        this.table15Btn = new JButton("15");
        add(table15Btn);
        table15Btn.addActionListener(this);
        this.table20Btn = new JButton("20");
        add(table20Btn);
        table20Btn.addActionListener(this);
        this.table25Btn = new JButton("25");
        add(table25Btn);
        table25Btn.addActionListener(this);
        this.table30Btn = new JButton("30");
        add(table30Btn);
        table30Btn.setActionCommand("30");
        table30Btn.addActionListener(this);
        this.table35Btn = new JButton("35");
        add(table35Btn);
        table35Btn.addActionListener(this);
        this.table40Btn = new JButton("40");
        add(table40Btn);
        table40Btn.addActionListener(this);
        this.table45Btn = new JButton("45");
        add(table45Btn);
        table45Btn.addActionListener(this);
        this.table50Btn = new JButton("50");
        add(table50Btn);
        table50Btn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        barFrame.currentTableNumber = ((JButton) e.getSource()).getText();

        String pressedButton = ((JButton) e.getSource()).getText();

        boolean isProductFound = false;
        for (Order order : barFrame.repo) {

            if (order.getTableNumber().equals(pressedButton)) {
                productFound();
                isProductFound = true;
                System.out.println("is  found");
            }

        }
        if (!isProductFound) {
            productNotFound(pressedButton);
            System.out.println("is not found");
        }

    }

    private void productFound() {

        if (AdvanceAcademyBarFrame.operationState == 1) {
            //OPTION 1  FOUND
            //TODO ADD POPUP ORDER ALREDY EXISTS
            JOptionPane.showMessageDialog(null
                    , "There is already an order for this table",
                    "Warning", JOptionPane.ERROR_MESSAGE);

        } else if (AdvanceAcademyBarFrame.operationState == 2) {
            //OPTION 2  FOUND
            //todo show items panel
            barFrame.order.setTableNumber(this.barFrame.currentTableNumber);
            barFrame.order.setWaiter(this.barFrame.currentWaiter);
            barFrame.hideTablePanel();
            barFrame.showProductPanel();
        }
        if (AdvanceAcademyBarFrame.operationState == 3) {
            //OPTION 3  FOUND
            barFrame.hideTablePanel();
            barFrame.showBillPanel();
        }
    }

    private void productNotFound(String table) {

        if (AdvanceAcademyBarFrame.operationState == 1) {
            //OPTION 1 NOT FOUND
            // TODO: initialize the order object and put it into map
            //todo add table number and waiter to repo
            //sazdavash order i dobavq6 weiter i table id
            barFrame.order.setTableNumber(this.barFrame.currentTableNumber);
            barFrame.order.setWaiter(this.barFrame.currentWaiter);
            barFrame.hideTablePanel();
            barFrame.showProductPanel();
        } else if (AdvanceAcademyBarFrame.operationState == 2) {
            //OPTION 2 NOT FOUND
            //TODO: existing option order not =found show message no order yet

            if (!barFrame.repo.contains(barFrame.currentTableNumber)) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "There is no order on this table.Would you like to create one?", "Create Order",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    //add order
                    //todo add table number and waiter to repo
                    barFrame.order.setTableNumber(this.barFrame.currentTableNumber);
                    barFrame.order.setWaiter(this.barFrame.currentWaiter);
                    barFrame.hideTablePanel();
                    barFrame.showProductPanel();
                } else if (choice == JOptionPane.NO_OPTION) {
                    //do not add order !!!
                    barFrame.hideTablePanel();
                    barFrame.showOperationPanel();
                }
            }
//            else{
//                barFrame.hideTablePanel();
//                barFrame.showProductPanel();
//            }

        }
        if (AdvanceAcademyBarFrame.operationState == 3) {
            //OPTION 3 NOT FOUND
            JOptionPane.showMessageDialog(null
                    , "No existing order fiound",
                    "No order found", JOptionPane.ERROR_MESSAGE);

        }
    }
}
