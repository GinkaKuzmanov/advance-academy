package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Waiter;
import bg.baradvance.repositories.WaiterRepositories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class LoginPanel extends JPanel {

    private JLabel waiterLabel;
    private JTextField pinCodeField;
    private JButton loginButton;
    private AdvanceAcademyBarFrame barFrame;
    WaiterRepositories waiterRepositories = new WaiterRepositories();
    List<Waiter> waiterList = waiterRepositories.getWaiters();

    public LoginPanel(AdvanceAcademyBarFrame barFrame) {
        this.barFrame = barFrame;
        waiterLabel = new JLabel("Waiter Log Details:");
        add(waiterLabel);
        pinCodeField = new JTextField("Enter pin!");
        add(pinCodeField);
        pinCodeField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pinCodeField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        loginButton = new JButton("Log in");
        add(loginButton);
        loginButton.addActionListener(e -> {
            boolean isValid = false;
            for (Waiter waiter : this.waiterList) {
                if (validPin(waiter)) {
                    barFrame.currentWaiter = waiter;
                    barFrame.showOperationPanel();
                    isValid = true;
                }
            }
            if (!isValid) {
                JOptionPane.showMessageDialog(null, "Password do not match!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        });


    }


    public boolean validPin(Waiter waiter) {
        return waiter.getPinCode().equals(pinCodeField.getText());
    }
}
