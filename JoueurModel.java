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
	private int nbBateauEnnemiDetruit;
	private int nbBateauDetruit;
	private String identifiant;
	private BateauModel[] bateau;
	private GrilleJeuModel grilleJeu;
	private GrilleJeuModel grilleCible;
	private int indiceBateauAPositionner;
	private int caseBateauAPositioner;
	private boolean sonTour;

	/**
	 * 
	 * @param pseudo
	 * @param identifiant
	 * @param nbColonneGrille
	 * @param nbLignesGrille
	 */
	public JoueurModel(String pseudo,String identifiant){
		
		this.nbBateauEnnemiDetruit = 0;
		this.nbBateauDetruit = 0;
		this.pseudo=pseudo;
		this.identifiant=identifiant;
		this.indiceBateauAPositionner=0;
		this.caseBateauAPositioner=0;
		//this.grilleJeu = new GrilleJeuModel(Main.nbColonnes, Main.nbLignes);
	
		
		bateau=new BateauModel[6];
		bateau[0]=new BateauModel("Porte-avion",5);
		bateau[1]=new BateauModel("Croiseur",4);
		bateau[2]=new BateauModel("CuirasseA",3);
		bateau[3]=new BateauModel("CuirasseB",3);
		bateau[4]=new BateauModel("DestroyerA",2);
		bateau[5]=new BateauModel("DestroyerB",2);
		
		
	}

	

	public int getNbBateauEnnemiDetruit() {
		return nbBateauEnnemiDetruit;
	}



	public void setNbBateauEnnemiDetruit(int nbBateauEnnemiDetruit) {
		this.nbBateauEnnemiDetruit = nbBateauEnnemiDetruit;
	}



	public int getNbBateauDetruit() {
		return nbBateauDetruit;
	}



	public void setNbBateauDetruit(int nbBateauDetruit) {
		this.nbBateauDetruit = nbBateauDetruit;
	}



	public GrilleJeuModel getGrilleCible() {
		return grilleCible;
	}



	public void setGrilleCible(GrilleJeuModel grilleCible) {
		this.grilleCible = grilleCible;
	}



	public GrilleJeuModel getGrilleJeu() {
		return grilleJeu;
	}



	public void setGrilleJeu(GrilleJeuModel grilleJeu) {
		this.grilleJeu = grilleJeu;
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
	public int[] tirAleatoire(){
		int[] tab=new int[2];
		tab[0]=1+(int)(Math.random()*Main.nbLignes-1);
		tab[1]=1+(int)(Math.random()*Main.nbColonnes-1);
		
		return tab;
	}



	public int getIndiceBateauAPositionner() {
		return indiceBateauAPositionner;
	}



	public void setIndiceBateauAPositionner(int indiceBateauAPositionner) {
		this.indiceBateauAPositionner = indiceBateauAPositionner;
		setChanged();
		notifyObservers();
	}



	public int getCaseBateauAPositioner() {
		return caseBateauAPositioner;
		
	}



	public void setCaseBateauAPositioner(int caseBateauAPositioner) {
		this.caseBateauAPositioner = caseBateauAPositioner;
		setChanged();
		notifyObservers();
	}



	public boolean isSonTour() {
		return sonTour;
	}



	public void setSonTour(boolean sonTour) {
		this.sonTour = sonTour;
		setChanged();
		notifyObservers();
	}
	
	
}
