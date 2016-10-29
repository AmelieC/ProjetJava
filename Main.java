package projet;

/**
 * @author kevin
 *
 */
public class Main {
	static int nbColonnes;
	static int nbLignes;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		nbColonnes=Integer.parseInt(args[0])+1;
		nbLignes=Integer.parseInt(args[1])+1;
		Joueur moi=new Joueur("kevin","00000001");
		Main.afficherGrillePerso(moi);
		moi.getGrillePropre().getTabCase()[10][10].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][11].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][12].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][13].setEstUtilisee(true);
		moi.getGrillePropre().getTabCase()[10][14].setEstUtilisee(true);
		Main.afficherGrillePerso(moi);
		moi.getGrillePropre().getTabCase()[10][10].setEstDetruite(true);
		Main.afficherGrillePerso(moi);
	
	}
	/**
	 * Cette méthode se charge de l'affichage de la grille du programme en mode console !
	 * Si une case non détruite ne possède aucun navire, on affichera #
	 * Si une case possède un navire, on affichera @
	 * Si une case détruie possède un navire, on affichera D
	 * Si une case détruite ne possède pas de navire, on affichera X
	 * @param joueur
	 */
	public static void afficherGrillePerso(Joueur joueur){
		for(int i=0;i<Main.nbLignes;i++){
			for(int j=0;j<Main.nbColonnes;j++){
				if(i==0){//première ligne
					if(j==0){
						System.out.print("   ");
					}
					else{
						if(j<10){
							System.out.print(j+"  ");
						}
						else{
							System.out.print(j+" ");
						}
					}	
				}
				else{
					if(j==0){
						if(i<10){
							System.out.print(i+"  ");
						}
						else{
							System.out.print(i+" ");
						}
					}
					else{
						if(!joueur.getGrillePropre().getTabCase()[i][j].isEstUtilisee()){
							System.out.print("#  ");
						}
						else if(joueur.getGrillePropre().getTabCase()[i][j].isEstUtilisee() && joueur.getGrillePropre().getTabCase()[i][j].isEstDetruite()){
							System.out.print("D  ");
						}
						else if(joueur.getGrillePropre().getTabCase()[i][j].isEstUtilisee()){
							System.out.print("@  ");
						}
						else if(!joueur.getGrillePropre().getTabCase()[i][j].isEstUtilisee() && joueur.getGrillePropre().getTabCase()[i][j].isEstDetruite()){
							System.out.print("X  ");
						}
					}	
				}
			}
			System.out.print("\n");
		}
	}
	public static void affichierGrilleCible(Joueur joueur){
		
	}
}
