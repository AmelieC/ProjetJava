package default_package;

import java.awt.Cursor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import controller.BatailleController;
import model.GrilleJeuModel;
import model.JoueurModel;
import view.BatailleGUICible;
import view.BatailleGUIPropre;
import view.BatailleVue;
import view.BatailleVueConsole;

/**
 * @author kevin, @ameliecourtin
 *
 */
public class Main extends Thread {
	
	public static boolean finJeu = false;
	public static boolean isServer;
	public static Chat chat;
	static public int nbColonnes;
	static public int nbLignes;
	static public ArrayList<String> alphabet=new ArrayList(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		JoueurModel joueurA = new JoueurModel("kevin","00000001");
		Scanner scan =new Scanner(System.in);
		int port;
		Main.nbColonnes=Integer.parseInt(args[1])+1;
		Main.nbLignes=Integer.parseInt(args[2])+1;
		Main.isServer = (args[0].equals("true")? true : false);
		
		if(isServer){
			joueurA.setSonTour(false);
		}
		else{
			joueurA.setSonTour(true);
		}
		
		System.out.println("Veuillez indiquer l'adresse IP de votre adversaire: ");
		String ip = scan.nextLine();
		System.out.println("Veuillez indiquer le port d'acces:");
		port=Integer.parseInt(scan.nextLine());
		chat = new Chat(isServer, 12354,ip);
		
		if(args[3].equals("song")){
			try {
				
				Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		        Main.class.getResourceAsStream("Kubbi_-_Cascade.wav")); //déplacer le fichier dans un autre package
		        clip.open(inputStream);
		        clip.start(); 
		        
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		    }
		}
		else if(args[3].equals("nosong")){
			System.out.println("Musique desactivee.");
		}
		
		GrilleJeuModel grilleA = new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
		GrilleJeuModel grilleCible =new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
		
		
		
		joueurA.setGrilleJeu(grilleA);
		joueurA.setGrilleCible(grilleCible);
		
		BatailleController controllerConsole = new BatailleController(grilleA,joueurA,grilleCible);
		BatailleController controllerGUIPropre = new BatailleController(grilleA,joueurA,grilleCible);
		BatailleController controllerGUICible = new BatailleController(grilleA,joueurA,grilleCible);
		
		System.out.println("Bienvenue sur Pacific's mysteries !");
		System.out.println("Pour entrer une coordonée, veuillez suivre la forme (A-1) ou (AA-1) !");
		System.out.println("C'est important, si vous ne faites pas attention vous pourriez perdre votre flotte dans les eaux sombres du pacifique...\n");
		
		System.out.println("La première partie du jeu consiste à positionner vos navires sur la grille");
		System.out.println("Il est important de respecter un alignement horizontal ou vertical ! De plus les navires ne doivent en aucun cas se chevaucher !");
		System.out.println("Que le meilleur gagne !");
		System.out.println("(Vous pouvez quitter a tout moment en ecrivant STOP.)");
		
		
		BatailleVue vuePropre = new BatailleGUIPropre(grilleA,joueurA,grilleCible,controllerConsole);
		BatailleVue vueCible = new BatailleGUICible(grilleA,joueurA,grilleCible,controllerConsole);
		
		vuePropre.setVisible(true);
		vuePropre.setTitle("Pacific's Mysteries");
		vuePropre.setResizable(false);
		vuePropre.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		vueCible.setVisible(true);
		vueCible.setTitle("Pacific's Mysteries");
		vueCible.setResizable(false);
		vueCible.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		
		BatailleVue vueConsole=new BatailleVueConsole(grilleA,joueurA,grilleCible,controllerConsole);
		
	
	}
	
	public static int getNbColonnes() {
		return nbColonnes;
	}
	public static void setNbColonnes(int nbColonnes) {
		Main.nbColonnes = nbColonnes;
	}
	public static int getNbLignes() {
		return nbLignes;
	}
	public static void setNbLignes(int nbLignes) {
		Main.nbLignes = nbLignes;
	}
	public static ArrayList<String> getAlphabet() {
		return alphabet;
	}
	public static void setAlphabet(ArrayList<String> alphabet) {
		Main.alphabet = alphabet;
	}
	
}
