package modeles;

public class Discipline {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
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
	public Discipline(int numDiscipline, String nomDiscipline) {
		super();
		this.numDiscipline = numDiscipline;
		this.nomDiscipline = nomDiscipline;
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		return "Discipline [numDiscipline=" + numDiscipline + ", nomDiscipline=" + nomDiscipline + "]";
	}
	
	public static void main(String[] args) {

	}
	

}
