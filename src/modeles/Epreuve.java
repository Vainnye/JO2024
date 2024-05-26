package modeles;

import java.util.Arrays;

public class Epreuve {

	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numEpreuve;
	private String dateEpreuve;
	private String heureDebut;
	private String heureFin;
	private float dureeHeure;
	private Discipline disciplineEpreuve;
	private Equipe listeEquipe[];
	private Equipe troisEquipeGagnante[];
	
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNmuEpreuve() {return numEpreuve;}
	public String getDateEpreuve() {return dateEpreuve;}
	public String getheureDebut() {return heureDebut;}
	public String getDateFin() {return heureFin;}
	public float getDureeHeure() {return dureeHeure;}
	public Discipline getDisciplineEpreuve() {return disciplineEpreuve;}
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Epreuve(String dateEpreuve, String heureDebut, String heureFin, float dureeHeure,Discipline disciplineEpreuve,
			Equipe[]listeEquipe,Equipe[] resultatEpreuve){
		super();
		this.numEpreuve=compteur;
		this.dateEpreuve = dateEpreuve;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
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
		return "Epreuve [numEpreuve=" + numEpreuve + ", dateEpreuve=" + dateEpreuve + ", dateDebut=" + heureDebut
				+ ", dateFin=" + heureFin + ", dureeHeure=" + dureeHeure + ", disciplineEpreuve=" + disciplineEpreuve.getNomDiscipline()
				+ ", listeEquipe=" + Arrays.toString(listeEquipe) + ", troisEquipeGagnante="
				+ Arrays.toString(troisEquipeGagnante) + "]";
	}
	
	
	public static void main(String[] args) {
		/*Epreuve footJour1 = new Epreuve("12/07/2024","14h","16h",2,football,{equipeDeFrance,equipeDuPortugal},{equipeDeFrance,equipeDuPortugal});
		
		System.out.println(footJour1);*/
	}
	

}
