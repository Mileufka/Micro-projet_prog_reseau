package serveur;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;

public class ServeurEcoute{
	
	//Attributs
	private ServerSocketChannel ssc;			//Socket d'ecoute du serveur
	private ArrayList<Thread> service;
	private Selector sel;
	private SelectionKey key;
	private int id_thr;
	private static final int port=7878;
	
	//Constructeur
	public ServeurEcoute(){
		id_thr=0;
		try {
			ssc=ServerSocketChannel.open();					//Création du canal
			ssc.configureBlocking(false);					//Configuration de la socket en mode non-bloquant
			ssc.socket().bind(new InetSocketAddress(port));
			sel=Selector.open();							//Création du sélecteur
			key=ssc.register(sel,SelectionKey.OP_ACCEPT);	//Création de la clé de sélection
		} catch (IOException e){
			e.printStackTrace();
			System.err.println("Erreur creation ServerSocketChannel");
			System.exit(-1);
		}
		service=new ArrayList<Thread>();
	}
	
	//Méthodes
	public void init(){
		
	}
	
	public boolean connexionAcceptee(){
		boolean r=false;
		try {
			if(ssc.accept()!=null) r=true;
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Erreur connexion au client.");
			System.exit(-1);
		}
		return r;
	}
	
	
	public void nouvelleConnexion(Socket s){
		id_thr++;
		service.add(new Thread(new Service(s,port+id_thr)));
		service.get(id_thr-1).start();
	}
	
	public Selector getSelecteur(){
		return sel;
	}
	
	public void setKey(SelectionKey k){
		key=k;
	}
	
	public SelectionKey getKey(){
		return key;
	}
	
	public static int getPort(){
		return port;
	}

	public static void main(String[] args){
		ServeurEcoute se=new ServeurEcoute();
		java.util.Iterator<SelectionKey> keyIt=null;
		Socket sock;
		
		while(true){
			try {
				se.getSelecteur().select();
				keyIt=se.getSelecteur().selectedKeys().iterator();
				while(keyIt.hasNext()){
					se.setKey(keyIt.next());
					keyIt.remove();
					se.ssc=(ServerSocketChannel)se.key.channel();
					sock=se.ssc.socket().accept();
					se.nouvelleConnexion(sock);
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
}