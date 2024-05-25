package modeles;

public class Epreuve {

	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private int numEpreuve=0;
	private String dateEpreuve;
	private String dateDebut;
	private String dateFin;
	private float dureeHeure;
	private Discipline disciplineEpreuve;
	private Equipe listeEquipe[];
	private Equipe troisEquipeGagnante[];
	
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNmuEpreuve() {return numEpreuve;}
	public String getDateEpreuve() {return dateEpreuve;}
	public String getDeteDebut() {return dateDebut;}
	public String getDateFin() {return dateFin;}
	public float getDureeHeure() {return dureeHeure;}
	public Discipline getDisciplineEpreuve() {return disciplineEpreuve;}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Epreuve(String dateEpreuve, String dateDebut, String dateFin, float dureeHeure,Discipline disciplineEpreuve,
			Equipe[]lisetEquipe,Equipe[] resultatEpreuve){
		super();
		this.dateEpreuve = dateEpreuve;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dureeHeure = dureeHeure;
		this.disciplineEpreuve = disciplineEpreuve;
		numEpreuve++;
		this.listeEquipe = listeEquipe;
		troisEquipeGagnante = resultatEpreuve;
	}
	
	public static void main(String[] args) {

	}

}
