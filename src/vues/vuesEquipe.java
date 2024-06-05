package vues;

import javax.swing.*;
import java.awt.*;

public class vuesEquipe extends JFrame {

    public vuesEquipe() {
        setTitle("Liste des Équipes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("Liste des Équipes...\n");

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Exemple de données - Vous pouvez remplacer ceci par les données réelles de votre modèle
        String equipes = "Equipe de France\nEquipe du Portugal\n";
        textArea.setText(equipes);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vuesEquipe vuesequipe = new vuesEquipe();
                vuesequipe.setVisible(true);
            }
        });
    }
}
