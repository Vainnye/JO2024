package controleurs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class ControleursEquipe extends JPanel implements ActionListener {

	private ArrayList<ControleursPays> pays;
	
	public ControleursEquipe(ArrayList<ControleursPays> pays) {
		this.pays=pays;
		
	}
	public void RecherchePays(String nom) {
		
		if(pays.contains(nom)) {
			System.out.println(pays.contains(nom));
		}else {
			System.out.println("Le pays rechercher n'existe pas");
		}
			
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
}
