package vues;

import javax.swing.*;
import java.awt.*;

public class vuesEpreuve extends JFrame {

    public vuesEpreuve() {
        setTitle("Liste des Épreuves");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("Liste des Épreuves...\n");

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Exemple de données - Vous pouvez remplacer ceci par les données réelles de votre modèle
        String epreuves = "Epreuve 1: Football - 12/07/2024 14h-16h\n";
        textArea.setText(epreuves);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vuesEpreuve vuesepreuve = new vuesEpreuve();
                vuesepreuve.setVisible(true);
            }
        });
    }
}
