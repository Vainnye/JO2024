package modeles;

public class Athlete {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
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
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Athlete(int numAthlete, String prenomAthlete, String nomAthlete, String dateDeNaissance,Equipe equipeAthlete, Pays paysAthlete) {
		super();
		this.numAthlete = numAthlete;
		this.prenomAthlete = prenomAthlete;
		this.nomAthlete = nomAthlete;
		this.dateDeNaissance = dateDeNaissance;
		EquipeAthlete = equipeAthlete;
		PaysAthlete = paysAthlete;
	}
	
	public Athlete(int numAthlete, String prenomAthlete, String nomAthlete, String dateDeNaissance, Pays paysAthlete) {
		super();
		this.numAthlete = numAthlete;
		this.prenomAthlete = prenomAthlete;
		this.nomAthlete = nomAthlete;
		this.dateDeNaissance = dateDeNaissance;
		PaysAthlete = paysAthlete;
	}
	//----------------------------------------------------
    //---------METHODES PRIVEES------------------------------------
    //----------------------------------------------------
    private void setEquipeAthlete(Equipe numEquipe) { this.EquipeAthlete = numEquipe; }

    
	//----------------------------------------------------
    //---------METHODES PUBLIQUES------------------------------------
    //----------------------------------------------------
    public void assignEquipe(Equipe E) {setEquipeAthlete(E);}
    public void removeEquipe() {setEquipeAthlete(null);}

	public static void main(String[] args) {

	}

}
