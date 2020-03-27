package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;

import javax.swing.*;
import java.awt.*;
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
        super(new FlowLayout());
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

    private void chosenOperation(AdvanceAcademyBarFrame barFrame) {
        if (AdvanceAcademyBarFrame.operationState == 1
                || AdvanceAcademyBarFrame.operationState == 2) {
            barFrame.showProductPanel();
        } else if (AdvanceAcademyBarFrame.operationState == 3) {
            barFrame.showBillPanel();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        barFrame.currentTableNumber = ((JButton) e.getSource()).getText();
        chosenOperation(barFrame);
    }
}
