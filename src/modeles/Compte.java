package modeles;

public class Compte {
	
	private int numCompte;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String addressMailUtilisateur;
	private String telephoneUtilisateur;
	private String Apparence;
	private boolean autorisationLocalisation;
	private boolean autorisationNotification;
	private String dateNaissanceUtilisateur;
	private boolean gestionnaire;
	private boolean administrateur;
	
	
	//----------------------------------------------------
	//---------GETTERS------------------------------------
	//----------------------------------------------------
	public int getNumCompte() {return numCompte;}
	public String getNomUtilisateur() {return nomUtilisateur;}
	public String getPrenomUtilisateur() {return prenomUtilisateur;}
	public String getAddressMailUtilisateur() {return addressMailUtilisateur;}
	public String getTelephoneUtilisateur() {return telephoneUtilisateur;}
	public String getApparence() {return Apparence;}
	public boolean isAutorisationLocalisation() {return autorisationLocalisation;}
	public boolean isAutorisationNotification() {return autorisationNotification;}
	public String getDateNaissanceUtilisateur() {return dateNaissanceUtilisateur;}
	public boolean isGestionnaire() {return gestionnaire;}
	public boolean isAdministrateur() {return administrateur;}



	public static void main(String[] args) {
		
	}

}
