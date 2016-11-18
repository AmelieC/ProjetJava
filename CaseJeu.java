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
	 */
	public CaseJeu(int coordonneeX,int coordonneeY){
		
		super(coordonneeX,coordonneeY);
		super.estUtilisee=false;
		super.estDetruite=false;
		
	}
}


