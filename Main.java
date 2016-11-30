package default_package;

import java.util.ArrayList;
import java.util.Arrays;

import controller.BatailleController;
import model.GrilleJeuModel;
import model.JoueurModel;
import view.BatailleVue;
import view.BatailleVueConsole;

/**
 * @author kevin, @ameliecourtin
 *
 */
public class Main {
	static public int nbColonnes;
	static public int nbLignes;
	static public ArrayList<String> alphabet=new ArrayList(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main.nbColonnes=Integer.parseInt(args[0])+1;
		Main.nbLignes=Integer.parseInt(args[1])+1;
		
		GrilleJeuModel grilleA = new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
		GrilleJeuModel grilleB = new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
		
		
		JoueurModel joueurA = new JoueurModel("kevin","00000001");
		JoueurModel joueurB = new JoueurModel("amelie","00000002");
		
		joueurA.setGrilleJeu(grilleA);
		joueurB.setGrilleJeu(grilleB);
		
		BatailleController controllerConsole = new BatailleController(grilleA,joueurA);
		
		BatailleVue vueConsole=new BatailleVueConsole(grilleA,joueurA,controllerConsole);
		
		//JoueurModel lui=new JoueurModel("lui","00000002"); //ordinateur pour les tests
		
		/*System.out.println("Veuillez positionner vos navires.");
		System.out.println("Veuillez respecter les positions et les alignements !");
		System.out.println("Lorsque vous entrez une coordonnée, séparer la colonne de la ligne par un -");
		System.out.println("Bonne chance !");*/
		
	
	
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
