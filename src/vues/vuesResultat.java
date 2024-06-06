package vues;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import modeles.*;
import java.util.ArrayList;


public class vuesResultat extends JPanel {

    private DefaultTableModel model;
   
    
    public vuesResultat(CardLayout cardLayout, JPanel mainPanel) {
    	setLayout(new BorderLayout());

    	//--------------------------------------------------------------------------
        // --------------Création du bandeau supérieur------------------------------
        //--------------------------------------------------------------------------
    	
        JPanel bandeauPanel = new JPanel(new BorderLayout());
        bandeauPanel.setBackground(Color.WHITE);
        bandeauPanel.setPreferredSize(new Dimension(300, 70));

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

        //--------------------------------------------------------------------------
        // --------------Création du bouton retour(menu)----------------------------
        //--------------------------------------------------------------------------
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });
        bandeauPanel.add(backButton, BorderLayout.EAST);
        backButton.setPreferredSize(new Dimension(80, 80));
        

        // Panel principal avec espace entre le bandeau et le tableau des athlètes
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20)); // Espace autour du panel principal
        mainContentPanel.add(bandeauPanel, BorderLayout.NORTH);

        // Panel contenant les athlètes
        JPanel ResultatPanel = new JPanel(new BorderLayout());
        ResultatPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Espace entre le bandeau et le tableau

        //--------------------------------------------------------------------------
        // --------------Création du tableau ---------------------------------------
        //--------------------------------------------------------------------------
        
        String[] columnNames = {"Épreuve", "Premier", "Deuxième", "Troisième"};
        this.model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        ResultatPanel.add(scrollPane, BorderLayout.CENTER);

        mainContentPanel.add(ResultatPanel, BorderLayout.CENTER);
        add(mainContentPanel, BorderLayout.CENTER);

        //--------------------------------------------------------------------------
        // --------------Controleur---------------- --------------------------------
        //--------------------------------------------------------------------------
        
        Discipline football = new Discipline("Football");
        Pays france = new Pays("France", "FR");
        Equipe equipe1 = new Equipe("Equipe A", "Mixte", "Adulte", france, football);
        Equipe equipe2 = new Equipe("Equipe B", "Masculin", "Junior", france, football);
        Equipe equipe3 = new Equipe("Equipe C", "Féminin", "Senior", france, football);
        
        Equipe[] equipes = {equipe1, equipe2, equipe3};
        Equipe[] gagnants = {equipe1, equipe2, equipe3};
        
        Epreuve epreuve1 = new Epreuve("2024-07-26", "10:00", "12:00", 2.0f, football, equipes, gagnants);
        
        //Resultat resultat1 = new Resultat(a, listeResultat);
        Resultat resultat1 = epreuve1.getResults();
        
        // Ajout des résultats à la table
        ArrayList<Resultat> resultats = new ArrayList<>();
        resultats.add(resultat1);

        for (Resultat resultat : resultats) {
            model.addRow(new Object[]{
                resultat.getNumEpreuve(),
                resultat.getPremier().getNomEquipe(),
                resultat.getDeuxieme().getNomEquipe(),
                resultat.getTroisieme().getNomEquipe()
            });
        }
     
    }
}
