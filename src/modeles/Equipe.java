package modeles;

public class Equipe {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private int numEquipe;
	private String sexe;
	private String trancheAge;
	private final static int NBATHLETEMAX = 100;
	private int nbAthlete;
	private Athlete listeAthlete [];
	private Pays paysEquipe;
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumEquipe() {return numEquipe;}
	public String getSexe() {return sexe;}
	public String getTrancheAge() {return trancheAge;}
	public int getNbAthleteMax() {return NBATHLETEMAX;}
	public Athlete[] getListeAthlete() {return listeAthlete;}
	public int getNbAthlete() {return nbAthlete;}
	public Pays getPaysEquipe() {return paysEquipe;}
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Equipe(int numEquipe, String sexe, String trancheAge, Pays paysEquipe) {
		super();
		this.numEquipe = numEquipe;
		this.sexe = sexe;
		this.trancheAge = trancheAge;
		this.paysEquipe = paysEquipe;
		nbAthlete=0;
		listeAthlete = new Athlete [NBATHLETEMAX];
	}
	//----------------------------------------------------
    //---------METHODES PUBLIQUES------------------------------------
    //----------------------------------------------------
	public void ajoutAthlete(Athlete A) {
		listeAthlete[nbAthlete] = A;
		nbAthlete++;
		A.setEquipeAthlete(this);
	}
	
	
	public void supprimerAthlete(Athlete A) {
		listeAthlete[nbAthlete] = null;
		nbAthlete--;
		A.setEquipeAthlete(null);
	}

	public static void main(String[] args) {

	}

}
