package com.mycompany.page_replacement;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Choose an Algorithm:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 15, 15));
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.add(createAlgorithmButton("FIFO", Color.CYAN, new FIFOPanel()));
        centerPanel.add(createAlgorithmButton("Optimal", Color.RED, new OptimalPanel()));
        centerPanel.add(createAlgorithmButton("LRU", Color.BLUE, new LRUPanel()));
    }

    private JButton createAlgorithmButton(String label, Color color, JPanel panel) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(e -> {
            JOptionPane.showOptionDialog(null,
                    panel,
                    label + " Algorithm",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new Object[]{},
                    null);
        });
        return button;
    }
}
