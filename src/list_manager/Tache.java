package list_manager;

import java.util.Date;

public class Tache {
	//Attributs
	private String nom;						//Nom de la tache
	private String description;				//Description plus en detail de la tache
	private String attributeur;				//Nom/Id de l'utilisateur ayant attribue la tache
	private Date dateEntree;				//Date de creation de la tache
	private byte etatCourant;
	private static Etat etat;
	
	//Constructeurs
	//Constructeur par defaut
	public Tache(){
		nom=null;
		description=null;
		dateEntree=null;
	}
	
	//Constructeur prenant le nom et la description d'une nouvelle tache
	//Met automatiquement la tache a l'etat BACKLOG
	public Tache(String nom,String description){
		this.nom=nom;
		this.description=description;
		dateEntree=new Date(System.currentTimeMillis());
		etat.setVal((byte)1);
	}
}
