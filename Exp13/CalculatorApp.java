import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton[] buttons;
    private String[] buttonLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "=", "+"
    };
    
    private String input = "";
    private String operator = "";

    private ArrayList<String> history = new ArrayList<>();

    public CalculatorApp() {
        setTitle("Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());

        inputField = new JTextField(10);
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(inputField, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("SansSerif", Font.PLAIN, 20));
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            input += command;
            inputField.setText(input);
        } else if (command.equals("C")) {
            input = "";
            inputField.setText("");
        } else if (command.matches("[+\\-*/]")) {
            if (!input.isEmpty()) {
                operator = command;
                inputField.setText(input + operator);
                input = "";
            }
        } else if (command.equals("=")) {
            if (!input.isEmpty() && !operator.isEmpty()) {
                String expression = inputField.getText() + input;
                try {
                    String result = evaluateExpression(expression);
                    history.add(expression + " = " + result);
                    resultArea.append(expression + " = " + result + "\n");
                    input = result;
                    inputField.setText(result);
                    operator = "";
                } catch (Exception ex) {
                    inputField.setText("Error");
                }
            }
        }
    }

    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(evalExpression(expression));
        } catch (Exception ex) {
            return "Error";
        }
    }

    private double evalExpression(String expression) {
        String[] tokens = expression.split(" ");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String op = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);
            if (op.equals("+")) {
                result += operand;
            } else if (op.equals("-")) {
                result -= operand;
            } else if (op.equals("*")) {
                result *= operand;
            } else if (op.equals("/")) {
                if (operand == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result /= operand;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calculator = new CalculatorApp();
            calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calculator.setVisible(true);
        });
    }
}
