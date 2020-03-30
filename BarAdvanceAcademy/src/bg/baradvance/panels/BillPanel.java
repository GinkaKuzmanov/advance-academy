package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Order;

import javax.swing.*;

public class BillPanel extends JPanel {
    JLabel billLabel;
    AdvanceAcademyBarFrame barFrame;
    Order order;

    public BillPanel(AdvanceAcademyBarFrame barFrame) {
        this.barFrame = barFrame;
        try {
            order = barFrame.repo.remove(barFrame.currentTableNumber);
            this.billLabel = new JLabel(order.billMessage());
            add(billLabel);
            returnToOperation(barFrame);
        }catch(NullPointerException npe){
            System.out.println(npe.getMessage());
            JLabel lbl = new JLabel("NO CURRENT ORDER!");
            add(lbl);
            returnToOperation(barFrame);
        }
    }

    private void returnToOperation(AdvanceAcademyBarFrame barFrame) {
        JButton jBtnReturn = new JButton("Return");

        jBtnReturn.addActionListener(e -> {
            barFrame.hideBillPanel();
            barFrame.showOperationPanel();
        });
        add(jBtnReturn);
    }
}
