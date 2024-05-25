package modeles;

//import java.util.Arrays;

public class Pays {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private int numPays;
	private String nomPays;
	private int nbOr;
	private int nbArgent;
	private int nbBronze;
	
	private final static int NBEQUIPEMAX = 100;
	private Equipe listeEquipe [];
	int nbEquipe=0;
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumPays() {return numPays;}
	public String getNomPays() {return nomPays;}
	public int getNbOr() {return nbOr;}
	public int getNbArgent() {return nbArgent;}
	public int getNbBronze() {return nbBronze;}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Pays(int numPays, String nomPays) {
		super();
		this.numPays = numPays;
		this.nomPays = nomPays;
		nbOr=0;
		nbArgent=0;
		nbBronze=0;
		listeEquipe = new Equipe [NBEQUIPEMAX];
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Pays [numPays=" + numPays + ", nom du Pays=" + nomPays + ", nombre de médaille d'Or=" + nbOr + ", nombre de médaille d'Argent=" + nbArgent
				+ ", nombre de médaille de Bronze=" + nbBronze + ", nombre d'Equipe=" + nbEquipe
				+ "]";
	}
	
	//----------------------------------------------------
    //---------METHODES PUBLIQUES------------------------------------
    //----------------------------------------------------
	public void ajoutEquipe(Equipe E){
		listeEquipe[nbEquipe] = E;
		nbEquipe++;
	}
	
	public void supprimerEquipe(Equipe E){
		listeEquipe[nbEquipe] = null;
		nbEquipe--;
	}
	
	public void addOr() {nbOr++;}
	public void addArgent() {nbArgent++;}
	public void addBronze() {nbBronze++;}
	
	public void delOr() {nbOr--;}
	public void delArgent() {nbArgent--;}
	public void delBronze() {nbBronze--;}

	public static void main(String[] args) {
	}

}
