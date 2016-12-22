package model;

import java.util.Observable;

/**
 * Cette classe permet de créer toutes les cases du jeu. Une case possède une position dans la 
 * fenetre de l'aplication, mais aussi des coordonnées permetant de l'identifier.
 * @author kevin
 *
 */
public class CaseModel extends Observable {
	protected int coordonneeX;
	protected int coordonneeY;
	protected boolean estUtilisee;
	protected boolean estDetruite;
	protected BateauModel bateau;
	
	/**
	 * 
	 * @param coordonneeX
	 * @param coordonneeY
	 * @param positionX
	 * @param positionY
	 */
	public CaseModel(){
		
	}
	public CaseModel(int coordonneeX,int coordonneeY,int positionX,int positionY){
		
		this.coordonneeX=coordonneeX;
		this.coordonneeY=coordonneeY;
		this.estUtilisee = false;
		this.estDetruite = false;
		
	}

	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
		setChanged();
		notifyObservers();
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}
	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
		setChanged();
		notifyObservers();
	}
	public boolean isEstUtilisee() {
		return estUtilisee;
	}
	public void setEstUtilisee(boolean estUtilisee) {
		this.estUtilisee = estUtilisee;
		setChanged();
		notifyObservers();
	}
	public boolean isEstDetruite() {
		return estDetruite;
	
	}
	public void setEstDetruite(boolean estDetruite) {
		this.estDetruite = estDetruite;
		setChanged();
		notifyObservers();
		
	}
	public BateauModel getBateau() {
		return bateau;
	}
	public void setBateau(BateauModel bateau) {
		this.bateau = bateau;
		
	}
	
	
}
