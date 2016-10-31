package projet;
/**
 * Cette classe est très importante. Elle permet l'affichage de la grille en mode console. Permet d'alléger le code dans la classe main.
 * @author kevin
 *
 */
public class GrilleMaker {
	/**
	 * Cette méthode se charge de l'affichage de la grille personnelle en mode console !
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
							if(i<=26){	
								System.out.print(Main.alphabet[i-1]+"  ");
							}
							else{
								int indice=(int) (i-0.1)/26;//petite triche pour avoir AZ puis BA et non BZ puis BA
								System.out.print(Main.alphabet[indice-1]);
								System.out.print(Main.alphabet[(i-1)%26]+" ");
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


