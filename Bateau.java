package projet;
/**
 * Cette classe détermine toutes les caractéristiques d'un bateau.
 * @author kevin
 *
 */
public class Bateau {
	
	private String nom;
	private int taille;
	private CaseJeu[] position;
	private boolean estDetruit;
	
	/**
	 * Constructeur:
	 * @param nom
	 * @param taille
	 * @param position
	 */
	public Bateau(String nom,int taille,CaseJeu[] position){
		
		this.nom=nom;
		this.taille=taille;
		this.position=position;
		for(CaseJeu a:position){
			a.setEstUtilisee(true);
		}
		this.estDetruit=false;
	
	}
	/**
	 * Constructeur:
	 * @param nom
	 * @param taille
	 */
	public Bateau(String nom,int taille){
			
			this.nom=nom;
			this.taille=taille;
			this.estDetruit=false;
			
		}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public CaseJeu[] getPosition() {
		return position;
	}
	
	public void setPosition(CaseJeu[] position) {
		this.position = position;
		for(CaseJeu a:position){
			a.setEstUtilisee(true);
		}
	}
	
	
}
