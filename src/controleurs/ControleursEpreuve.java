package controleurs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleursEpreuve extends JPanel implements ActionListener{

	JLabel S1,S2,S3,S4,S5,S6;
	JButton bMenu;

	ControleursEpreuve(){
		S1 = new JLabel("HANDBALL");
		S2 = new JLabel("GYMNASTIQUE");
		S3 = new JLabel("RUGBY");
		S4 = new JLabel("VOLLEYBALL");
		S5 = new JLabel("ATHLETISME");
		S6 = new JLabel("NATATION");

		bMenu = new JButton("Logo");
		
		bMenu.addActionListener(this);
		
		add(S1);
		add(S2);
		add(S3);
		add(S4);
		add(S5);
		add(S6);
		add(bMenu);
		

	}
	public void actionPerformed(ActionEvent e) {
		//si on appuie sur le bouton menu on sera rediriger vers la page menu
		if (e.getSource() == bMenu) {

		}
	}

	public static void main(String[] args) {

		// Creer une fenetre
		JFrame fenetre = new JFrame ("Epreuve");
		fenetre.setSize (400, 200);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creer une instance de ma classe
		ControleursEpreuve p = new ControleursEpreuve ();

		//placement dans la fenetre
				p.setLayout(new GridLayout(7, 1));
		
		// Ajouter mon instance dans un des conteneurs de la fen?tre
		fenetre.add(p);

		// Afficher la fenetre
		fenetre.setVisible(true);
	}



}
