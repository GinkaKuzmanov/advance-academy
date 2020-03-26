package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;

import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel {

    private AdvanceAcademyBarFrame barFrame;
    private JButton newOrderButton;
    private JButton existingOrderButton;
    private JButton getBillButton;

    public OperationPanel(AdvanceAcademyBarFrame barFrame){
        super(new FlowLayout());
        this.barFrame = barFrame;
        newOrderButton = new JButton("Add new order");
        add(newOrderButton);
        newOrderButton.addActionListener((e -> {
            barFrame.showTablePanel();
            AdvanceAcademyBarFrame.operationState = 1;
        }));
        existingOrderButton = new JButton("Add to existing order");
        add(existingOrderButton);
        existingOrderButton.addActionListener(e -> {
            barFrame.showTablePanel();
            AdvanceAcademyBarFrame.operationState = 2;
        });

        getBillButton = new JButton("Print bill");
        add(getBillButton);
        getBillButton.addActionListener(e -> {
            barFrame.showTablePanel();
            AdvanceAcademyBarFrame.operationState = 3;
        });

    }

}