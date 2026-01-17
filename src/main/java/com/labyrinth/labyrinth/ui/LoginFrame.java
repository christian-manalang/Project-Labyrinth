package com.labyrinth.labyrinth.ui;

import com.labyrinth.labyrinth.logic.model.User;
import com.labyrinth.labyrinth.logic.service.AuthService;

import javax.swing.*;
import java.awt.*;

// Unit C replace this later.

public class LoginFrame extends JFrame {

    private AuthService authService = new AuthService();

    public LoginFrame() {
        setTitle("Project Labyrinth - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Labyrinth Access");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            User validUser = authService.login(user, pass);

            if (validUser != null) {
                JOptionPane.showMessageDialog(this, "Welcome, " + validUser.getRole());
                new DashboardFrame(validUser).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}