package ui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import user.BudgetApp;

public class ButtonsTab extends BaseTab {
    private BudgetApp budgetApp;
    private ActionListener actionListener;
    private JTabbedPane tabbedPane;

    // EFFECTS: constructor
    public ButtonsTab(BudgetApp budgetApp, JTabbedPane tabbedPane) {
        super();
        this.budgetApp = budgetApp;
        this.tabbedPane = tabbedPane;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        // This method is no longer needed
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // some padding

        // Add sections
        add(new ExpenseManagementTab(budgetApp, tabbedPane));
        add(Box.createRigidArea(new Dimension(0, 10))); // spacing between sections
        add(new GoalManagementTab(budgetApp, tabbedPane));
        add(Box.createRigidArea(new Dimension(0, 10))); // spacing between sections
        add(new SaveLoadTab(budgetApp));
    }
}
