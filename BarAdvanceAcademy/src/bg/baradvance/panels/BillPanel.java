package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Order;

import javax.swing.*;
import java.awt.*;

public class BillPanel extends JPanel {
    JLabel billLabel;
    AdvanceAcademyBarFrame barFrame;
    Order order;

    public BillPanel(AdvanceAcademyBarFrame barFrame) {
        super(new FlowLayout());
        this.barFrame = barFrame;
        try {
            order = barFrame.repo.fetch(barFrame.currentTableNumber);
            this.billLabel = new JLabel(order.billMessage());
            add(billLabel);
        }catch(NullPointerException npe){
            System.out.println(npe.getMessage());
            JLabel lbl = new JLabel("NO CURRENT ORDER!");
            add(lbl);
        }
    }
}
