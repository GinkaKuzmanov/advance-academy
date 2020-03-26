package bg.baradvance.panels;

import bg.baradvance.AdvanceAcademyBarFrame;
import bg.baradvance.models.Waiter;
import bg.baradvance.repositories.WaiterRepositories;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LoginPanel extends JPanel {

    private JLabel waiterLabel;
    private JTextField pinCodeField;
    private JButton loginButton;
    private AdvanceAcademyBarFrame barFrame;
    WaiterRepositories waiterRepositories = new WaiterRepositories();
    List<Waiter> waiterList = waiterRepositories.getWaiters();
    public LoginPanel(AdvanceAcademyBarFrame barFrame) {
        super(new FlowLayout());
        this.barFrame = barFrame;
        waiterLabel = new JLabel("Waiter Log Details:");
        add(waiterLabel);
        pinCodeField = new JTextField("Enter pin!");
        add(pinCodeField);
        loginButton = new JButton("Log in");
        add(loginButton);
        loginButton.addActionListener(e -> {
            boolean isValid = false;
            for (Waiter waiter:this.waiterList) {
                if(validPin(waiter)) {
                    barFrame.showOperationPanel();
                    isValid = true;
                }
            }
            if(!isValid){
                JOptionPane.showMessageDialog(null,"Password do not match!",
                        "Error",JOptionPane.ERROR_MESSAGE);
            }

        });


    }


    public boolean validPin(Waiter waiter){
        return waiter.getPinCode().equals(pinCodeField.getText());
    }
}
