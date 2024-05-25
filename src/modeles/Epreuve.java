package modeles;

import java.util.Arrays;

public class Epreuve {

	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numEpreuve;
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
			Equipe[]listeEquipe,Equipe[] resultatEpreuve){
		super();
		this.numEpreuve=compteur;
		this.dateEpreuve = dateEpreuve;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dureeHeure = dureeHeure;
		this.disciplineEpreuve = disciplineEpreuve;
		compteur++;
		this.listeEquipe = listeEquipe;
		troisEquipeGagnante = resultatEpreuve;
		Resultat r = new Resultat(numEpreuve,troisEquipeGagnante);
	}
	
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Epreuve [numEpreuve=" + numEpreuve + ", dateEpreuve=" + dateEpreuve + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", dureeHeure=" + dureeHeure + ", disciplineEpreuve=" + disciplineEpreuve.getNomDiscipline()
				+ ", listeEquipe=" + Arrays.toString(listeEquipe) + ", troisEquipeGagnante="
				+ Arrays.toString(troisEquipeGagnante) + "]";
	}
	
	
	public static void main(String[] args) {

	}
	

}
