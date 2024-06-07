package vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;

public class MainView extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainView() {
    	//------------------------------------------------------
    	//-----------------Page d'acceuil(home)-----------------
    	//------------------------------------------------------
        setTitle("Jeux Olympiques 2024"); 				//Titre sur la fenetre
        setPreferredSize(new Dimension(600, 600));		//Taille de la fenetre

        cardLayout = new CardLayout();					//permet d'aller de fenetre en fenetre 
        mainPanel = new JPanel(cardLayout);
        JPanel homePanel = new JPanel(new BorderLayout()); //permet de diviser le panel en nord, sud, est, ouest et centre(en anglais pour les utiliser)
        JLabel label = new JLabel("Jeux Olympiques 2024", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24)); //police arial en gras de taille 24
        homePanel.add(label, BorderLayout.CENTER);		//place le JLabel au centre 

        JButton openButton = new JButton("Ouvrir");		//creation du bouton ouvrir
        openButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        openButton.addActionListener(new ActionListener() {	//lorsque l'on clique sur le bouton on va sur la fenetre menu
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "menu");
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));//placement des margine du bouton ouvri    
        buttonPanel.add(openButton); 
        homePanel.add(buttonPanel, BorderLayout.SOUTH); // placement du bouton ouvrir
        
        
        //------------------------------------------------------
    	//------------------bandeau(bandeauPanel)---------------
    	//------------------------------------------------------
        
        
        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 0, 10)); // Panneau du menu principal
        JPanel bandeauPanel = new JPanel(new BorderLayout());	    // Ajout d'un bandeau supérieur sur la page du menu
        bandeauPanel.setBackground(Color.WHITE);				    //couleur du background
        bandeauPanel.setPreferredSize(new Dimension(300, 50));      // Taille du bandeau
        
        																			
        
        // Ajout de l'image à gauche du bandeau le Logo
        try {
            Image img = ImageIO.read(new File("./logoJO.png")); 	//importer l'image du logo
            ImageIcon icon = new ImageIcon(img);
            Image scaledImage = icon.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH); // Réduire la taille de l'image
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel imgLabel = new JLabel(scaledIcon);
            bandeauPanel.add(imgLabel, BorderLayout.WEST); 			//placement de l'image dans le bandeau 
            imgLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0)); //border a gauche de l'image
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JButton Planning = new JButton("Planning");
        Planning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "planning");
            }
        });
        
        bandeauPanel.add(Planning, BorderLayout.EAST);
        Planning.setPreferredSize(new Dimension(80, 90));
        Planning.setPreferredSize(new Dimension(Planning.getPreferredSize().width + 20, 50));
        
        //------------------------------------------------------
    	//------------------page de menu(menu)------------------
    	//------------------------------------------------------
        
        menuPanel.add(bandeauPanel); //met le bandeau dans le menu
        menuPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); //margine des boutons
        String[] options = {"Athlètes", "Équipes", "Pays", "Disciplines", "Épreuves", "Résultats"}; //liste des boutons
        for (String option : options) {			//permet d'acceder au vues
            JButton button = new JButton(option);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    openSelectedView(option);
                }
            });
            menuPanel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(menuPanel); //permet d'aller de page en page 
        
        //------------------------------------------------------
    	//-----------------------mainPanel----------------------
    	//------------------------------------------------------
        
        // Ajout des panneaux à mainPanel
        mainPanel.add(homePanel, "home");
        mainPanel.add(scrollPane, "menu");

        // Ajout des autres vues
        mainPanel.add(new vuesAthlete(cardLayout, mainPanel), "athletes");
        mainPanel.add(new vuesEquipe(cardLayout, mainPanel), "equipes");
        mainPanel.add(new vuesPays(cardLayout, mainPanel), "pays");
        mainPanel.add(new vuesDiscipline(cardLayout, mainPanel), "disciplines");
        mainPanel.add(new vuesEpreuve(cardLayout, mainPanel), "epreuves");
        mainPanel.add(new vuesResultat(cardLayout, mainPanel), "resultats");
        mainPanel.add(new vuesPlanning(cardLayout, mainPanel), "planning");
        
        add(mainPanel);
        pack();
        cardLayout.show(mainPanel, "home"); // Afficher la page d'accueil au démarrage
    }

    private void openSelectedView(String option) { //Ouvre les differente vues
        switch (option) {
            case "Athlètes":
                cardLayout.show(mainPanel, "athletes");
                break;
            case "Équipes":
                cardLayout.show(mainPanel, "equipes");
                break;
            case "Pays":
                cardLayout.show(mainPanel, "pays");
                break;
            case "Disciplines":
                cardLayout.show(mainPanel, "disciplines");
                break;
            case "Épreuves":
                cardLayout.show(mainPanel, "epreuves");
                break;
            case "Résultats":
                cardLayout.show(mainPanel, "resultats");
                break;
            case "Planning":
                cardLayout.show(mainPanel, "planning");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainView mainView = new MainView();
                mainView.setVisible(true);
            }
        });
    }
}
