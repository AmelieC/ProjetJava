package model;

import java.util.Observable;

/**
 * Cette classe détermine toutes les caractéristiques d'un bateau.
 * @author kevin
 *
 */
public class BateauModel extends Observable {
	

	private String nom;
	private int taille;
	private CaseModel[] position;
	private boolean estDetruit;
	
	/**
	 * Constructeur:
	 * @param nom
	 * @param taille
	 * @param position
	 */
	public BateauModel(String nom,int taille,CaseModel[] position){
		
		this.nom=nom;
		this.taille=taille;
		this.position=position;
		for(CaseModel a:position){
			a.setEstUtilisee(true);
		}
		this.estDetruit=false;
	
	}
	/**
	 * Constructeur:
	 * @param nom
	 * @param taille
	 */
	public BateauModel(String nom,int taille){
			position=new CaseModel[taille];
			this.nom=nom;
			this.taille=taille;
			this.estDetruit=false;
			
		}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
		setChanged();
		notifyObservers();
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
		setChanged();
		notifyObservers();
	}
	public CaseModel[] getPosition() {
		return position;
	}
	public void setPosition(CaseModel[] position) {
		this.position = position;
		for(CaseModel a:position){
			a.setEstUtilisee(true);
		}
		setChanged();
		notifyObservers();
	}
	public void setPositionToIndex(CaseModel position,int i){
		this.position[i]=position;
		setChanged();
		notifyObservers();
	}
	public boolean isEstDetruit() {
		return estDetruit;
	}
	public void setEstDetruit(boolean estDetruit) {
		this.estDetruit = estDetruit;
		setChanged();
		notifyObservers();
	}
	
	
}
