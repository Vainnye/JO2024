package vues;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeles.*;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class vuesEpreuve extends JPanel {

	 private CardLayout cardLayout;
	 private JPanel mainPanel;
	 private DefaultTableModel model;
	 private int currentEpreuveNumber ;
	 
	 public int getNextEpreuveNumber() {
	        return currentEpreuveNumber++; // Retourne le numéro actuel et l'incrémente
	 }
    
    public vuesEpreuve(CardLayout cardLayout, JPanel mainPanel) {
    	this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.currentEpreuveNumber = 1; // Initialisation du numéro d'athlète à 1
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
        

        // Panel principal avec espace entre le bandeau et le tableau des Epreuve
        JPanel mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20)); // Espace autour du panel principal
        mainContentPanel.add(bandeauPanel, BorderLayout.NORTH);

        // Panel contenant les Epreuve
        JPanel epreuvePanel = new JPanel(new BorderLayout());
        epreuvePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Espace entre le bandeau et le tableau

        
        //--------------------------------------------------------------------------
        // --------------Création du tableau ---------------------------------------
        //--------------------------------------------------------------------------
        
        String[] columnNames = {"Numéro Épreuve", "Date", "Heure Début", "Heure Fin", "Durée", "Discipline"};
        this.model = new DefaultTableModel(columnNames, 0);
        
        JTable table = new JTable(model);
        table.setRowHeight(30);


        JScrollPane scrollPane = new JScrollPane(table);
        epreuvePanel.add(scrollPane, BorderLayout.CENTER);

        //--------------------------------------------------------------------------
        // --------------Création du bouton Ajouter --------------------------------
        //--------------------------------------------------------------------------
        
        JButton addButton = new JButton("Ajouter Epreuve");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            	JTextField dateEpreuveField = new JTextField(10);
            	JTextField heureDebutField = new JTextField(10);
            	JTextField heureFinField = new JTextField(10);
            	JTextField dureeHeureField = new JTextField(10);
            	JTextField disciplineEpreuveField = new JTextField(10);
            	JTextField listeEquipeField = new JTextField(10);
            	JTextField troisEquipeGagnanteField = new JTextField(10);
            	JTextField resultsField = new JTextField(10);
            	

                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
                inputPanel.add(new JLabel("Date épreuve:"));
                inputPanel.add(dateEpreuveField);
                inputPanel.add(new JLabel("heureDebut:"));
                inputPanel.add(heureDebutField);
                inputPanel.add(new JLabel("heureFin:"));
                inputPanel.add(heureFinField);
                inputPanel.add(new JLabel("dureeHeure:"));
                inputPanel.add(dureeHeureField);
                inputPanel.add(new JLabel("disciplineEpreuve:"));
                inputPanel.add(disciplineEpreuveField);
                inputPanel.add(new JLabel("listeEquipe:"));
                inputPanel.add(listeEquipeField);
                inputPanel.add(new JLabel("troisEquipeGagnante:"));
                inputPanel.add(troisEquipeGagnanteField);
                inputPanel.add(new JLabel("results:"));
                inputPanel.add(resultsField);
                
                
                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Ajouter une session",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {

                    
                    String dateEpreuve = dateEpreuveField.getText();
                    String heureDebut = heureDebutField.getText();
                    String heureFin = heureFinField.getText();
                    String dureeHeure = dureeHeureField.getText();
                    String disciplineEpreuve = disciplineEpreuveField.getText();
                    String listeEquipe = listeEquipeField.getText();
                    String troisEquipeGagnante = troisEquipeGagnanteField.getText();
                    String results = resultsField.getText();

                    model.addRow(new Object[]{getNextEpreuveNumber(), dateEpreuve, heureDebut, heureFin, dureeHeure, disciplineEpreuve ,listeEquipe,troisEquipeGagnante,results});
                }
            }
        });

        
        epreuvePanel.add(addButton, BorderLayout.SOUTH);
        

        mainContentPanel.add(epreuvePanel, BorderLayout.CENTER);
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
        
        
        // Ajout des pays à la table
        ArrayList<Epreuve> epreuvex = new ArrayList<>();
        epreuvex.add(epreuve1);
        
        
        
        // Ajout des épreuves à la table
        Epreuve[] epreuves = {epreuve1};

        for (Epreuve epreuve : epreuves) {
            model.addRow(new Object[]{
                epreuve.getNmuEpreuve(),
                epreuve.getDateEpreuve(),
                epreuve.getheureDebut(),
                epreuve.getDateFin(),
                epreuve.getDureeHeure(),
                epreuve.getDisciplineEpreuve().getNomDiscipline()
            });
        }
    }
    
}
