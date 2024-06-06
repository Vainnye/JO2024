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

	public class vuesDiscipline extends JPanel {

		//----------------------------------------------
		//  Déclaration des éléments de l'interface
		//----------------------------------------------
		private CardLayout cardLayout;
		private JPanel mainPanel;		
		private DefaultTableModel model;
		private JButton backButton;
		private JButton addButton;
		
		private int currentDisciplineNumber ;
	 
		
		
		public int getNextDisciplineNumber() {
			return currentDisciplineNumber++; // Retourne le numéro actuel et l'incrémente
		}
	    
	    public vuesDiscipline(CardLayout cardLayout, JPanel mainPanel) {
	    	this.cardLayout = cardLayout;
	        this.mainPanel = mainPanel;
	        this.currentDisciplineNumber = 0; // Initialisation du numéro Discipline à 1
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
	        backButton = new JButton("Retour");
	        backButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(mainPanel, "menu");
	            }
	        });
	        bandeauPanel.add(backButton, BorderLayout.EAST);
	        backButton.setPreferredSize(new Dimension(80, 80));
	        

	        // Panel principal avec espace entre le bandeau et le tableau des Discipline
	        JPanel mainContentPanel = new JPanel(new BorderLayout());
	        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20)); // Espace autour du panel principal
	        mainContentPanel.add(bandeauPanel, BorderLayout.NORTH);

	        // Panel contenant les Discipline
	        JPanel disciplinePanel = new JPanel(new BorderLayout());
	        disciplinePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Espace entre le bandeau et le tableau

	        
	        
	        //--------------------------------------------------------------------------
	        // --------------Création du tableau ---------------------------------------
	        //--------------------------------------------------------------------------
	        
	        String[] columnNames = {"Numéro Épreuve", "Date", "Heure Début", "Heure Fin", "Durée", "Discipline"};
	        this.model = new DefaultTableModel(columnNames, 0);
	        
	        JTable table = new JTable(model);
	        table.setRowHeight(30);

	        JScrollPane scrollPane = new JScrollPane(table);
	        disciplinePanel.add(scrollPane, BorderLayout.CENTER);

	        // Ajout du bouton pour ajouter de nouveaux discipline
	        addButton = new JButton("Ajouter discipline");
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	JTextField nomDisciplineFiel = new JTextField(10);
	            	
	            	

	                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
	                inputPanel.add(new JLabel("nom Discipline :"));
	                inputPanel.add(nomDisciplineFiel);
	                
	                
	                
	                inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	                int result = JOptionPane.showConfirmDialog(null, inputPanel, "Ajouter une discipline",
	                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	                if (result == JOptionPane.OK_OPTION) {

	                    
	                    String nomDiscipline = nomDisciplineFiel.getText();


	                    model.addRow(new Object[]{getNextDisciplineNumber(), nomDiscipline});
	                }
	            }
	        });

	        
	        disciplinePanel.add(addButton, BorderLayout.SOUTH);
	        

	        mainContentPanel.add(disciplinePanel, BorderLayout.CENTER);
	        add(mainContentPanel, BorderLayout.CENTER);

	        
	        
	        // Exemple de données, vous devez remplacer par les données réelles
	        Discipline athletisme = new Discipline("Athlétisme");
	        Discipline natation = new Discipline("Natation");
	        
	        
	        // Ajout des pays à la table
	        ArrayList<Discipline> disciplinex = new ArrayList<>();
	        disciplinex.add(athletisme);
	        disciplinex.add(natation);
	        
	        
	        // Ajout des épreuves à la table
	        Discipline[] disciplines = {athletisme,natation};

	        for (Discipline discipline : disciplines) {
	            model.addRow(new Object[]{
	            	discipline.getNumDiscipline(),
	            	discipline.getNomDiscipline(),
	                
	            });
	            

	        }
	    }
	    
	}

