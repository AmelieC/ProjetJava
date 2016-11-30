package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.BatailleController;
import model.BateauModel;
import model.CaseModel;
import model.GrilleJeuModel;
import model.JoueurModel;

public class BatailleVueConsole extends BatailleVue implements Observer {

	protected Scanner sc;

	
	public BatailleVueConsole(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,BatailleController controller) {
		super(grilleJeuModel, joueurModel,controller);
		
		sc=new Scanner(System.in);
		run(); //on se passe de thread pour l'instant
		
	}

	@Override
	public void update(Observable o, Object arg) {
		controller.afficherGrillePerso();
		//controller.afficherGrillePerso();
		
	}
	public void run(){
		while(true){
			System.out.println("Veuillez entrer une valeur svp");
			String value=sc.nextLine();
			controller.positionner(value);
			
		}
	}

}
