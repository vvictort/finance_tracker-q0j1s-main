package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import user.BudgetApp;

public class GoalManagementTab extends BaseTab {
    private BudgetApp budgetApp;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructor
    public GoalManagementTab(BudgetApp budgetApp, JTabbedPane tabbedPane) {
        super();
        this.budgetApp = budgetApp;
        this.tabbedPane = tabbedPane;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with spacing
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                "Goal Management", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Serif", Font.BOLD, 14), new Color(0, 123, 255)));

        // Add buttons
        add(createButton("Add goals", "AddGoal"));
        add(createButton("Remove goals", "RemoveGoal"));
        add(createButton("Print goals", "PrintGoal"));
    }

    // EFFECTS: creates a button with the given text and action command
    private JButton createButton(String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setBackground(new Color(0, 123, 255)); // Blue background
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // padding
        button.addActionListener(e -> handleButtonAction(actionCommand, text)); // Handle button actions
        return button;
    }

    // EFFECTS: handles button actions
    private void handleButtonAction(String actionCommand, String title) {
        if (actionCommand.equals("PrintGoal")) {
            // Print goals
            String goals = budgetApp.printGoal(); // Ensure this method returns a string
            JOptionPane.showMessageDialog(this, goals, "Goals", JOptionPane.INFORMATION_MESSAGE);
        } else {
            createInputTab(actionCommand, title);
        }
    }

    // EFFECTS: creates a new tab with input fields and a "Done" button
    private void createInputTab(String actionCommand, String title) {
        // Create a new panel for the tab
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns for inputs
        inputPanel.setBackground(new Color(240, 240, 240)); // Light gray background

        JTextField amountField = null;
        JTextField typeField = null;

        if (actionCommand.equals("AddGoal")) {
            // Add input fields for "Add goals"
            JLabel amountLabel = new JLabel("Amount:");
            amountField = new JTextField();

            JLabel typeLabel = new JLabel("Goal Type:");
            typeField = new JTextField();

            inputPanel.add(amountLabel);
            inputPanel.add(amountField);
            inputPanel.add(typeLabel);
            inputPanel.add(typeField);
        } else if (actionCommand.equals("RemoveGoal")) {
            // Add input field for "Remove goals"
            JLabel valueLabel = new JLabel("Goal Value:");
            amountField = new JTextField();

            inputPanel.add(valueLabel);
            inputPanel.add(amountField);
        }

        // Add a "Done" button
        JButton doneButton = new JButton("Done");
        doneButton.setFont(new Font("Serif", Font.BOLD, 14));
        doneButton.setBackground(new Color(0, 123, 255)); // Blue background
        doneButton.setForeground(Color.WHITE); // White text
        doneButton.setFocusPainted(false);
        JTextField finalAmountField = amountField;
        JTextField finalTypeField = typeField;
        doneButton.addActionListener(e -> {
            String amountInput = finalAmountField != null ? finalAmountField.getText() : "";
            String typeInput = finalTypeField != null ? finalTypeField.getText() : "";

            if (actionCommand.equals("AddGoal")) {
                if (!amountInput.isEmpty() && !typeInput.isEmpty()) {
                    try {
                        int amount = Integer.parseInt(amountInput);
                        budgetApp.addGoal(amount, typeInput);
                        JOptionPane.showMessageDialog(this, "Goal added: " + amount + " (" + typeInput + ")");
                        // Close the tab
                        int index = tabbedPane.indexOfComponent(inputPanel);
                        if (index != -1) {
                            tabbedPane.removeTabAt(index);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (actionCommand.equals("RemoveGoal")) {
                if (!amountInput.isEmpty()) {
                    try {
                        int amount = Integer.parseInt(amountInput);
                        budgetApp.removeGoal(amount);
                        JOptionPane.showMessageDialog(this, "Goal removed: " + amount);
                        // Close the tab
                        int index = tabbedPane.indexOfComponent(inputPanel);
                        if (index != -1) {
                            tabbedPane.removeTabAt(index);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid value. Please enter a valid number.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Field must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        inputPanel.add(new JLabel());
        inputPanel.add(doneButton);

        tabbedPane.addTab(title + " Input", inputPanel);
        tabbedPane.setSelectedComponent(inputPanel); // Switch to the new tab
    }
}
