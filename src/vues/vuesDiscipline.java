package vues;

import javax.swing.*;
import java.awt.*;

public class vuesDiscipline extends JFrame {

    public vuesDiscipline() {
        setTitle("Liste des Disciplines");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("Liste des Disciplines...\n");

        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // Exemple de données - Vous pouvez remplacer ceci par les données réelles de votre modèle
        String disciplines = "Football\nBasketball\nHandball\n";
        textArea.setText(disciplines);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vuesDiscipline vuesdiscipline = new vuesDiscipline();
                vuesdiscipline.setVisible(true);
            }
        });
    }
}
