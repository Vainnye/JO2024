package vues;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modeles.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class VuePays extends JPanel {
	
		 private CardLayout cardLayout;
		 private JPanel mainPanel;
		 private DefaultTableModel model;
		 private int currentPaysNumber ;
		 
		 public int getNextPaysNumber() {
		        return currentPaysNumber++; // Retourne le numéro actuel et l'incrémente
		 }
	    
	    public VuePays(CardLayout cardLayout, JPanel mainPanel) {
	    	this.cardLayout = cardLayout;
	        this.mainPanel = mainPanel;
	        this.currentPaysNumber = 0; // Initialisation du numéro des pays à 2
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
	        

	        // Panel principal avec espace entre le bandeau et le tableau des pays
	        JPanel mainContentPanel = new JPanel(new BorderLayout());
	        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20)); // Espace autour du panel principal
	        mainContentPanel.add(bandeauPanel, BorderLayout.NORTH);

	        // Panel contenant les pays
	        JPanel paysPanel = new JPanel(new BorderLayout());
	        paysPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Espace entre le bandeau et le tableau

	        //--------------------------------------------------------------------------
	        // --------------Création du tableau ---------------------------------------
	        //--------------------------------------------------------------------------
	        
	        String[] columnNames = {"Numéro pays","Nom", "Code"};
	        this.model = new DefaultTableModel(columnNames, 0);
	        
	        JTable table = new JTable(model);
	        table.setRowHeight(30);

	        JScrollPane scrollPane = new JScrollPane(table);
	        paysPanel.add(scrollPane, BorderLayout.CENTER);

	        //--------------------------------------------------------------------------
	        // --------------Création du bouton Ajouter --------------------------------
	        //--------------------------------------------------------------------------
	        
	        JButton addButton = new JButton("Ajouter Pays");
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	JTextField nompaysField = new JTextField(10);
	            	JTextField codepaysField = new JTextField(10);


	                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
	                inputPanel.add(new JLabel("Nom Pays : "));
	                inputPanel.add(nompaysField);
	                inputPanel.add(new JLabel("Code Pays : "));
	                inputPanel.add(codepaysField);

	                
	                
	                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Ajouter un pays",
	                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	                if (result == JOptionPane.OK_OPTION) {

	                    
	                    String nom = nompaysField.getText();
	                    String code = codepaysField.getText();


	                    model.addRow(new Object[]{getNextPaysNumber(), nom, code});
	                }
	            }
	        });

	        
	        paysPanel.add(addButton, BorderLayout.SOUTH);
	        

	        mainContentPanel.add(paysPanel, BorderLayout.CENTER);
	        add(mainContentPanel, BorderLayout.CENTER);

	        
	        //--------------------------------------------------------------------------
	        // --------------Controleur---------------- --------------------------------
	        //--------------------------------------------------------------------------
	        
	        Pays france = new Pays("France", "FR");
	        Pays usa = new Pays("USA", "US");

	        // Ajout des pays à la table
	        ArrayList<Pays> pays = new ArrayList<>();
	        pays.add(france);
	        pays.add(usa);


	        Pays[] pays1 = {france, usa};

	        for (Pays lespays : pays1) {
	            model.addRow(new Object[]{
	            	lespays.getNumPays(),
	            	lespays.getNomPays(),
	            	lespays.getCodePays()
	            });
	            

	        }
	    }

}

