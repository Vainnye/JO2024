package modeles;

//import java.util.Arrays;

public class Pays {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numPays;
	private String nomPays;
	private String codePays;
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
	public String getCodePays() {return codePays;}
	public int getNbEquipe() {return nbEquipe;}
	public Equipe[] getListeEquipe() {return listeEquipe;}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Pays(String nomPays, String codePays) {
		super();
		this.numPays=compteur;
		this.nomPays = nomPays;
		this.codePays = codePays;
		nbOr=0;
		nbArgent=0;
		nbBronze=0;
		listeEquipe = new Equipe [NBEQUIPEMAX];
		compteur++;
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
		Pays France = new Pays("France","fr");
		Pays Espagne = new Pays("Espagne","fr");
		Pays Italie = new Pays("Italie","fr");
		
		System.out.println(France);
		System.out.println(Espagne);
		System.out.println(Italie);
	}

}
