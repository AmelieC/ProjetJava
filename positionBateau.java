package projet;

import java.util.Scanner;

public class PositionBateau {
	private static boolean verif=true;
	/**
	 * Cette méthode s'occupe du positionnement des navires du joueur sur la grille. 
	 * La méthode appelle la seconde méthode verifPosition pour s'assurer que la grille n'est ps déja utilisée par un autre navire. 
	 * @param joueur
	 */
	public static void positionner(Joueur joueur){
		System.out.println("Veuillez positionner: "+joueur.getBateau()[0].getNom());
		Scanner scan=new Scanner(System.in);
		String valeur;
		int i=0;
		while(i<6){ //Puisque nous avons 6 bateaux
			System.out.println("Veuillez positionner: "+joueur.getBateau()[i].getNom());
			int j=0;
			while(j<joueur.getBateau()[i].getTaille()){ //itération sur la taille du bateau
				valeur=scan.next();
				int [] position=GrilleMaker.decodeur(valeur);
				while(!verifPosition(position,joueur) || !verifAlignement(position,joueur.getBateau()[i],j)){ //on vérifie l'alignement et position du bateau
					System.out.println("entrée invalide: Case déjà occupée ! ");
					valeur=scan.next();
					position=GrilleMaker.decodeur(valeur);
				}
			j++;
			}
		i++;
		}
	}
	/**
	 * Cette méthode vérifie qu'une case n'est pas déjà occupée par un navire
	 * Retourne true si la case est vide, false sinon.
	 * @param position
	 * @param joueur
	 * @return
	 */
	public static boolean verifPosition(int [] position, Joueur joueur){
		int i=1;
		int j=1;
		while(i<Main.nbLignes+1){
			while(j<Main.nbColonnes+1){
				if(joueur.getGrillePropre().getTabCase()[position[0]][position[1]].isEstUtilisee()){
					return false;
				}
				else{
					j++;
				}	
			}
			i++;
		}
		return true;
	}
	/**
	 * Vérifie l'alignement d'un bateau dans la grille. 
	 * Retourne true si alignement respecté. false sinon
	 * @param position
	 * @param joueur
	 * @return
	 */
	public static boolean verifAlignement(int [] position, Bateau bateau,int j){
		if(j==0){
			return true;
		}
		for(CaseJeu cases: bateau.getPosition()){
			
		}
		
	}
}
