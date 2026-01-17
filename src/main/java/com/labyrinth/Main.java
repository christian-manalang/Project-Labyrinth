package com.labyrinth;

import javax.swing.SwingUtilities;
import com.labyrinth.labyrinth.ui.LoginFrame;
import javax.swing.JOptionPane;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            bootSystem();
        });
    }

    private static void bootSystem() {
        System.out.println("Booting Project Labyrinth...");

        // PRE-FLIGHT CHECK
        // Verify the Service Account Key (Unit A) exists before we even try to run
        File keyFile = new File("src/main/resources/serviceAccountKey.json");
        if (!keyFile.exists()) {
            showError(
                    "CRITICAL MISSING FILE:\nserviceAccountKey.json is missing from src/main/resources.\n\nUnit A: Please download it from Firebase Console.");
            return;
        }

        try {
            // INITIALIZE DATABASE (Unit A)
            // DatabaseService.initialize();
            System.out.println("Database Connection Simulated");

            // LAUNCH UI (Unit C)
            new LoginFrame().setVisible(true);

            JOptionPane.showMessageDialog(null, "Project Labyrinth is Online!\n\n(Login Screen Waiting for Unit C)");

        } catch (Exception e) {
            e.printStackTrace();
            showError("System Verification Failed: " + e.getMessage());
        }
    }

    private static void showError(String message) {
        System.err.println(message);
        JOptionPane.showMessageDialog(null, message, "Startup Error", JOptionPane.ERROR_MESSAGE);
    }
}