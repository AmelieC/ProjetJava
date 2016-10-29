package projet;
/**
 * Cette classe permet de créer toutes les cases du jeu. Une case possède une position dans la 
 * fenetre de l'aplication, mais aussi des coordonnées permetant de l'identifier.
 * @author kevin
 *
 */
abstract class Case {
	protected int coordonneeX;
	protected int coordonneeY;
	protected boolean estUtilisee;
	protected boolean estDetruite;
	
	/**
	 * 
	 * @param coordonneeX
	 * @param coordonneeY
	 * @param positionX
	 * @param positionY
	 */
	public Case(){
		
	}
	public Case(int coordonneeX,int coordonneeY,int positionX,int positionY){
		
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
	public boolean isEstUtilisee() {
		return estUtilisee;
	}
	public void setEstUtilisee(boolean estUtilisee) {
		this.estUtilisee = estUtilisee;
	}
	public boolean isEstDetruite() {
		return estDetruite;
	}
	public void setEstDetruite(boolean estDetruite) {
		this.estDetruite = estDetruite;
	}
	
	
}
