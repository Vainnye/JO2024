package modeles;

public class Athlete {
	
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
