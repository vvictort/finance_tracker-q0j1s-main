package ui;

import user.BudgetApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetAppFrame extends JFrame implements ActionListener {
    private BudgetApp budgetApp;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructs the main JFrame for the Budget App
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
        ButtonsTab buttonsTab = new ButtonsTab(this, tabbedPane);
        tabbedPane.addTab("Actions", buttonsTab);

        // Initially disable the second tab
        tabbedPane.setEnabledAt(1, false);

        // Add the tabbed pane to the frame
        add(tabbedPane);

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Add Expense":
                budgetApp.addExpense();
                break;
            case "Remove Expense":
                budgetApp.removeExpense();
                break;
            case "Print Expense":
                budgetApp.printExpense();
                break;
            case "Add Goal":
                budgetApp.addGoal();
                break;
            case "Remove Goal":
                budgetApp.removeGoal();
                break;
            case "Print Goal":
                budgetApp.printGoal();
                break;
            case "Save":
                budgetApp.saveTracker();
                break;
            case "Load":
                budgetApp.loadTracker();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Unknown action: " + command);
        }
    }

    // EFFECTS: starts the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BudgetAppFrame::new);
    }
}