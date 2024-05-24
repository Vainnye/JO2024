package modeles;

public class Athlete {
	
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
	public Equipe getNumEquipe() {return EquipeAthlete;}
	
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
