package ui;

import javax.swing.*;
import java.awt.*;

public class InstructionsTab extends BaseTab {
    private JTabbedPane tabbedPane;

    // EFFECTS: constructor
    public InstructionsTab(JTabbedPane tabbedPane) {
        super();
        this.tabbedPane = tabbedPane;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add instructions area
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setText(getInstructionsText());
        instructionsArea.setFont(new Font("Serif", Font.PLAIN, 14));
        instructionsArea.setBackground(new Color(255, 255, 255)); // Set background color
        instructionsArea.setMargin(new Insets(10, 10, 10, 10)); // Padding
        add(new JScrollPane(instructionsArea), BorderLayout.CENTER);

        // Add a button to switch to the actions tab
        JButton nextButton = new JButton("Go to Actions");
        nextButton.setFont(new Font("Serif", Font.BOLD, 14));
        nextButton.setBackground(new Color(0, 123, 255)); // Blue background
        nextButton.setForeground(Color.WHITE); // White text
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> {
            tabbedPane.setEnabledAt(1, true); // Enable the second tab
            tabbedPane.setSelectedIndex(1); // Switch to the second tab
        });
        add(nextButton, BorderLayout.SOUTH);
    }

    // EFFECTS: returns the instructions text
    private String getInstructionsText() {
        return "Welcome to the Budget App!\n\n" +
                "Select from the following options:\n" +
                "  \ta -> Add expenses\n" +
                "  \tr -> Remove expenses\n" +
                "  \tp -> Print expenses\n" +
                "  \to -> Add goals\n" +
                "  \tg -> Remove goals\n" +
                "  \ti -> Print goals\n" +
                "  \ts -> Save tracker to file\n" +
                "  \tl -> Load tracker from file\n\n" +
                "Click the button below to proceed to the actions tab.";
    }
}
