package controller;

import default_package.Main;
import model.BateauModel;
import model.CaseModel;
import model.GrilleJeuModel;
import model.JoueurModel;
import view.BatailleVue;

public class BatailleController {

	private GrilleJeuModel	grilleJeuModel;
	private GrilleJeuModel grilleCible;
	private JoueurModel joueurModel;
	
	private BatailleVue view = null;

	public BatailleController(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible){
		
		this.grilleJeuModel = grilleJeuModel;
		this.joueurModel = joueurModel;
		this.grilleCible = grilleCible;
	}
	/**
	 * Cette méthode positionne les navires du joueur lorsque celui-ci entre des coordonées
	 * @param valeur
	 */
	public boolean positionner(String valeur,int indiceBateau,int nbBateau){
		int [] resultat;
		resultat = decodeur(valeur);
		if(!verifPosition(resultat)){
			System.out.println("Case deja occupee");
			return false;
		}
		
		else{
			joueurModel.getGrilleJeu().setEstUtilisee(true,resultat[0], resultat[1]);
			joueurModel.getGrilleJeu().getTabCase()[resultat[0]][resultat[0]].setBateau(joueurModel.getBateau()[nbBateau]);
			//afficherGrillePerso();
			joueurModel.getBateau()[nbBateau].setPositionToIndex(joueurModel.getGrilleJeu().getTabCase()[resultat[0]][resultat[1]], indiceBateau);
			return true;
			//if(joueurModel.getBateau()[nbBateau].getTaille()==indiceBateau)
		}
	}
	/**
	 * Cette methode controle si l'entree de l'utilisateur adverse touche un bateau ou non.
	 * Elle met à jour les modeles en conséquence.
	 * @param valeurs
	 * @return TOUCHE si la case était occupée par un navire. RATE sinon.
	 */
	public String verifierDegats(int [] valeurs){
		if(joueurModel.getGrilleJeu().getTabCase()[valeurs[0]][valeurs[1]].isEstUtilisee()){
			joueurModel.getGrilleJeu().getTabCase()[valeurs[0]][valeurs[1]].setEstDetruite(true);
			return "TOUCHE";
			
		}
		else{
			joueurModel.getGrilleJeu().getTabCase()[valeurs[0]][valeurs[1]].setEstDetruite(true);
			return "RATE";
		}
	}
	
	public void addView(BatailleVue view){
		this.view=view;
	}
	
	/**
	 * Cette méthode vérifie qu'une case n'est pas déjà occupée par un navire
	 * Retourne true si la case est vide, false sinon.
	 * @param position
	 * @param joueur
	 * @return
	 */
	public boolean verifPosition(int [] position){
		int i=1;
		int j=1;
		while(i<Main.nbLignes+1){
			while(j<Main.nbColonnes+1){
				if(joueurModel.getGrilleJeu().getTabCase()[position[0]][position[1]].isEstUtilisee()){
					return false;
				}
				else{
					j++;
				}	
			}
			i++;
		}
		return true;
	}
	public void updateGrilleCible(String rep,String msg){
		int [] resultat;
		resultat = decodeur(msg);
		if(rep.equals("TOUCHE")){ //veut dire que l'on a touche !
			joueurModel.getGrilleCible().getTabCase()[resultat[0]][resultat[1]].setEstUtilisee(true);
			joueurModel.getGrilleCible().getTabCase()[resultat[0]][resultat[1]].setEstDetruite(true);
		}
		else{
			joueurModel.getGrilleCible().getTabCase()[resultat[0]][resultat[1]].setEstUtilisee(false);
			joueurModel.getGrilleCible().getTabCase()[resultat[0]][resultat[1]].setEstDetruite(true);
		}
	}
	
	
	
	
	/**
	 * Transforme une entrée utilisateur (par exemple A-5) en indice pour le tableau à 2 dimensions
	 * Distinction entre (A-8) et (BC-4) par exemple.
	 * @param entree
	 */
	public int[] decodeur(String entree){
		String tab[]=new String [2];
		int Resultat[]= new int[2];
		
		tab=entree.split("-");
		Resultat[1]=Integer.parseInt(tab[1]);
		if(tab[0].length()==1){//exemple (A-10)
			for(String lettre:Main.alphabet){
				if(lettre.equals(tab[0])){
					Resultat[0]=Main.alphabet.indexOf(lettre)+1;
				}
			}
		}
		else{
			for(String let:Main.alphabet){
				if(let.equals(Character.toString(tab[0].charAt(0)))){
					Resultat[0]=(Main.alphabet.indexOf(let)+1)*26;
					System.out.println(let);
				}
				
			}
			for(String let:Main.alphabet){
				if(let.equals(Character.toString(tab[0].charAt(1)))){
					Resultat[0]+=(Main.alphabet.indexOf(let)+1);
					System.out.println(let);
				}
			}
			
		}
		return Resultat;
		
	}
	public void afficherGrillePerso(){
		for(int i=0;i<Main.nbLignes;i++){
			for(int j=0;j<Main.nbColonnes;j++){
				if(i==0){//première ligne
					if(j==0){
						System.out.print("   ");
					}
					else{
						if(j<10){
							System.out.print(j+"  ");
						}
						else{
							System.out.print(j+" ");
						}
					}	
				}
				else{
					if(j==0){
						if(i<=26){	
							System.out.print(Main.alphabet.get(i-1)+"  ");
						}
						else{
							int indice=(int) (i-0.1)/26;//petite triche pour avoir AZ puis BA et non BZ puis BA
							System.out.print(Main.alphabet.get(indice-1));
							System.out.print(Main.alphabet.get((i-1)%26)+" ");
						}
					}
					else{
						if(!joueurModel.getGrilleJeu().getTabCase()[i][j].isEstUtilisee() && !joueurModel.getGrilleJeu().getTabCase()[i][j].isEstDetruite()){
							System.out.print("~  ");
						}
						else if(joueurModel.getGrilleJeu().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleJeu().getTabCase()[i][j].isEstDetruite()){
							System.out.print("T  ");
						}
						else if(joueurModel.getGrilleJeu().getTabCase()[i][j].isEstUtilisee()){
							System.out.print("@  ");
						}
						else if(!joueurModel.getGrilleJeu().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleJeu().getTabCase()[i][j].isEstDetruite()){
							System.out.print("X  ");
						}
					}	
				}
			}
			System.out.print("\n");
		}
	}
/**
 * Cette méthode se charge de l'affichage de la grille cible en mode console !
 * Si une case non détruite ne possède aucun navire, on affichera #
 * Si une case possède un navire, on affichera # (doit etre caché)
 * Si une case détruie possède un navire, on affichera D
 * Si une case détruite ne possède pas de navire, on affichera X
 * @param joueur
 */
public void afficherGrilleCible(){
	for(int i=0;i<Main.nbLignes;i++){
		for(int j=0;j<Main.nbColonnes;j++){
			if(i==0){//première ligne
				if(j==0){
					System.out.print("   ");
				}
				else{
					if(j<10){
						System.out.print(j+"  ");
					}
					else{
						System.out.print(j+" ");
					}
				}	
			}
			else{
				if(j==0){
					if(i<=26){	
						System.out.print(Main.alphabet.get(i-1)+"  ");
					}
					else{
						int indice=(int) (i-0.1)/26;//petite triche pour avoir AZ puis BA et non BZ puis BA
						System.out.print(Main.alphabet.get(indice-1));
						System.out.print(Main.alphabet.get((i-1)%26)+" ");
					}
				}
				else{
					if(!joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee() && !joueurModel.getGrilleCible().getTabCase()[i][j].isEstDetruite()){
						System.out.print("~  ");
					}
					else if(joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleCible().getTabCase()[i][j].isEstDetruite()){
						System.out.print("T  ");
					}
					else if(joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee()){
						System.out.print("~  "); //Le joueur ne peut pas voir la posision de navires ennemis 
					}
					else if(!joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleCible().getTabCase()[i][j].isEstDetruite()){
						System.out.print("X  ");
					}
				}	
			}
		}
		System.out.print("\n");
	}
}
public static void positionOrdinateur(JoueurModel joueur){
	double vertOrHori;
	int caseInitX;
	int caseInitY;
	int i=0;
	int j=0;
	while(i<6){
		vertOrHori=Math.random();
		caseInitX=1+(int)(Math.random()*Main.nbColonnes-1);
		caseInitY=1+(int)(Math.random()*Main.nbLignes-1);
		while(j<joueur.getBateau()[i].getTaille()){
			if(j==0){
				joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY].setEstUtilisee(true);
				joueur.getBateau()[i].setPositionToIndex(joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY], j);
			}
			else{
				if(vertOrHori<0.5){ //on positionne verticalement
					if(caseInitY<joueur.getBateau()[i].getTaille()){ //positionnement descendant
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j].setEstUtilisee(true);
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j].setBateau(joueur.getBateau()[i]);
						joueur.getBateau()[i].setPositionToIndex(joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j], j);
					}
					else{//positionnement montant
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY-j].setEstUtilisee(true);
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j].setBateau(joueur.getBateau()[i]);
						joueur.getBateau()[i].setPositionToIndex(joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY-j], j);
					}
				}
				else{ //on position horizontalement
					if(caseInitX<joueur.getBateau()[i].getTaille()){ //positionnement vers la droite
						joueur.getGrilleJeu().getTabCase()[caseInitX+j][caseInitY].setEstUtilisee(true);
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j].setBateau(joueur.getBateau()[i]);
						joueur.getBateau()[i].setPositionToIndex(joueur.getGrilleJeu().getTabCase()[caseInitX+j][caseInitY], j);
					}
					else{//positionnement vers la gauche
						joueur.getGrilleJeu().getTabCase()[caseInitX-j][caseInitY].setEstUtilisee(true);
						joueur.getGrilleJeu().getTabCase()[caseInitX][caseInitY+j].setBateau(joueur.getBateau()[i]);
						joueur.getBateau()[i].setPositionToIndex(joueur.getGrilleJeu().getTabCase()[caseInitX-j][caseInitY], j);
					}
				}
			}
			j++;
		}
		j=0;
		i++;
	}
}
	
}

