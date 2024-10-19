package com.mycompany.page_replacement;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Virtual Memory Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setJMenuBar(createMenuBar());

        frame.getContentPane().add(new HomePanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu aboutMenu = new JMenu("About");
        aboutMenu.add(new AboutItem());
        menuBar.add(aboutMenu);

        return menuBar;
    }

    private static class AboutItem extends JMenuItem {
        public AboutItem() {
            super("About Project");
            setToolTipText("About this project");
            addActionListener(e -> {
                JOptionPane.showMessageDialog(null,
                        "This is our Operating system course project. Here we are\n trying to "
                                + "build a android app which can simulate three renowned page replacement\n"
                                + "algorithms like FIFO, Optimal, and LRU.\n\n"
                                + "Contributors:\n"
                                + "Md Esfer Abdus Sami\n"
                                + "Md Younus Nobi Shohan\n"
                                + "Sanowar Jahan Tasnim",
                        "About Project",
                        JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }
}
