package model;

import java.util.Observable;

/**
 * Classe qui carctérise une grille de jeu. (chaque joueur en possède 2 devant lui)
 * @author kevin
 *
 */
public class GrilleJeuModel extends Observable{
	
	protected CaseModel[][] tabCase;
	/**
	 * Constructeur: Construit une grille contenant des Cases. La première ligne et la première colone etant des case d'entete.
	 * @param nbColonnes
	 * @param nbLignes
	 * 
	 */
	public GrilleJeuModel(int nbColonnes,int nbLignes){
		tabCase=new CaseModel[100][100];
		for(int i=0;i<nbLignes;i++){
			for(int j=0;j<nbColonnes;j++){	
				tabCase[i][j]=new CaseModel();
				
			}
		}
		
	}

	public CaseModel[][] getTabCase() {
		return tabCase;
	}

	public void setTabCase(CaseModel[][] tabCase) {
		this.tabCase = tabCase;
		setChanged();
		notifyObservers();
	}
	public void setEstUtilisee(boolean estUtilisee,int ligne,int colonne) {
		tabCase[ligne][colonne].setEstUtilisee(estUtilisee); 
		setChanged();
		notifyObservers();
		
	}
	public void setEstDetruite(boolean estDetruite,int ligne, int colonne){
		tabCase[ligne][colonne].setEstDetruite(estDetruite);
		setChanged();
		notifyObservers();
	}
	
	

}
