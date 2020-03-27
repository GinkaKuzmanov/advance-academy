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
            AdvanceAcademyBarFrame.operationState = 1;
            barFrame.showTablePanel();

        }));
        existingOrderButton = new JButton("Add to existing order");
        add(existingOrderButton);
        existingOrderButton.addActionListener(e -> {
            AdvanceAcademyBarFrame.operationState = 2;
            barFrame.showTablePanel();

        });

        getBillButton = new JButton("Print bill");
        add(getBillButton);
        getBillButton.addActionListener(e -> {
            AdvanceAcademyBarFrame.operationState = 3;
            barFrame.showTablePanel();

        });

    }

}