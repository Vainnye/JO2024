package modeles;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//----------------------------------------------------
	    //---------CREATION D'INSTANCE DE CLASSE--------------
	    //----------------------------------------------------
		
		
		
		
		
		//----------------------------------------------------
	    //---------CREATION DE PAYS---------------------------
	    //----------------------------------------------------
		Pays france = new Pays("France","fr");
		Pays espagne = new Pays("Espagne","fr");
		Pays italie = new Pays("Italie","fr");
		Pays portugal = new Pays("Portugal","pg");

		System.out.println(france);
		System.out.println(espagne);
		System.out.println(italie);
		System.out.println(portugal);
		System.out.println();
		System.out.println();

		
		//----------------------------------------------------
	    //---------CREATION DE DISCIPLINES--------------------
	    //----------------------------------------------------
		Discipline football = new Discipline("football");
		Discipline basketball = new Discipline("basketball");
		Discipline handball = new Discipline("handball");
		
		System.out.println(football);
		System.out.println(basketball);
		System.out.println(handball);
		System.out.println();
		System.out.println();

		
		//----------------------------------------------------
	    //---------CREATION D'EQUIPES-------------------------
	    //----------------------------------------------------
		Equipe equipeDeFrance = new Equipe("Equipe de France","masculin","18-40 ans",france,football);
		Equipe equipeDuPortugal = new Equipe("Equipe du Portugal","masculin","18-40 ans",portugal,football);
				
		System.out.println(equipeDeFrance);
		System.out.println(equipeDuPortugal);
		System.out.println();
		System.out.println();

		
		//----------------------------------------------------
	    //---------CREATION D'ATHLETES------------------------
	    //----------------------------------------------------
		Athlete mbappe = new Athlete("Kylian","Mbappe","10/10/1998",equipeDeFrance,france);
		Athlete griezman = new Athlete("Antoine","Griezman","10/12/1995",equipeDeFrance,france);
		Athlete ronaldo = new Athlete("Christiano","Ronaldo","13/11/1992",equipeDuPortugal,portugal);
		
		System.out.println(mbappe);
		System.out.println(griezman);
		System.out.println(ronaldo);
		System.out.println();
		System.out.println();

		
		//----------------------------------------------------
	    //---------CREATION D'EPREUVES------------------------
	    //----------------------------------------------------
		Equipe[] listeEquipeMatchFootJour1 = {equipeDeFrance,equipeDuPortugal};
		Equipe[] resultatEquipeMatchFootJour1 = {equipeDeFrance,equipeDuPortugal};

		Epreuve footJour1 = new Epreuve("12/07/2024","14h","16h",2,football,listeEquipeMatchFootJour1,resultatEquipeMatchFootJour1);
		System.out.println(footJour1);

	}

}
