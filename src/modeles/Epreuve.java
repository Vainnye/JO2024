package modeles;

public class Epreuve {
	
	private int numEpreuve=0;
	private String dateEpreuve;
	private String dateDebut;
	private String dateFin;
	private float dureeHeure;
	private Discipline disciplineEpreuve;
	
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNmuEpreuve() {return numEpreuve;}
	public String getDateEpreuve() {return dateEpreuve;}
	public String getDeteDebut() {return dateDebut;}
	public String getDateFin() {return dateFin;}
	public float getDureeHeure() {return dureeHeure;}
	public Discipline getDisciplineEpreuve() {return disciplineEpreuve;}
	
	
	
	
	
	
	public Epreuve(String dateEpreuve, String dateDebut, String dateFin, float dureeHeure,Discipline disciplineEpreuve) {
		super();
		this.dateEpreuve = dateEpreuve;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dureeHeure = dureeHeure;
		this.disciplineEpreuve = disciplineEpreuve;
		numEpreuve++;
	}
	
	
	
	
	public static void main(String[] args) {

	}

}
