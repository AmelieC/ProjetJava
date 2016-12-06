package default_package;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat {
	BufferedReader in; 
	PrintWriter outB;
	Socket socket;
	
	/*
	 * Constructeur.  Permet d'initialiser le chat en établissant la 
	 * connection avec un interlocuteur situé sur la même machine. 
	 * @param isServer : si true, l'instance est un serveur et se met en attente d'une connexion
	 * @port le numéro de port sur lequel établir la connexion
	 * @exception IOException s'il y a un problème pendant l'établissement de la connexion
	 */
	public Chat(boolean isServer, int port) throws IOException {
			connect(isServer, port, "10.99.0.87");
		
	}
	
	/*
	 * Envoie le messages msg à l'interlocuteur
	 * @param msg un message
	 */
	public void sendMessage(String msg) {
		outB.println(msg);
		
	}

	/*
	 * Attend le prochain message de l'interlocuteur
	 * @return le message reçu de l'interlocuteur
	 * @exception IO Exception en cas d'erreur de transmission
	 */
	public String waitForMessage() throws IOException {
		String str = in.readLine();
		if(str.equals("END")){
			System.out.println("Votre interlocuteur s'est déconnecté");
			
		}
        return str;
	}
	/*
	 * Permet l'établissement d'une connexion avec un hôte distant
	 * @param isServer : si true, l'instance est un serveur et se met en attente d'une connexion
	 * @port le numéro de port sur lequel établir la connexion
	 * @addr si isServer est false, addr contient l'adresse du serveur à contacter
	 * @exception IOException s'il y a un problème pendant l'établissement de la connexion
	 */
	public void connect(boolean isServer, int port, String addr) throws IOException{
		if(isServer){
			ServerSocket s = new ServerSocket(port);
			System.out.println("En attente de connexion...");
			socket = s.accept();
		}
		else{
			socket = new Socket(addr,port);
		}
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outB = new PrintWriter( new OutputStreamWriter(socket.getOutputStream()), true);
		
	}
	/*
	 * Ferme tous les flux d'une connexion établie.
	 * @exception IOException en cas d'erreur dans la fermeture de connexion
	 */
	public void closeConnection() throws IOException{
       in.close();
       outB.close();
	}

}



