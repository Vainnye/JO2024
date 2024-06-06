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

public class vuesEquipe extends JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultTableModel model;
    private int currentEquipeNumber ;
    
    public int getNextEquipeNumber() {
        return currentEquipeNumber++; // Retourne le numéro actuel et l'incrémente
    }
    
    public vuesEquipe(CardLayout cardLayout, JPanel mainPanel) {
    	
    	this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.currentEquipeNumber = 0; // Initialisation du numéro s'equipe à 2
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
        
        

        // Panel contenant les equipe
        JPanel equipePanel = new JPanel(new BorderLayout());
        equipePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Ajout de l'espace entre le bandeau et les athlètes
        
        //--------------------------------------------------------------------------
        // --------------Création du tableau ---------------------------------------
        //--------------------------------------------------------------------------
        
        String[] columnNames = {"Numero","Nom", "Genre", "Tranche d'âge", "Pays"};
        this.model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        equipePanel.add(scrollPane, BorderLayout.CENTER);
        

        //--------------------------------------------------------------------------
        // --------------Création du bouton Ajouter --------------------------------
        //--------------------------------------------------------------------------
        
        JButton addButton = new JButton("Ajouter Equipe");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Créer une fenêtre de dialogue pour saisir les informations de l'athlète
            	
            	
                JTextField nomEquipe = new JTextField(10);
                JTextField sexe = new JTextField(10);
                JTextField trancheAge = new JTextField(10);
                JTextField nbAthlete = new JTextField(10);
                JTextField listeAthlete = new JTextField(10);
                JTextField paysEquipe = new JTextField(10);
                JTextField disciplineEquipe = new JTextField(10);
                
                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
                
                inputPanel.add(new JLabel("nom equipe:"));
                inputPanel.add(nomEquipe);
                inputPanel.add(new JLabel("Sexe:"));
                inputPanel.add(sexe);
                inputPanel.add(new JLabel("Tranche d'age:"));
                inputPanel.add(trancheAge);
                inputPanel.add(new JLabel("nombre d'athletes:"));
                inputPanel.add(nbAthlete);
                inputPanel.add(new JLabel("listes des athletes:"));
                inputPanel.add(listeAthlete);
                inputPanel.add(new JLabel("Pays:"));
                inputPanel.add(paysEquipe);
                inputPanel.add(new JLabel("Discipline:"));
                inputPanel.add(disciplineEquipe);
                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                
                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Ajouter une equipe",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
                // Si l'utilisateur clique sur "OK", ajouter l'athlète à la table
                if (result == JOptionPane.OK_OPTION) {
                	
                	String nom = nomEquipe.getText();
                	String lesexe = sexe.getText();
                	String latrancheAge = trancheAge.getText();
                	String lenbAthlete = nbAthlete.getText();
                	String lalisteAthlete = listeAthlete.getText();
                	String lepaysEquipe = paysEquipe.getText();
                	String ladisciplineEquipe = disciplineEquipe.getText();
                    
                    // Ajouter les informations de Equipe à la table
                    model.addRow(new Object[]{getNextEquipeNumber(), nom, lesexe, latrancheAge, lenbAthlete, lalisteAthlete ,lepaysEquipe,ladisciplineEquipe});
                }
                
            }
        });

        equipePanel.add(addButton, BorderLayout.SOUTH);
        mainContentPanel.add(equipePanel, BorderLayout.CENTER);
        add(mainContentPanel, BorderLayout.CENTER);
        
        
        
        //--------------------------------------------------------------------------
        // --------------Controleur---------------- --------------------------------
        //--------------------------------------------------------------------------
        
        
        Pays france = new Pays("France", "FR");
        Pays usa = new Pays("USA", "US");

        Equipe equipeDeFrance = new Equipe("Equipe de France", "masculin", "18-40 ans", france, null);
        Equipe equipeUSA = new Equipe("Equipe USA", "feminin", "18-40 ans", usa, null);

        // Ajout des pays à la table
        ArrayList<Equipe> equipe1 = new ArrayList<>();
        equipe1.add(equipeDeFrance);
        equipe1.add(equipeUSA);
        
        Equipe[] equipes = {equipeDeFrance, equipeUSA};

        for (Equipe equipe : equipes) {
        	model.addRow(new Object[]{
            	equipe.getNumEquipe(),
                equipe.getNomEquipe(),
                equipe.getSexe(),
                equipe.getTrancheAge(),
                equipe.getPaysEquipe().getNomPays()
            });
        }
 
        
    }
}
