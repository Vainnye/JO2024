package vues;

import javax.swing.*;
import java.awt.*;

public class vuesResultat extends JFrame {

    public vuesResultat() {
        setTitle("Liste des Résultats");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("Liste des Résultats...\n");

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Exemple de données - Vous pouvez remplacer ceci par les données réelles de votre modèle
        String resultats = "Epreuve 1: 1er - France, 2ème - Portugal\n";
        textArea.setText(resultats);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vuesResultat vuesresultat = new vuesResultat();
                vuesresultat.setVisible(true);
            }
        });
    }
}
