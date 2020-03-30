package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;

import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel {

    private AdvanceAcademyBarFrame barFrame;
    private JButton newOrderButton;
    private JButton existingOrderButton;
    private JButton getBillButton;

    public OperationPanel(AdvanceAcademyBarFrame barFrame) {

        //1 Add new order
        super(new FlowLayout());
        this.barFrame = barFrame;
        newOrderButton = new JButton("Add new order");
        add(newOrderButton);
        newOrderButton.addActionListener((e -> {
            AdvanceAcademyBarFrame.operationState = 1;
            if (barFrame.repo.contains(barFrame.currentTableNumber)) {
                JOptionPane.showMessageDialog(null, "There is order on this table!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            barFrame.hideOperationPanel();
            barFrame.showTablePanel();

        }));

        //2 Add to existing order
        existingOrderButton = new JButton("Add to existing order");
        add(existingOrderButton);
        existingOrderButton.addActionListener(e -> {
            AdvanceAcademyBarFrame.operationState = 2;
            barFrame.hideOperationPanel();
            barFrame.showTablePanel();

        });

        //3 Print bill
        getBillButton = new JButton("Print bill");
        add(getBillButton);
        getBillButton.addActionListener(e -> {
            AdvanceAcademyBarFrame.operationState = 3;
            barFrame.hideOperationPanel();
            barFrame.showTablePanel();

        });

    }

}