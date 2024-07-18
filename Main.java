import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField firstNumber, secondNumber, result;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel firstLabel = new JLabel("First Number:");
        firstLabel.setBounds(50, 50, 100, 30);
        add(firstLabel);

        firstNumber = new JTextField();
        firstNumber.setBounds(150, 50, 150, 30);
        add(firstNumber);

        JLabel secondLabel = new JLabel("Second Number:");
        secondLabel.setBounds(50, 100, 100, 30);
        add(secondLabel);

        secondNumber = new JTextField();
        secondNumber.setBounds(150, 100, 150, 30);
        add(secondNumber);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 150, 100, 30);
        add(resultLabel);

        result = new JTextField();
        result.setBounds(150, 150, 150, 30);
        result.setEditable(false);
        add(result);

        addButton = new JButton("+");
        addButton.setBounds(50, 200, 50, 30);
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(110, 200, 50, 30);
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 200, 50, 30);
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(230, 200, 50, 30);
        divideButton.addActionListener(this);
        add(divideButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(290, 200, 70, 30);
        clearButton.addActionListener(this);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumber.getText());
            double num2 = Double.parseDouble(secondNumber.getText());
            double res = 0;

            if (e.getSource() == addButton) {
                res = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                res = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                res = num1 * num2;
            } else if (e.getSource() == divideButton) {
                res = num1 / num2;
            } else if (e.getSource() == clearButton) {
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                return;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
