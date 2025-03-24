package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageFrame extends JFrame implements ActionListener {
    private JLabel label;
    private JButton button;

    // EFFECTS: constructor
    public MainPageFrame() {
        super("Budget App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("lib/panda.png").getImage()); // the top-left icon
        setSize(400, 500);
        setLocationRelativeTo(null); // Centers the JFrame on the screen

        // Create a JPanel and set its layout to BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical alignment
        panel.setBackground(new Color(173, 216, 230)); // Light blue background

        // Add a welcome message
        label = new JLabel("Welcome to the Budget App!");
        label.setFont(new Font("Serif", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        // Add a logo
        ImageIcon originalIcon = new ImageIcon("lib/panda.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Resize to
                                                                                                     // 100x100
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel logo = new JLabel(scaledIcon);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logo);

        // Add spacing
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add a button
        button = new JButton("Get Started!");
        button.setFont(new Font("Serif", Font.BOLD, 16));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        panel.add(button);

        // Add a footer
        JLabel footer = new JLabel("© 2025 Budget App. All rights reserved.", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 12));
        footer.setForeground(Color.GRAY);
        add(footer, BorderLayout.SOUTH);

        // Add the panel to the JFrame
        add(panel);

        setVisible(true);
    }

    // MODIFIES: this
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        new BudgetAppFrame();
    }

    // EFFECTS: starts the application (for testing purposes)
    public static void main(String[] args) {
        // new AuthenticateUser();
        new MainPageFrame();
    }
}
