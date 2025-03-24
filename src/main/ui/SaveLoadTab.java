package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionListener;

public class SaveLoadTab extends BaseTab {
    private ActionListener actionListener;

    // EFFECTS: constructs the Save/Load tab
    public SaveLoadTab(ActionListener actionListener) {
        super();
        this.actionListener = actionListener;
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
        add(createButton("Save tracker to file", "s"));
        add(createButton("Load tracker from file", "l"));
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
        button.addActionListener(actionListener); // Delegate action to the provided ActionListener
        return button;
    }
}
