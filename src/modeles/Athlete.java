package modeles;

import java.util.ArrayList;
import java.util.Arrays;

public class Athlete implements Comparable<Athlete> {
	
	//-----------------------------------------------------------------------------------------
	//	gestion de la liste de toutes les Athletes
	//-----------------------------------------------------------------------------------------
	
	// liste de toutes les disciplines existantes
	private static ArrayList<Athlete> listeAthletes = new ArrayList<Athlete>(Arrays.asList(
			));

	public static ArrayList<Athlete> getListCopy() { 
		return new ArrayList<Athlete>(listeAthletes);
	}
	
	public static void add(Athlete a) {
		if(a.nomAthlete.equals(""))
			throw new IllegalArgumentException("Le nom ne dois pas être vide ");
		if(a.prenomAthlete.equals(""))
			throw new IllegalArgumentException("Le prénom ne dois pas être vide ");
		else if(listeAthletes.isEmpty()) 
			listeAthletes.add(a);
		else if(!listeAthletes.contains(a))
			listeAthletes.add(a);
		else
			throw new IllegalArgumentException("l'athlète '"+a.prenomAthlete+a.nomAthlete.toUpperCase()+"' existe déjà");
		
		listeAthletes.sort(null);
	}
	
	
	
	
	//--------------------------------------------------------------------
	//	override de equals() et compareTo()
	//	dans le but d'utiliser contains() et sort() sur listeAthletes
	//--------------------------------------------------------------------
	
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	        return true;
	    if (o == null)
	    	return false;
	    if (getClass() != o.getClass())
	        return false;
	    return nomAthlete.equals(((Athlete)o).nomAthlete)
	    		&& prenomAthlete.equals(((Athlete)o).prenomAthlete)
	    		&& dateDeNaissance.equals(((Athlete)o).dateDeNaissance);
	}
	
	
	@Override
	public int compareTo(Athlete a) {
		if(this.nomAthlete != a.nomAthlete)
			return this.nomAthlete.compareTo(a.nomAthlete);
		else if(this.prenomAthlete != a.prenomAthlete)
			return this.prenomAthlete.compareTo(a.prenomAthlete);
		else if(this.dateDeNaissance != a.dateDeNaissance)
			return this.dateDeNaissance.compareTo(a.dateDeNaissance);
		else
			return (this.numAthlete>a.numAthlete? 1 : (this.numAthlete==a.numAthlete? 0 : -1));
	}


	
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numAthlete;
	private String prenomAthlete;
	private String nomAthlete;
	private String dateDeNaissance;
	private Equipe EquipeAthlete;
	private Pays PaysAthlete;
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumAthlete() {return numAthlete;}
	public String getPrenomAthlete() {return prenomAthlete;}
	public String getNomAthlete() {return nomAthlete;}
	public String getDateDeNaissance() {return dateDeNaissance;}
	public Equipe getEquipeAthlete() {return EquipeAthlete;}
	public Pays getPaysAthlete() {return PaysAthlete;}
	
	
	//----------------------------------------------------
	//---------SETTERS------------------------------------
	//----------------------------------------------------
	public void setEquipeAthlete(Equipe E) {EquipeAthlete = E; }
	
	
	public static void setCompteur(int compteur) {
		Athlete.compteur = compteur;
	}
	public void setNumAthlete(int numAthlete) {
		this.numAthlete = numAthlete;
	}
	public void setPrenomAthlete(String prenomAthlete) {
		this.prenomAthlete = prenomAthlete;
	}
	public void setNomAthlete(String nomAthlete) {
		this.nomAthlete = nomAthlete;
	}
	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public void setPaysAthlete(Pays paysAthlete) {
		PaysAthlete = paysAthlete;
	}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Athlete(String prenomAthlete, String nomAthlete, String dateDeNaissance,Equipe equipeAthlete, Pays paysAthlete) {
		super();
		this.numAthlete=compteur;
		this.prenomAthlete = prenomAthlete;
		this.nomAthlete = nomAthlete;
		this.dateDeNaissance = dateDeNaissance;
		EquipeAthlete = equipeAthlete;
		PaysAthlete = paysAthlete;
		compteur++;
		equipeAthlete.ajoutAthlete(this);
	}
	
	public Athlete(String prenomAthlete, String nomAthlete, String dateDeNaissance, Pays paysAthlete) {
		super();
		this.prenomAthlete = prenomAthlete;
		this.nomAthlete = nomAthlete;
		this.dateDeNaissance = dateDeNaissance;
		PaysAthlete = paysAthlete;
		numAthlete++;
	}
    
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Athlete [numAthlete=" + numAthlete + ", prenomAthlete=" + prenomAthlete + ", nomAthlete=" + nomAthlete
				+ ", dateDeNaissance=" + dateDeNaissance + ", EquipeAthlete=" + EquipeAthlete.getNomEquipe() + ", PaysAthlete="
				+ PaysAthlete.getNomPays() + "]";
	}
	
	//----------------------------------------------------
    //---------METHODES PUBLIQUES------------------------------------
    //----------------------------------------------------


	public static void main(String[] args) {
	}
	

}
