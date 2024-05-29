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
			Equipe[]listeEquipeTot,Equipe[] resultatEpreuveTot){
		super();
		this.numEpreuve=compteur;
		this.dateEpreuve = dateEpreuve;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.dureeHeure = dureeHeure;
		this.disciplineEpreuve = disciplineEpreuve;
		compteur++;
		listeEquipe = listeEquipeTot;
		troisEquipeGagnante = resultatEpreuveTot;
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
	
	public String toStringRd() {
        StringBuilder sb = new StringBuilder();
        sb.append("Epreuve [numEpreuve=").append(numEpreuve);
        sb.append(", dateEpreuve=").append(dateEpreuve);
        sb.append(", heureDebut=").append(heureDebut);
        sb.append(", heureFin=").append(heureFin);
        sb.append(", dureeHeure=").append(dureeHeure);
        sb.append(", disciplineEpreuve=").append(disciplineEpreuve.getNomDiscipline());
        sb.append(", listeEquipe=");
        for (Equipe equipe : listeEquipe) {
            sb.append(equipe.toStringRd()).append("/ ");
        }
        return sb.toString();
    }
	
	public void affichage(Equipe tab[]) {
		for(Equipe i: tab)
			i.afficherAthlete();
	}
	
	public static void main(String[] args) {
	}
	

}
