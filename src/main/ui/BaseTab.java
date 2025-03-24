package ui;

import javax.swing.*;
import java.awt.*;

public abstract class BaseTab extends JPanel {

    // EFFECTS: constructor
    public BaseTab() {
        setBackground(new Color(240, 240, 240)); // Light gray background
    }

    protected abstract void initializeComponents();

}
