package modeles;

public class Equipe {
	
	private int numEquipe;
	private int nbPersonnes;
	private String sexe;
	private String trancheAge;
	private int nbAthleteMax = 100;
	private int nbAthlete;
	private Athlete listeAthlete [] = new Athlete [nbAthleteMax];
	private String paysEquipe;
	
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumEquipe() {return numEquipe;}
	public int getNbPersonnes() {return nbPersonnes;}
	public String getSexe() {return sexe;}
	public String getTrancheAge() {return trancheAge;}
	public int getNbAthleteMax() {return nbAthleteMax;}
	public Athlete[] getListeAthlete() {return listeAthlete;}
	public String getPaysEquipe() {return paysEquipe;}
	
	public void ajoutAthlete(Athlete A) {
		listeAthlete[nbAthlete] = A;
		nbAthlete++;
		A.assignEquipe(this);
	}
	
	public void supprimerAthlete(Athlete A) {
		listeAthlete[nbAthlete] = null;
		nbAthlete--;
		A.removeEquipe();
	}

	public static void main(String[] args) {

	}

}
