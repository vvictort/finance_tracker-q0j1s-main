package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;

public class ButtonsTab extends BaseTab {
    private ActionListener actionListener;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructs the buttons tab
    public ButtonsTab(ActionListener actionListener, JTabbedPane tabbedPane) {
        super();
        this.actionListener = actionListener;
        this.tabbedPane = tabbedPane;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the tab

        // Add sections
        add(new ExpenseManagementTab(actionListener, tabbedPane));
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between sections
        add(new GoalManagementTab(actionListener, tabbedPane));
        add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between sections
        add(new SaveLoadTab(actionListener));
    }

    @Override
    protected void initializeComponents() {
        // This method is no longer needed
    }

    // EFFECTS: creates a section of buttons with a title
    private JPanel createButtonSection(String title, String[] buttonLabels, String[] actionCommands) {
        System.out.println("Creating section: " + title); // Debugging output

        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new GridLayout(buttonLabels.length, 1, 5, 5)); // Equal-sized buttons in a single column
        sectionPanel.setBackground(new Color(255, 255, 255)); // White background
        sectionPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)), // Light gray border
                title, TitledBorder.LEFT, TitledBorder.TOP, // Title alignment
                new Font("Serif", Font.BOLD, 14), new Color(0, 123, 255) // Title font and color
        ));

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createButton(buttonLabels[i], actionCommands[i]);
            sectionPanel.add(button);
        }

        return sectionPanel;
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
