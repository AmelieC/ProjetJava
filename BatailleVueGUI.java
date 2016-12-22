package view;

import java.util.Observable;

import controller.BatailleController;
import model.BateauModel;
import model.CaseModel;
import model.GrilleJeuModel;
import model.JoueurModel;

public abstract class BatailleVueGUI extends BatailleVue{

	public BatailleVueGUI(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,BatailleController controller) {
		super(grilleJeuModel, joueurModel,grilleCible,controller);
		// TODO Auto-generated constructor stub
	}
	

}
