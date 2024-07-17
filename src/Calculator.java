import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberLabel.setBounds(50, 30, 100, 30);
        add(firstNumberLabel);

        firstNumberField = new JTextField();
        firstNumberField.setBounds(160, 30, 150, 30);
        add(firstNumberField);

        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberLabel.setBounds(50, 70, 100, 30);
        add(secondNumberLabel);

        secondNumberField = new JTextField();
        secondNumberField.setBounds(160, 70, 150, 30);
        add(secondNumberField);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 110, 100, 30);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(160, 110, 150, 30);
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("+");
        addButton.setBounds(50, 150, 50, 30);
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(110, 150, 50, 30);
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 150, 50, 30);
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(230, 150, 50, 30);
        divideButton.addActionListener(this);
        add(divideButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 150, 70, 30);
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
                    return;
                }
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers only.");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}