package modeles;

public class Pays {
	
	private int numPays;
	private String nomPays;
	private int nbOr;
	private int nbArgent;
	private int nbBronze;
	private int nbEquipeMax = 100;
	private int listeEquipe [] = new int [nbEquipeMax];
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumPays() {return numPays;}
	public String getNomPays() {return nomPays;}
	public int getNbOr() {return nbOr;}
	public int getNbArgent() {return nbArgent;}
	public int getNbBronze() {return nbBronze;}



	public static void main(String[] args) {
	}

}
