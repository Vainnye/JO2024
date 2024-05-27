package modeles;

import java.util.Arrays;

public class Equipe {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numEquipe;
	private String nomEquipe;
	private String sexe;
	private String trancheAge;
	private final static int NBATHLETEMAX = 100;
	private int nbAthlete;
	private Athlete listeAthlete [];
	private Pays paysEquipe;
	private Discipline disciplineEquipe;
	
	
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
	public String getNomEquipe() {return nomEquipe;}
	public Discipline getDisciplineEquipe() {return disciplineEquipe;}
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Equipe(String nomEquipe, String sexe, String trancheAge, Pays paysEquipe, Discipline disciplineEquipe) {
		super();
		this.numEquipe=compteur;
		this.nomEquipe = nomEquipe;
		this.sexe = sexe;
		this.trancheAge = trancheAge;
		this.paysEquipe = paysEquipe;
		this.disciplineEquipe=disciplineEquipe;
		nbAthlete=0;
		listeAthlete = new Athlete [NBATHLETEMAX];
		compteur++;
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Equipe [numEquipe=" + numEquipe + ", nom de'Equipe=" + nomEquipe + ", sexe des athletes= " + sexe + ", tranche d'Age des athletes="
				+ trancheAge + ", nombre d'Athlete=" + nbAthlete + ", liste des Athletes=" + Arrays.toString(listeAthlete)
				+ "]";
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
