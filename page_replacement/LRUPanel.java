package com.mycompany.page_replacement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LRUPanel extends JPanel {
    private JTextField nField;
    private JTextField mField;
    private JTextField inputField;
    private JButton simulateButton;

    public LRUPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(new JLabel("Number of Pages:"), constraints);

        nField = new JTextField(10);
        constraints.gridx = 1;
        inputPanel.add(nField, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        inputPanel.add(new JLabel("Number of Frames:"), constraints);

        mField = new JTextField(10);
        constraints.gridx = 1;
        inputPanel.add(mField, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        inputPanel.add(new JLabel("Page Reference String:"), constraints);

        inputField = new JTextField(30);
        constraints.gridx = 1;
        inputPanel.add(inputField, constraints);

        constraints.gridy++;
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        simulateButton = new JButton("Simulate LRU");
        inputPanel.add(simulateButton, constraints);

        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(nField.getText());
                    int m = Integer.parseInt(mField.getText());
                    String input = inputField.getText();

                    LRUSimulation simulation = new LRUSimulation(n, m, input);
                    simulation.simulate();

                    JOptionPane.showMessageDialog(null,
                            simulation.getResults(),
                            "Simulation Result of LRU",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid numbers for pages and frames.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(inputPanel, BorderLayout.CENTER);
    }
}
