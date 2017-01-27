package serveur;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import list_manager.Utilisateur;

public class Service implements Runnable{
	//Attributs
	private Socket sock;					//Socket de connexion avec le client
	private DataInputStream input;			//Donnees envoyees par le client
	private DataOutputStream output;		//Donnees a envoyer au client
	private Utilisateur u;
	private boolean connecte;
	
	//Constructeur
	public Service(Socket sock,int port){
		this.sock=sock;
		u=new Utilisateur();
		connecte=false;
		try {
			input = new DataInputStream(sock.getInputStream());
			output = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	//Méthodes
	public void connexion(){
		if(connecte==false){						//Vérifie si l'utilisateur n'est pas déjà connecté
			try {
				u.setId(input.readUTF());			//Récupération de l'identifiant
				u.setMdp(input.readUTF());			//Récupération du mot de passe
			} catch (IOException e) {
				e.printStackTrace();
			};
			
			//Vérification dans les fichiers XML
		}
	}
	
	public void deconnexion(){
		
	}

	@Override
	//Thread de traitement du client
	public void run() {
		byte b;
		try {
			b=input.readByte();
			output.writeByte(b+1);
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
