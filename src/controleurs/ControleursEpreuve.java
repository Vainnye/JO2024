package controleurs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControleursEpreuve  implements ActionListener{

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

	
	}




