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

public class VueAthlete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultTableModel model;
    private int currentAthleteNumber ;
    
    public int getNextAthleteNumber() {
        return currentAthleteNumber++; // Retourne le numéro actuel et l'incrémente
    }

    public VueAthlete(CardLayout cardLayout, JPanel mainPanel) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.currentAthleteNumber = 2; // Initialisation du numéro d'athlète à 2
        setLayout(new BorderLayout());

        //--------------------------------------------------------------------------
        // --------------Création du bandeau supérieur------------------------------
        //--------------------------------------------------------------------------
        
        JPanel bandeauPanel = new JPanel(new BorderLayout());
        bandeauPanel.setBackground(Color.WHITE);
        bandeauPanel.setPreferredSize(new Dimension(300, 70));

        // Ajout de l'image à gauche du bandeau LOGO
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
        JPanel athletesPanel = new JPanel(new BorderLayout());
        athletesPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Espace entre le bandeau et le tableau

        //--------------------------------------------------------------------------
        // --------------Création du tableau ---------------------------------------
        //--------------------------------------------------------------------------
        
        String[] columnNames = {"Numéro", "Prénom", "Nom", "Date de naissance", "Equipe", "Pays"};
        this.model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        athletesPanel.add(scrollPane, BorderLayout.CENTER);

        //--------------------------------------------------------------------------
        // --------------Création du bouton Ajouter --------------------------------
        //--------------------------------------------------------------------------
        
        JButton addButton = new JButton("Ajouter Athlète");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField prenomField = new JTextField(10);
                JTextField nomField = new JTextField(10);
                JTextField dateNaissanceField = new JTextField(10);
                JTextField equipeField = new JTextField(10);
                JTextField paysField = new JTextField(10);

                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
                inputPanel.add(new JLabel("Prénom:"));
                inputPanel.add(prenomField);
                inputPanel.add(new JLabel("Nom:"));
                inputPanel.add(nomField);
                inputPanel.add(new JLabel("Date de naissance:"));
                inputPanel.add(dateNaissanceField);
                inputPanel.add(new JLabel("Equipe:"));
                inputPanel.add(equipeField);
                inputPanel.add(new JLabel("Pays:"));
                inputPanel.add(paysField);
                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Ajouter un Athlète",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    String prenom = prenomField.getText();
                    String nom = nomField.getText();
                    String dateNaissance = dateNaissanceField.getText();
                    String equipe = equipeField.getText();
                    String pays = paysField.getText();

                    model.addRow(new Object[]{getNextAthleteNumber(), prenom, nom, dateNaissance, equipe, pays});
                }
            }
        });

        
        athletesPanel.add(addButton, BorderLayout.SOUTH); //emplecement du bouton ajouter
        

        mainContentPanel.add(athletesPanel, BorderLayout.CENTER);
        add(mainContentPanel, BorderLayout.CENTER);

        
        //--------------------------------------------------------------------------
        // --------------Controleur---------------- --------------------------------
        //--------------------------------------------------------------------------
        
        
        Pays france = new Pays("France", "FR");
        Pays usa = new Pays("USA", "US");
        Equipe equipeDeFrance = new Equipe("Equipe de France", "masculin", "18-40 ans", france, null);
        Equipe equipeUSA = new Equipe("Equipe USA", "feminin", "18-40 ans", usa, null);

        Athlete mbappe = new Athlete("Kylian", "Mbappe", "1998-10-10", equipeDeFrance, france);
        Athlete james = new Athlete("LeBron", "James", "1984-12-30", equipeUSA, usa);

        
        // Ajout des pays à la table
        ArrayList<Athlete> athlete1 = new ArrayList<>();
        athlete1.add(mbappe);
        athlete1.add(james);
        
        
        Athlete[] athletes = {mbappe, james};

        for (Athlete athlete : athletes) {
            model.addRow(new Object[]{
                athlete.getNumAthlete(),
                athlete.getPrenomAthlete(),
                athlete.getNomAthlete(),
                athlete.getDateDeNaissance(),
                athlete.getEquipeAthlete() != null ? athlete.getEquipeAthlete().getNomEquipe() : "N/A",
                athlete.getPaysAthlete().getNomPays()
            });
        }
    }

    
}