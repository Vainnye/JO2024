package modeles;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;


public class Pays {
	
	
	private static ArrayList<Pays> listePays = new ArrayList<Pays>(Arrays.asList(
		new Pays("France","FRA"),
		new Pays("Espagne","ESP"),
		new Pays("Italie","ITA"),
		new Pays("Portugal","POR"),
	    new Pays("États-Unis", "USA")
	));
	
	public static ArrayList<Pays> getListCopy() {
		return new ArrayList<Pays>(listePays);
	};
	
	// MODIFICATIONS EN COURS.......................
	
	
	public static Pays getPays(String codePays) {
		int i=0;
		while(i<listePays.size() && listePays.get(i).codePays != codePays) {
			i++;
		}
		if(i>=listePays.size())
			throw new IllegalArgumentException("Le pays n'existe pas dans la liste");
		else
			return listePays.get(i-1);
	}
	
	
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
		return "Pays [numPays=" + numPays + ", nom du Pays= " + nomPays + ", nombre de médaille d'Or= " + nbOr + ", nombre de médaille d'Argent= " + nbArgent
				+ ", nombre de médaille de Bronze= " + nbBronze + ", nombre d'Equipe= " + nbEquipe
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
		Pays france = new Pays("France","fr");
		Pays espagne = new Pays("Espagne","fr");
		Pays italie = new Pays("Italie","fr");
		Pays portugal = new Pays("Portugal","pg");

		
		System.out.println(france);
		System.out.println(espagne);
		System.out.println(italie);
		System.out.println(portugal);

	}

}
