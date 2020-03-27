package bankaccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmFrame extends JFrame {
    public JButton withdrawButton, checkBalanceButton, depositButton;
    public JTextField amountField;

    public AtmFrame() {
        super("ATM");
        amountField = new JTextField();
        amountField.setSize(50, 25);
        add(amountField);
        withdrawButton = new JButton("Withdrawal");
        add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Please, enter your name code");
                Client client = new Client(name);
                String pinCode = JOptionPane.showInputDialog("Please, enter your pin code.");
                BankAccount account = new BankAccount(client, pinCode);
                if (!amountField.getText().isEmpty() || amountField != null) {
                    account.withdraw(Double.parseDouble(amountField.getText()));
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter amount to withdraw",
                            "Required Field Missing",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

    }

}
