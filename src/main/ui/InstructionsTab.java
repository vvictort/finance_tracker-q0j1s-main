package ui;

import javax.swing.*;
import java.awt.*;

public class InstructionsTab extends BaseTab {
    private JTabbedPane tabbedPane;

    // EFFECTS: constructs the instructions tab
    public InstructionsTab(JTabbedPane tabbedPane) {
        super();
        this.tabbedPane = tabbedPane;
        initializeComponents();
    }

    @Override
    protected void initializeComponents() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the tab

        // Add instructions area
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setLineWrap(true); // Enable word wrapping
        instructionsArea.setWrapStyleWord(true); // Wrap at word boundaries
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
                "  a -> Add expenses\n" +
                "  r -> Remove expenses\n" +
                "  p -> Print expenses\n" +
                "  o -> Add goals\n" +
                "  g -> Remove goals\n" +
                "  i -> Print goals\n" +
                "  s -> Save tracker to file\n" +
                "  l -> Load tracker from file\n\n" +
                "Click the button below to proceed to the actions tab.";
    }
}
