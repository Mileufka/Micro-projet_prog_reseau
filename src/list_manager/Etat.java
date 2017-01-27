package list_manager;

public enum Etat {
	BLOQUE((byte)0),
	BACKLOG((byte)1),
	PRET((byte)2),
	EN_COURS((byte)3),
	A_VALIDER((byte)4),
	FAIT((byte)5);
	
	//Attribut
	private byte val;
	
	//Constructeur
	Etat(byte val){
		this.val=val;
	}
	
	//Getter d'Etat, permet d'obtenir l'etat de la tache
	public byte getVal(){
		return val;
	}
	
	public String getEtat(){
		
		String r=new String();					//Chaine de caractere a retourner
		
		switch(this){
			case BLOQUE:r="Bloque";
			case BACKLOG:r="Backlog";
			case PRET:r="Pret";
			case EN_COURS:r="En cours";
			case A_VALIDER:r="A valider";
			case FAIT:r="Fait";
		}
		
		return r;
	}
	
	//Setter d'Etat, permet de modifier l'etat de la tache
	public void setVal(byte val){
		this.val=val;
	}
}
