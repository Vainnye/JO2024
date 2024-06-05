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
	
	//-----------------------------
	// Constantes ACTION pour la gestion des evenements
	// (plus general que d'utiliser le nom du bouton : 
	// plusieurs boutons peuvent declencher la meme action)
	//-----------------------------
	
	static public final String ACT_AJOUTE_DISCIPLINE = "AJOUTE_DISCIPLINE";
	static public final String ACT_RETIRE_DISCIPLINE = "RETIRE_DISCIPLINE";
	static public final String ACT_GO_MENU = "GO_MENU";
	static public final String ACT_GO_ACCUEIL = "GO_ACCUEIL";
	
	
	//-----------------------------
	// Attributs
	//-----------------------------
	
	vuesDiscipline vue;
	Discipline modele;
	
	
	
	//-----------------------------
	// Constructeur
	//-----------------------------
	
	public CtrDiscipline (vuesDiscipline vue, Discipline modele) {
		this.vue = vue;
		this.modele = modele;
		
		//vue.getUnBouton().addActionListener(this);
	}
	
	
	
	//-----------------------------
	// Gerer un clic sur un des boutons
	//-----------------------------

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(ACT_AJOUTE_DISCIPLINE)) {
			// le modèle devrait contenir un ArrayList de String (les noms des discciplines)
			//
			JFrame popup = new JFrame();
		    String nomDiscipline = JOptionPane.showInputDialog(popup,"Discipline à ajouter :", "boîte de dialogue");
			try {
		    //modele.add( nomDicipline );
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(popup, exc.getMessage(), "erreur", JOptionPane.PLAIN_MESSAGE);
			}
		}
		//else if(e.getSource() == vue.attribut)
		//
		// ...
	}
	
}
