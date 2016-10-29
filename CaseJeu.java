package projet;
/**
 * Cette classe définit une case qui constituera la grille principale du jeu
 * @author kevin
 *
 */
public class CaseJeu extends Case {
	//question: Si on définit ici estDetruite, on ne peut y acceder avec Case.estDetruite ?

	public CaseJeu(){
		super();
	}
	
	/**
	 * 
	 * @param coordonneeX
	 * @param coordonneeY
	 * @param positionX
	 * @param positionY
	 */
	public CaseJeu(int coordonneeX,int coordonneeY,int positionX,int positionY){
		
		super(coordonneeX,coordonneeY,positionX,positionY);
		super.estUtilisee=false;
		super.estDetruite=false;
		
	}
}


