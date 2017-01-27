package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import serveur.ServeurEcoute;

public class Client {
	//Attributs
	private Socket sock;				//Socket de connexion au serveur
	private DataInputStream input;		//Donnees envoyees par le serveur
	private DataOutputStream output;	//Donnees a envoyer au serveur
	
	//Constructeur
	public Client(String addr){
		try {
			sock=new Socket(InetAddress.getByName(addr),ServeurEcoute.getPort());
			input = new DataInputStream(sock.getInputStream());
			output = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Methodes
	//Connexion avec le serveur
	public void connexion(String id,String mdp){
		try {
			output.writeChars(id);
			output.writeChars(mdp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Client c1=new Client("localhost");
		Client c2=new Client("localhost");
		Client c3=new Client("localhost");
		try {
			c1.output.write(5);
			c2.output.write(9);
			c3.output.write(17);
			System.out.println("Reception : "+c1.input.read());
			System.out.println("Reception : "+c2.input.read());
			System.out.println("Reception : "+c3.input.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
