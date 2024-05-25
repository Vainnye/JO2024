package modeles;

public class Compte {
	
	//----------------------------------------------------
    //---------ATTRIBUTS------------------------------------
    //----------------------------------------------------
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
	
	
	//----------------------------------------------------
    //---------CONSTRUCTEUR------------------------------------
    //----------------------------------------------------
	public Compte(int numCompte, String nomUtilisateur, String prenomUtilisateur, String addressMailUtilisateur,
			String telephoneUtilisateur, String apparence, boolean autorisationLocalisation,
			boolean autorisationNotification, String dateNaissanceUtilisateur, boolean gestionnaire,
			boolean administrateur) 
	{
		super();
		this.numCompte = numCompte;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.addressMailUtilisateur = addressMailUtilisateur;
		this.telephoneUtilisateur = telephoneUtilisateur;
		Apparence = apparence;
		this.autorisationLocalisation = autorisationLocalisation;
		this.autorisationNotification = autorisationNotification;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.gestionnaire = gestionnaire;
		this.administrateur = administrateur;
	}
	
	//----------------------------------------------------
    //---------TO_STRING------------------------------------
    //----------------------------------------------------
	@Override
	public String toString() {
		String notification;
		String localisation;
		String gestionnaireA;
		String administrateurA;
		if(autorisationNotification)notification="oui";
		else notification="non";
		if(autorisationLocalisation)localisation="oui";
		else localisation="non";
		if(gestionnaire)gestionnaireA="oui";
		else gestionnaireA="non";
		if(administrateur)administrateurA="oui";
		else administrateurA="non";
		
		return "Compte [numCompte=" + numCompte + ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur="
				+ prenomUtilisateur + ", addressMailUtilisateur=" + addressMailUtilisateur + ", telephoneUtilisateur="
				+ telephoneUtilisateur + ", Apparence=" + Apparence + ", autorisationLocalisation="
				+ localisation + ", autorisationNotification=" + notification
				+ ", dateNaissanceUtilisateur=" + dateNaissanceUtilisateur + ", gestionnaire=" + gestionnaireA
				+ ", administrateur=" + administrateurA + "]";
	}
	
	
	//----------------------------------------------------
    //---------METHODES PUBLIQUES------------------------------------
    //----------------------------------------------------
	public void changeLocalisation() {
		if (autorisationLocalisation)
			autorisationLocalisation=false;
		else
			autorisationLocalisation=true;
	}
	
	public void changeNotification() {
		if (autorisationNotification)
			autorisationNotification=false;
		else
			autorisationNotification=true;
	}


	public static void main(String[] args) {
		
	}
	

}
