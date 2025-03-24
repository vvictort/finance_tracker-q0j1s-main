package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GoalManagementTab extends BaseTab {
    private ActionListener actionListener;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructs the Goal Management tab
    public GoalManagementTab(ActionListener actionListener, JTabbedPane tabbedPane) {
        super();
        this.actionListener = actionListener;
        this.tabbedPane = tabbedPane;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with spacing
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light gray border
                "Goal Management", TitledBorder.LEFT, TitledBorder.TOP, // Title alignment
                new Font("Serif", Font.BOLD, 14), new Color(0, 123, 255) // Title font and color
        ));

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
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding
        button.addActionListener(e -> createInputTab(actionCommand, text)); // Create a new tab on button press
        return button;
    }

    // EFFECTS: creates a new tab with an input field and a "Done" button
    private void createInputTab(String actionCommand, String title) {
        // Create a new panel for the tab
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(new Color(240, 240, 240)); // Light gray background

        // Add a label to describe the action
        JLabel actionLabel = new JLabel("Enter input for: " + title);
        actionLabel.setFont(new Font("Serif", Font.BOLD, 14));
        actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputPanel.add(actionLabel, BorderLayout.NORTH);

        // Add an input field
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Serif", Font.PLAIN, 14));
        inputField.setMargin(new Insets(5, 5, 5, 5)); // Add padding
        inputPanel.add(inputField, BorderLayout.CENTER);

        // Add a "Done" button
        JButton doneButton = new JButton("Done");
        doneButton.setFont(new Font("Serif", Font.BOLD, 14));
        doneButton.setBackground(new Color(0, 123, 255)); // Blue background
        doneButton.setForeground(Color.WHITE); // White text
        doneButton.setFocusPainted(false);
        doneButton.addActionListener(e -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Input submitted for " + title + ": " + input);
                // Close the tab
                int index = tabbedPane.indexOfComponent(inputPanel);
                if (index != -1) {
                    tabbedPane.removeTabAt(index);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Input cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        inputPanel.add(doneButton, BorderLayout.SOUTH);

        // Add the new tab to the parent tabbed pane
        tabbedPane.addTab(title + " Input", inputPanel);
        tabbedPane.setSelectedComponent(inputPanel); // Switch to the new tab
    }
}
