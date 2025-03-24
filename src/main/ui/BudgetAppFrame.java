package ui;

import user.BudgetApp;

import javax.swing.*;

public class BudgetAppFrame extends JFrame {
    private BudgetApp budgetApp;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructor
    public BudgetAppFrame() {
        super("Budget App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null); // Center the JFrame on the screen

        // Initialize BudgetApp logic
        budgetApp = new BudgetApp();

        // Create a tabbed pane
        tabbedPane = new JTabbedPane();

        // Add the first tab (Instructions)
        tabbedPane.addTab("Instructions", new InstructionsTab(tabbedPane));

        // Add the second tab (Buttons)
        ButtonsTab buttonsTab = new ButtonsTab(budgetApp, tabbedPane);
        tabbedPane.addTab("Actions", buttonsTab);

        // Initially disable the second tab
        tabbedPane.setEnabledAt(1, false);

        // Add the tabbed pane to the frame
        add(tabbedPane);

        setVisible(true);
    }

    // EFFECTS: starts the application (for testing)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetAppFrame::new);
    }
}