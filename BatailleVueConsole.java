package view;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.BatailleController;
import default_package.Main;
import model.GrilleJeuModel;
import model.JoueurModel;

public class BatailleVueConsole extends BatailleVue implements Observer {

	protected Scanner sc;

	
	public BatailleVueConsole(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,BatailleController controller) throws IOException {
		super(grilleJeuModel, joueurModel,grilleCible,controller);
		
		sc=new Scanner(System.in);
		runTest(); //on se passe de thread pour l'instant
		
	}

	@Override
	public void update(Observable o, Object arg) {
		controller.afficherGrilleCible();
		controller.afficherGrillePerso();
	}
	
	/*public void run(){
		while(true){
			int i=0;
			int j=0;
			
			while(j<6){//itération sur les bateaux
				while(i<joueurModel.getBateau()[j].getTaille()){ //il faut considérer les position erronées qui ne décrémentent pas la val
					
					System.out.println("Veuillez positionner:"+joueurModel.getBateau()[j].getNom()+"   (taille: "+joueurModel.getBateau()[j].getTaille()+")");
					String value=sc.nextLine(); //lien avec chat
					if(controller.positionner(value,j,i,joueurModel)){
						i++;
						
					}
					
					
				}
				i=0;
				j++;
				
			}
			break;
			
		}
		while(true){
			System.out.println("Veuillez selectionner une case");
			String value=sc.nextLine();
			
			controller.tirer(value);
			try{
				Thread.sleep(2000);
				}catch(InterruptedException e){
					e.getMessage();
				}
			controller.tirer(joueurModelB.tirAleatoire());
			
			
		}
	
	}*/
	/**
	 * Cette methode est le coeur du jeu.
	 * Elle prend et controle les entree de l utilisateur.
	 * @throws IOException
	 */

	public void runTest() throws IOException{
		int i = 0;
		int j = 0;
		/*On positionne les bateaux sur la grille*/
		
		while(i<6){
			while(j<joueurModel.getBateau()[i].getTaille()){
				System.out.println("Veuillez positionner:"+joueurModel.getBateau()[i].getNom()+"   (taille: "+joueurModel.getBateau()[i].getTaille()+")");
				String value=sc.nextLine(); //lien avec chat
				if(controller.positionner(value,j,i)){
					j++;
					System.out.println("test");
				}
			}
			j=0;
			i++;
			
		}
		
		if(Main.isServer){//permet de déterminer un logiciel prioritaire
			System.out.println("Tour de votre adversaire !");
			String msg = Main.chat.waitForMessage();
			System.out.println("Tir adverse: "+ msg);
			Main.chat.sendMessage(controller.verifierDegats(controller.decodeur(msg)));
			/*Si touché, renvoyer "TOUCHE" sinon renvoyer "RATE" (avec send)*/
		}
		while(true){
			System.out.println("Votre tour");
			System.out.println("Veuillez choisir votre cible: ");
			String msg = sc.nextLine(); //msg sera par exemple A-1
			if(msg.equals("STOP")){
				Main.chat.sendMessage("END");
				sc.close();
				System.exit(0);
			}
			Main.chat.sendMessage(msg); //on envoye la zone a toucher !
			String rep = Main.chat.waitForMessage(); //on attend confirmation (TOUCHE ou RATE)
			System.out.println(rep+ " !");
			
			System.out.println("Tour de votre adversaire !");
			msg = Main.chat.waitForMessage();
			System.out.println("Tir adverse: "+ msg);
			Main.chat.sendMessage(controller.verifierDegats(controller.decodeur(msg)));
			/*Si touche "TOUCHE" sinon "RATE" (avec send)*/ 
			
		}
	}
}
