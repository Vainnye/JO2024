package vues;

import javax.swing.*;
import java.awt.*;

public class vuesPays extends JFrame {

    public vuesPays() {
        setTitle("Liste des Pays");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("Liste des Pays...\n");

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Exemple de données - Vous pouvez remplacer ceci par les données réelles de votre modèle
        String pays = "France\nEspagne\nItalie\nPortugal\n";
        textArea.setText(pays);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vuesPays vuespays = new vuesPays();
                vuespays.setVisible(true);
            }
        });
    }
}
