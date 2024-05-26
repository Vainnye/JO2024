package modeles;

public class Discipline {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
	private static int compteur=0;
	private int numDiscipline;
	private String nomDiscipline;
	
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumDiscipline() {return numDiscipline;}
	public String getNomDiscipline() {return nomDiscipline;}

	

	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Discipline(String nomDiscipline) {
		super();
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
	
	public static void main(String[] args) {
		Discipline football = new Discipline("football");
		Discipline basketball = new Discipline("basketball");
		Discipline handball = new Discipline("handball");
		
		System.out.println(football);
		System.out.println(basketball);
		System.out.println(handball);

	}
	

}
