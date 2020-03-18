package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalcExercise extends JFrame implements ActionListener {
    public JLabel resultLabel;
    public JTextField operandOne;
    public JTextField operandTwo;
    public JButton addButton, subtractButton, multiplyButton, divideButton;

    public CalcExercise() {
        super("Calculator");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addButton = new JButton("Add");
        add(addButton);
        addButton.addActionListener(this);
        subtractButton = new JButton("Subtract");
        add(subtractButton);
        subtractButton.addActionListener(this);
        multiplyButton = new JButton("Multiply");
        add(multiplyButton);
        multiplyButton.addActionListener(this);
        divideButton = new JButton("Divide");
        add(divideButton);
        divideButton.addActionListener(this);

        resultLabel = new JLabel();
        add(resultLabel);
        operandOne = new JTextField();
        operandOne.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (operandOne.getText().equals("First Operand"))
                    operandOne.setText("");
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
        operandOne.setText("First Operand");
        add(operandOne);
        operandTwo = new JTextField();
        operandTwo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (operandTwo.getText().equals("Second Operand"))
                    operandTwo.setText("");
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
        operandTwo.setText("Second Operand");
        add(operandTwo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = 0, num2 = 0;
        try {
            num1 = Double.parseDouble(operandOne.getText());
            num2 = Double.parseDouble(operandTwo.getText());
        } catch (NumberFormatException nfe) {
            resultLabel.setText("Only numbers allowed.");
        }

        if (e.getSource() == addButton) {
            double result = ArithmeticOperations.additionTwoNumbers(num1, num2);
            resultLabel.setText(String.valueOf(result));
        }
        if (e.getSource() == subtractButton) {
            double result = ArithmeticOperations.subtractTwoNumbers(num1, num2);
            resultLabel.setText(String.valueOf(result));
        }
        if (e.getSource() == multiplyButton) {
            double result = ArithmeticOperations.multiplyTwoNumbers(num1, num2);
            resultLabel.setText(String.valueOf(result));
        }
        if (e.getSource() == divideButton) {
            double result = ArithmeticOperations.divideTwoNumbers(num1, num2);
            resultLabel.setText(String.valueOf(result));
        }


    }
}
