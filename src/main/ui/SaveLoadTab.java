package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import user.BudgetApp;

public class SaveLoadTab extends BaseTab {
    private BudgetApp budgetApp;

    // EFFECTS: constructs the Save/Load tab
    public SaveLoadTab(BudgetApp budgetApp) {
        super();
        this.budgetApp = budgetApp;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        setLayout(new GridLayout(2, 1, 10, 10)); // 2 rows, 1 column, with spacing
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light gray border
                "Save/Load", TitledBorder.LEFT, TitledBorder.TOP, // Title alignment
                new Font("Serif", Font.BOLD, 14), new Color(0, 123, 255) // Title font and color
        ));

        // Add buttons
        add(createButton("Save tracker to file", "Save"));
        add(createButton("Load tracker from file", "Load"));
    }

    // EFFECTS: creates a button with the given text and action command
    private JButton createButton(String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setFont(new Font("Serif", Font.BOLD, 12));
        button.setBackground(new Color(0, 123, 255)); // Blue background
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding
        button.addActionListener(e -> handleButtonAction(actionCommand)); // Handle button actions
        return button;
    }

    // EFFECTS: handles button actions for saving and loading
    private void handleButtonAction(String actionCommand) {
        if (actionCommand.equals("Save")) {
            try {
                budgetApp.saveTracker();
                JOptionPane.showMessageDialog(this, "Tracker saved successfully!", "Save",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Failed to save tracker: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (actionCommand.equals("Load")) {
            try {
                budgetApp.loadTracker();
                JOptionPane.showMessageDialog(this, "Tracker loaded successfully!", "Load",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Failed to load tracker: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
