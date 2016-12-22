package view;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.BatailleController;
import default_package.Main;
import model.GrilleJeuModel;
import model.JoueurModel;

public class BatailleVueConsole extends BatailleVue implements Observer{

	protected Scanner sc;
	protected String value;
	protected Thread thread = null;

	
	public BatailleVueConsole(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,BatailleController controller) throws IOException {
		super(grilleJeuModel, joueurModel,grilleCible,controller);
		sc=new Scanner(System.in);
		value = new String();
		runTest();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		controller.afficherGrilleCible();
		controller.afficherGrillePerso();
		if(joueurModel.getIndiceBateauAPositionner()<6){
			System.out.println("Veuillez positionner:"+joueurModel.getBateau()[joueurModel.getIndiceBateauAPositionner()].getNom()+"   (taille: "+joueurModel.getBateau()[joueurModel.getIndiceBateauAPositionner()].getTaille()+")");
			
		}
		if(Main.finJeu){
			if(joueurModel.getNbBateauDetruit() == 6){
				System.out.println("VOUS AVEZ PERDU....");	
				
			}
			else{
				System.out.println("VOUS AVEZ GAGNE....");	
			}
		}	
		else{
			if(joueurModel.isSonTour()){
				
				System.out.println("Veuillez selectionner votre cible !");
			}
			else{
				System.out.println("Veuillez attendre votre tour !");
			}
		}
	}
	
	/**
	 * Cette methode est le coeur du jeu.
	 * Elle prend et controle les entree de l utilisateur.
	 * @throws IOException
	 */

	public void runTest() throws IOException{
		/*On positionne les bateaux sur la grille*/
		System.out.println("Veuillez positionner:"+joueurModel.getBateau()[joueurModel.getIndiceBateauAPositionner()].getNom()+"   (taille: "+joueurModel.getBateau()[joueurModel.getIndiceBateauAPositionner()].getTaille()+")");
		while(joueurModel.getIndiceBateauAPositionner()<6){
			while(joueurModel.getCaseBateauAPositioner()<joueurModel.getBateau()[joueurModel.getIndiceBateauAPositionner()].getTaille()){
				value = sc.nextLine();
				controller.positionner(value,joueurModel.getCaseBateauAPositioner(),joueurModel.getIndiceBateauAPositionner());
				if(joueurModel.getIndiceBateauAPositionner()==6){
					break;
				}
			}
		}
		System.out.println("Tous les bateaux sont positionnés.");
		
		if(Main.isServer){//permet de déterminer un logiciel prioritaire
			controller.attendreTirAdverse();
			
		}
		while(true){
			String msg = sc.nextLine(); //msg sera par exemple A-1
			controller.tirer(msg);
			controller.attendreTirAdverse();
			
			
			
		}
	}
	
}
