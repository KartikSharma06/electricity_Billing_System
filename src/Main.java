import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Electricity Billing System");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Add components to the panel
        JLabel nameLabel = new JLabel("Customer Name:");
        JTextField nameField = new JTextField();

        JLabel unitsLabel = new JLabel("Enter units consumed:");
        JTextField unitsField = new JTextField();

        JButton calculateButton = new JButton("Calculate Bill");

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input from text fields
                String customerName = nameField.getText();
                double unitsConsumed = Double.parseDouble(unitsField.getText());

                // Calculate bill amount
                double billAmount = calculateBill(unitsConsumed);

                // Display the bill in a message dialog
                JOptionPane.showMessageDialog(null,
                        "Electricity Bill Statement\n" +
                                "Customer Name: " + customerName + "\n" +
                                "Units Consumed: " + unitsConsumed + "\n" +
                                "Bill Amount: Rs." + billAmount,
                        "Bill Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(unitsLabel);
        panel.add(unitsField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(calculateButton);

        // Add the panel to the frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }

    // Function to calculate the bill amount based on units consumed
    private static double calculateBill(double unitsConsumed) {
        // Assuming a simple billing formula, you can customize this based on actual rules
        double ratePerUnit = 3.50; // Rate per unit of electricity
        return unitsConsumed * ratePerUnit;
    }
}