package com.labyrinth.labyrinth.ui;

import javax.swing.*;

import com.labyrinth.labyrinth.logic.model.User;

import java.awt.*;

// Unit C replace this later.

public class DashboardFrame extends JFrame {

    public DashboardFrame(User user) {
        setTitle("Project Labyrinth - Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel header = new JPanel();
        header.setBackground(new Color(50, 50, 50));
        JLabel title = new JLabel("Welcome " + user.getUsername() + " (" + user.getRole() + ")");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        header.add(title);
        add(header, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 20, 20));

        JButton btnAcquisitions = new JButton("Manage Acquisitions");
        JButton btnReports = new JButton("Generate Reports");

        if (user.isAdmin()) {
            JButton btnGapAnalysis = new JButton("Gap Analysis (Admin Only)");
            btnGapAnalysis.setBackground(Color.PINK);
            panel.add(btnGapAnalysis);
        } else {
            panel.add(new JLabel("Gap Analysis Locked", SwingConstants.CENTER));
        }

        panel.add(btnAcquisitions);
        panel.add(btnReports);

        add(panel, BorderLayout.CENTER);
    }
}