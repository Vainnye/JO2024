package modeles;

import java.util.Arrays;
import java.util.ArrayList;


public class Equipe implements Comparable<Equipe> {
	
	//----------------------------------
	//	modèle des équipes
	//----------------------------------
	
	// liste de toutes les équipes de l'app
	private static ArrayList<Equipe> listeEquipes = new ArrayList<Equipe>(Arrays.asList(
			// Equipes par défaut
			new Equipe("Equipe de France", "masculin", "18-40 ans", Pays.getPays("FRA"), null),
			new Equipe("Equipe USA", "feminin", "18-40 ans", Pays.getPays("USA"), null)
		));
	
	
	public static ArrayList<Equipe> getListCopy() { 
		return new ArrayList<Equipe>(listeEquipes);
	}
	
	
	public static void add(Equipe e) {
		if(e.nomEquipe.equals(""))
			throw new IllegalArgumentException("Le nom ne dois pas être vide ");
		else if(listeEquipes.isEmpty()) 
			listeEquipes.add(e);
		else if(!listeEquipes.contains(e))
			listeEquipes.add(e);
		else
			throw new IllegalArgumentException("l'équipe '"+e.nomEquipe+"' existe déjà");
		
		listeEquipes.sort(null);
	}
	
		
	//--------------------------------------------------------------------
	//	override de equals() et compareTo()
	//	dans le but d'utiliser contains() et sort() sur listeEquipes
	//--------------------------------------------------------------------
	
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	        return true;
	    if (o == null)
	    	return false;
	    if (getClass() != o.getClass())
	        return false;
	    return nomEquipe.equals(((Equipe)o).nomEquipe);
	}
	
	
	@Override
	public int compareTo(Equipe e) {
		return this.nomEquipe.compareTo(e.nomEquipe);
	}

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
        StringBuilder sb = new StringBuilder();
        sb.append(nomEquipe).append(": ");
        for (Athlete athlete : listeAthlete) {
        	if(athlete !=null)
        		sb.append(athlete.getNomAthlete()).append(", ");
        }
        return sb.toString();
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
	
	public void afficherAthlete() {
		for(Athlete a : listeAthlete)
			System.out.println(a.getPrenomAthlete()+a.getNomAthlete());
	}
	
	public static void main(String[] args) {

	}

}
