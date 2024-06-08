package vues;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class VuePlanning extends JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTable calendarTable;
    private DefaultTableModel model;

    public VuePlanning(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());

        // Création du bandeau supérieur
        JPanel bandeauContainer = new JPanel(new BorderLayout());
        bandeauContainer.setPreferredSize(new Dimension(300, 70));

        // Ajout du bandeau blanc au centre avec des marges
        JPanel bandeauPanel = new JPanel(new BorderLayout());
        bandeauPanel.setBackground(Color.WHITE);
        bandeauPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajout d'un espace vide autour du bandeau

        // Ajout de l'image à gauche du bandeau
        try {
            Image img = ImageIO.read(new File("./logoJO.png"));
            ImageIcon icon = new ImageIcon(img);
            Image scaledImage = icon.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imgLabel = new JLabel(scaledIcon);
            bandeauPanel.add(imgLabel, BorderLayout.WEST);
            imgLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });
        bandeauPanel.add(backButton, BorderLayout.EAST);
        backButton.setPreferredSize(new Dimension(80, 80));

        // Ajout du bandeau au centre du conteneur
        bandeauContainer.add(bandeauPanel, BorderLayout.CENTER);

        // Ajout du conteneur de bandeau au haut de la vue
        add(bandeauContainer, BorderLayout.NORTH);

        // Création du titre
        titleLabel = new JLabel("Planning des Épreuves à Venir");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.CENTER);

        // Création du tableau pour le calendrier
        String[] columnNames = {"Date", "Épreuve", "Équipe", "Pays", "Athlète"};
        model = new DefaultTableModel(columnNames, 0);
        calendarTable = new JTable(model);
        calendarTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(calendarTable);
        add(scrollPane, BorderLayout.CENTER);

        // Remplir le tableau avec des données factices pour illustration
        String[][] data = {
                {"2024-07-01", "100m Sprint", "Équipe France", "France", "Athlète 1"},
                {"2024-07-02", "Tir à l'arc", "Équipe USA", "USA", "Athlète 2"},
                {"2024-07-03", "Natation", "Équipe Japon", "Japon", "Athlète 3"}
        };
        for (String[] row : data) {
            model.addRow(row);
        }

        // Configurer la taille préférée de la vue
        setPreferredSize(new Dimension(800, 600));
    }
}
