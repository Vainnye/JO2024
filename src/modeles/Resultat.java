package modeles;

import java.util.Arrays;

public class Resultat {
	private int numEpreuve;
	private Equipe resultat[];
	private Equipe premier;
	private Equipe deuxieme;
	private Equipe troisieme;

	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumEpreuve() {return numEpreuve;}
	public Equipe[] getResultat() {return resultat;}
	public Equipe getPremier() {return premier;}
	public Equipe getDeuxieme() {return deuxieme;}
	public Equipe getTroisieme() {return troisieme;}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	Resultat(int numEpreuve,Equipe[]listeResultat){
		this.numEpreuve = numEpreuve;
		resultat = listeResultat;
		premier = resultat[0];
		deuxieme = resultat[1];
		troisieme = resultat[2];
		premier.getPaysEquipe().addOr();
		deuxieme.getPaysEquipe().addArgent();
		troisieme.getPaysEquipe().addBronze();
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Resultat [numEpreuve:" + numEpreuve + ", premier=" + premier
				+ ", deuxieme=" + deuxieme + ", troisieme=" + troisieme + "]";
	}
	
	
	public static void main(String[] args) {

	}

}
