package com.mycompany.page_replacement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptimalPanel extends JPanel {
    private JTextField nField;
    private JTextField mField;
    private JTextField inputField;
    private JButton simulateButton;

    public OptimalPanel() {
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15, 15, 15, 15);
        constraints.anchor = GridBagConstraints.WEST;

        // Number of pages
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Enter number of pages:"), constraints);

        nField = new JTextField(10);
        constraints.gridx = 1;
        add(nField, constraints);

        // Number of frames
        constraints.gridy++;
        constraints.gridx = 0;
        add(new JLabel("Enter number of frames:"), constraints);

        mField = new JTextField(10);
        constraints.gridx = 1;
        add(mField, constraints);

        // Page reference string
        constraints.gridy++;
        constraints.gridx = 0;
        add(new JLabel("Enter the page reference string:"), constraints);

        inputField = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        add(inputField, constraints);

        // Simulate button
        constraints.gridy++;
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        simulateButton = new JButton("Simulate Optimal");
        add(simulateButton, constraints);

        // Add action listener for the simulate button
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(nField.getText());
                    int m = Integer.parseInt(mField.getText());
                    String input = inputField.getText();

                    OptimalSimulation simulation = new OptimalSimulation(n, m, input);
                    simulation.simulate();

                    JOptionPane.showMessageDialog(null,
                            simulation.getResults(),
                            "Simulation Result of Optimal",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid numbers for pages and frames.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
