package projet;
/**
 * Cette classe caractérise un joueur. Chaque joueur possède 2 grilles de jeu.
 * @author kevin
 *
 */
public class Joueur {
	
	private String pseudo;
	private String identifiant;
	private Bateau[] bateau;
	private GrilleJeu grillePropre;
	private GrilleJeu grilleCible;
	private boolean estSonTour;
	/**
	 * 
	 * @param pseudo
	 * @param identifiant
	 * @param nbColonneGrille
	 * @param nbLignesGrille
	 */
	public Joueur(String pseudo,String identifiant){
		
		this.pseudo=pseudo;
		this.identifiant=identifiant;
	
		grillePropre=new GrillePropre(Main.nbColonnes, Main.nbLignes);
		grilleCible=new GrilleCible(Main.nbColonnes, Main.nbLignes);
		
		
	}

	public GrilleJeu getGrillePropre() {
		return grillePropre;
	}

	public void setGrillePropre(GrilleJeu grillePropre) {
		this.grillePropre = grillePropre;
	}

	public GrilleJeu getGrilleCible() {
		return grilleCible;
	}

	public void setGrilleCible(GrilleJeu grilleCible) {
		this.grilleCible = grilleCible;
	}

	public boolean isEstSonTour() {
		return estSonTour;
	}

	public void setEstSonTour(boolean estSonTour) {
		this.estSonTour = estSonTour;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Bateau[] getBateau() {
		return bateau;
	}

	public void setBateau(Bateau[] bateau) {
		this.bateau = bateau;
	}
	
	
}
