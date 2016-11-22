package projet;
/**
 * Cette classe permet de créer toutes les cases du jeu. Une case possède une position dans la 
 * fenetre de l'aplication, mais aussi des coordonnées permetant de l'identifier.
 * @author kevin
 *
 */
public class Case {
	protected int coordonneeX;
	protected int coordonneeY;
	protected boolean estUtilisee = false;
	protected boolean estDetruite = false;
	protected Bateau bateau;
	
	/**
	 * 
	 * @param coordonneeX
	 * @param coordonneeY
	 */
	public Case(){
		
	}
	public Case(int coordonneeX,int coordonneeY){
		
		this.coordonneeX=coordonneeX;
		this.coordonneeY=coordonneeY;
		
	}

	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}
	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}
	public boolean estUtilisee() {
		return estUtilisee;
	}
	public void setEstUtilisee(boolean estUtilisee) {
		this.estUtilisee = estUtilisee;
	}
	public boolean estDetruite() {
		return estDetruite;
	}
	public void setEstDetruite(boolean estDetruite) {
		this.estDetruite = estDetruite;
	}
	
	public Bateau getBateau () {
		return bateau;
	}
	
	public void setBateau (Bateau bateau){
		this.bateau = bateau;
	}
		
}
