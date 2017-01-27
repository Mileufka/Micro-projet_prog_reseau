package list_manager;

import java.util.ArrayList;

public class Utilisateur {
	//Attributs
	private String id;							//Identifiant de l'utilisateur
	private String mdp;							//Mot de passe de l'utilisateur
	private ArrayList<Tache> tachesAttr;		//Liste de taches attribuees a l'utilisateur
	
	//Constructeurs
	//Constructeur par defaut
	public Utilisateur(){
		id=null;
		mdp=null;
		tachesAttr=null;
	}
	
	//Constructeur prenant un id et un mot de passe
	//Initialise une liste de tache vide
	public Utilisateur(String id,String mdp){
		this.id=id;
		this.mdp=mdp;
		this.tachesAttr=new ArrayList<Tache>();
	}
	
	//Constructeur de copie
	public Utilisateur(String id,String mdp,ArrayList<Tache> tachesAttr){
		this.id=id;
		this.mdp=mdp;
		this.tachesAttr=new ArrayList<Tache>();
		this.tachesAttr=tachesAttr;
	}
	
	//Methodes
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String getMdp(){
		return mdp;
	}
	
	public void setMdp(String mdp){
		this.mdp=mdp;
	}
	
	public ArrayList<Tache> getListeTaches(){
		return tachesAttr;
	}
	
	//Ajoute une tache a l'utilisateur courant
	public void ajouterTache(Tache t){
		tachesAttr.add(t);
	}
	
	//Ajoute une tache a un autre utilisateur
	public void ajouterTache(Tache t,Utilisateur u){
		u.ajouterTache(t);
	}
}
