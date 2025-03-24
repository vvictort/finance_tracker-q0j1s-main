package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import user.BudgetApp;

public class ExpenseManagementTab extends BaseTab {
    private BudgetApp budgetApp;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructor
    public ExpenseManagementTab(BudgetApp budgetApp, JTabbedPane tabbedPane) {
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
                "Expense Management", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Serif", Font.BOLD, 14), new Color(0, 123, 255)));

        // Add buttons
        add(createButton("Add expenses", "AddExpense"));
        add(createButton("Remove expenses", "RemoveExpense"));
        add(createButton("Print expenses", "PrintExpense"));
    }

    // EFFECTS: creates a button with the given text and action command
    private JButton createButton(String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setBackground(new Color(0, 123, 255)); // Blue background
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        button.addActionListener(e -> handleButtonAction(actionCommand, text)); // Handle button action
        return button;
    }

    // EFFECTS: handles button actions and creates a new tab for input if needed
    private void handleButtonAction(String actionCommand, String title) {
        switch (actionCommand) {
            case "AddExpense":
            case "RemoveExpense":
                createInputTab(actionCommand, title);
                break;
            case "PrintExpense":
                String expenses = budgetApp.printExpense();
                JOptionPane.showMessageDialog(this, expenses, "Expenses", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown action: " + actionCommand, "Error",
                        JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: creates a new tab with input fields and a "Done" button
    private void createInputTab(String actionCommand, String title) {
        // Create a new panel for the tab
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns for inputs
        inputPanel.setBackground(new Color(240, 240, 240));

        // Add input fields
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        JTextField dateField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField();

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);

        // Add a "Done" button
        JButton doneButton = new JButton("Done");
        doneButton.setFont(new Font("Serif", Font.BOLD, 14));
        doneButton.setBackground(new Color(0, 123, 255)); // Blue background
        doneButton.setForeground(Color.WHITE);
        doneButton.setFocusPainted(false);
        doneButton.addActionListener(e -> {
            String amountInput = amountField.getText();
            String dateInput = dateField.getText();
            String categoryInput = categoryField.getText();

            if (!amountInput.isEmpty() && !dateInput.isEmpty() && !categoryInput.isEmpty()) {
                handleInput(actionCommand, amountInput, dateInput, categoryInput, title);
                // Close the tab
                int index = tabbedPane.indexOfComponent(inputPanel);
                if (index != -1) {
                    tabbedPane.removeTabAt(index);
                }
            } else {
                JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        inputPanel.add(new JLabel()); // Empty cell for alignment
        inputPanel.add(doneButton);

        tabbedPane.addTab(title + " Input", inputPanel);
        tabbedPane.setSelectedComponent(inputPanel); // Switch to the new tab
    }

    // EFFECTS: processes the input and calls the appropriate BudgetApp method
    private void handleInput(String actionCommand, String amountInput, String dateInput, String categoryInput,
            String title) {
        try {
            double amount = Double.parseDouble(amountInput);
            switch (actionCommand) {
                case "AddExpense":
                    budgetApp.addExpense(amount, dateInput, categoryInput);
                    JOptionPane.showMessageDialog(this,
                            "Expense added: " + amount + " on " + dateInput + " in category " + categoryInput, title,
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "RemoveExpense":
                    budgetApp.removeExpense(amount, categoryInput);
                    JOptionPane.showMessageDialog(this,
                            "Expense removed: " + amount + " from category " + categoryInput, title,
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unknown action: " + actionCommand, "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}