package modeles;

import java.util.ArrayList;
import java.util.Arrays;

public class Discipline implements Comparable<Discipline> {
	
	
	//-----------------------------------------------------------------------------------------
	//	gestion de la liste de toutes les disciplines (partie modèle de la vue des disciplines
	//-----------------------------------------------------------------------------------------
	
	// liste de toutes les disciplines existantes
	private static ArrayList<Discipline> listeDisciplines = new ArrayList<Discipline>(Arrays.asList(
			new Discipline("Athlétisme"),
			new Discipline("Natation")
			));

	public static ArrayList<Discipline> getListCopy() { 
		return new ArrayList<Discipline>(listeDisciplines);
	}
	
	public static void add(Discipline d) {
		if(d.nomDiscipline.equals(""))
			throw new IllegalArgumentException("Le nom ne dois pas être vide ");
		else if(listeDisciplines.isEmpty()) 
			listeDisciplines.add(d);
		else if(!listeDisciplines.contains(d))
			listeDisciplines.add(d);
		else
			throw new IllegalArgumentException("la discipline '"+d.getNomDiscipline()+"' existe déjà");
		
		listeDisciplines.sort(null);
	}

	
	// Exemple de données, vous devez remplacer par les données réelles
	private static void loadTestSet() {
		add(new Discipline("Athlétisme"));
		add(new Discipline("Natation"));
	}

	
	//--------------------------------------------------------------------
	//	override de equals() et compareTo()
	//	dans le but d'utiliser contains() et sort() sur listeDisciplines
	//--------------------------------------------------------------------
	
	@Override
	public boolean equals(Object o) {
	    if (this == o)
	        return true;
	    if (o == null)
	    	return false;
	    if (getClass() != o.getClass())
	        return false;
	    return nomDiscipline.equals(((Discipline)o).nomDiscipline);
	}
	
	
	@Override
	public int compareTo(Discipline d) {
		return this.nomDiscipline.compareTo(d.nomDiscipline);
	}
	
	
	
	
    
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private int numDiscipline;
	private String nomDiscipline;
	private static int compteur=0;
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumDiscipline() {return numDiscipline;}
	public String getNomDiscipline() {return nomDiscipline;}

	

	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Discipline(String nomDiscipline) {
		this.numDiscipline=compteur;
		this.nomDiscipline = nomDiscipline;
		compteur++;
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Discipline [numDiscipline=" + numDiscipline + ", nomDiscipline=" + nomDiscipline + "]";
	}
	
	
	/* Pour tester :
	public static void main(String[] args) {
		Discipline football = new Discipline("football");
		Discipline basketball = new Discipline("basketball");
		Discipline handball = new Discipline("handball");
		
		System.out.println(football);
		System.out.println(basketball);
		System.out.println(handball);

	}
	*/

	
	
}
