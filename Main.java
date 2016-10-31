package projet;

/**
 * @author kevin
 *
 */
public class Main {
	static int nbColonnes;
	static int nbLignes;
	static String[] alphabet={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		nbColonnes=Integer.parseInt(args[0])+1;
		nbLignes=Integer.parseInt(args[1])+1;
		Joueur moi=new Joueur("kevin","00000001");
		GrilleMaker.afficherGrillePerso(moi);
		moi.getGrillePropre().getTabCase()[10][10].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][11].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][12].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][13].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][14].setEstUtilisee(true);
		GrilleMaker.afficherGrillePerso(moi);
		moi.getGrillePropre().getTabCase()[10][10].setEstDetruite(true);
		GrilleMaker.afficherGrillePerso(moi);
	
	}
}
