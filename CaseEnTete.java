package projet;
/**
 * Cette classe défini toutes les cases d'en tete du jeu.;
 * Ces cases sont situées sur la première ligne et la première colonne uniquement et contiennent un identifiant
 * @author kevin
 *
 */
public class CaseEnTete extends Case{
	
	String valeur;
	
	public CaseEnTete(){
		super();
	}
	public CaseEnTete(int coordonneeX,int coordonneeY,int positionX,int positionY,String valeur){
		
		super(coordonneeX,coordonneeY,positionX,positionY);
		this.valeur=valeur;
		
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	

}
