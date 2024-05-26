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
		/*Athlete mbappe = new Athlete("Kylian","Mbappe","10/10/1998",equipeDeFrance,france);
		Athlete griezman = new Athlete("Antoine","Griezman","10/12/1995",equipeDeFrance,france);
		Athlete ronaldo = new Athlete("Christiano","Ronaldo","13/11/1992",equipeDuPortugal,portugal);
		
		System.out.println(mbappe);
		System.out.println(griezman);
		System.out.println(ronaldo);*/

	}
	

}
