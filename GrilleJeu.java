package projet;
/**
 * Classe qui carctérise une grille de jeu. (chaque joueur en possède 2 devant lui)
 * @author kevin
 *
 */
abstract class GrilleJeu {
	
	protected Case[][] tabCase;
	/**
	 * Constructeur: Construit une grille contenant des Cases. La première ligne et la première colone etant des case d'entete.
	 * @param nbColonnes
	 * @param nbLignes
	 * 
	 */
	public GrilleJeu(int nbColonnes,int nbLignes){
		tabCase=new Case[100][100];
		for(int i=0;i<nbLignes;i++){
			for(int j=0;j<nbColonnes;j++){
				if(i==0){
					tabCase[i][j]=new CaseEnTete();
				}
				else{
					if(j==0){
						tabCase[i][j]=new CaseEnTete();
					}
					else{
						tabCase[i][j]=new CaseJeu();
					}
				}
				
			}
		}
		
	}

	public Case[][] getTabCase() {
		return tabCase;
	}

	public void setTabCase(Case[][] tabCase) {
		this.tabCase = tabCase;
	}
	

}
