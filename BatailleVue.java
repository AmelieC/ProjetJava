package view;

import java.util.Observer;

import controller.BatailleController;
import default_package.Main;
import model.BateauModel;
import model.CaseModel;
import model.GrilleJeuModel;
import model.JoueurModel;

public abstract class BatailleVue implements Observer{
	
	protected GrilleJeuModel grilleJeuModel;
	protected JoueurModel joueurModel;
	
	protected BatailleController controller;
	
	public BatailleVue(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,BatailleController controller){
		
		
		this.grilleJeuModel = grilleJeuModel;
		this.joueurModel = joueurModel;
		this.controller = controller;
		
		//on précise que cette classe observe les models
		joueurModel.addObserver(this);
		grilleJeuModel.addObserver(this);
		
	}

	
}
