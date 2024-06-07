/**
 * @author Vianney Jacquemot
 */


package controleurs;

import vues.*;
import modeles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CtrDiscipline implements ActionListener {
	
	//-----------------------------------------------------------
	// Constantes ACTION pour la gestion des evenements
	// (plus general que d'utiliser le nom du bouton : 
	// plusieurs boutons peuvent declencher la meme action)
	//------------------------------------------------------------
	
	
	//-----------------------------
	// Attributs
	//-----------------------------
	
	vuesDiscipline vue;
	
	/**
	 * Pas de référence vers un modele car la vue des disciplines manipule 
	 * un ArrayList static présent dans Discipline
	 * 
	 * au lieu d'appeller "modele", on appelle "Discipline"
	 * ex: Discipline.add(new Discipline("toto"));
	 */
	
	
	//-----------------------------
	// Constructeur
	//-----------------------------
	
	public CtrDiscipline (vuesDiscipline vue) {
		this.vue = vue;
		
		vue.getBackButton().addActionListener(this);
		vue.getAddButton().addActionListener(this);
	}
	
	
	
	//-----------------------------
	// Gerer un clic sur un des boutons
	//-----------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vue.getAddButton()) {
			// le modèle devrait contenir un ArrayList de String (les noms des discciplines)
			//
			JFrame popup = new JFrame();
		    String nomDiscipline = vue.saisieDiscipline();//JOptionPane.showInputDialog(popup,"nom Discipline :", "Ajouter une discipline");
			try {
				Discipline.add(new Discipline(nomDiscipline));
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(popup, exc.getMessage(), "erreur", JOptionPane.PLAIN_MESSAGE);
			}
		}
		//else if(e.getSource() == vue.attribut)
		//
		// ...
		vue.updateView();
	}
	
}
