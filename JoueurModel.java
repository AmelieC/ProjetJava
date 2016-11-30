package model;

import java.util.Observable;

import default_package.Main;

/**
 * Cette classe caractérise un joueur. Chaque joueur possède 2 grilles de jeu.
 * @author kevin
 *
 */
public class JoueurModel extends Observable{
	
	private String pseudo;
	private String identifiant;
	private BateauModel[] bateau;
	private GrilleJeuModel grilleJeu;
	private boolean estSonTour;
	/**
	 * 
	 * @param pseudo
	 * @param identifiant
	 * @param nbColonneGrille
	 * @param nbLignesGrille
	 */
	public JoueurModel(String pseudo,String identifiant){
		
		this.pseudo=pseudo;
		this.identifiant=identifiant;
		//this.grilleJeu = new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
	
		
		bateau=new BateauModel[6];
		bateau[0]=new BateauModel("Porte-avion",5);
		bateau[1]=new BateauModel("Croiseur",4);
		bateau[2]=new BateauModel("CuirasseA",3);
		bateau[3]=new BateauModel("CuirasseB",3);
		bateau[4]=new BateauModel("DestroyerA",2);
		bateau[5]=new BateauModel("DestroyerB",2);
		
		
	}

	

	public GrilleJeuModel getGrilleJeu() {
		return grilleJeu;
	}



	public void setGrilleJeu(GrilleJeuModel grilleJeu) {
		this.grilleJeu = grilleJeu;
	}



	public boolean isEstSonTour() {
		return estSonTour;
	}

	public void setEstSonTour(boolean estSonTour) {
		this.estSonTour = estSonTour;
		setChanged();
		notifyObservers();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		setChanged();
		notifyObservers();
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
		setChanged();
		notifyObservers();
	}

	public BateauModel[] getBateau() {
		return bateau;
	}

	public void setBateau(BateauModel[] bateau) {
		this.bateau = bateau;
		setChanged();
		notifyObservers();
	}
	public String toString(){
		return pseudo+" "+identifiant;
	}
	
}
