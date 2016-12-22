package view;

import java.util.Observer;

import javax.swing.JFrame;

import controller.BatailleController;
import model.GrilleJeuModel;
import model.JoueurModel;

public abstract class BatailleVue extends JFrame implements Observer{
	
	protected GrilleJeuModel grilleJeuModel;
	protected JoueurModel joueurModel;
	protected GrilleJeuModel grilleCible;
	
	protected BatailleController controller;
	
	public BatailleVue(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,BatailleController controller){
		
		
		this.grilleJeuModel = grilleJeuModel;
		this.joueurModel = joueurModel;
		this.grilleCible = grilleCible;
		this.controller = controller;
		
		
		//on précise que cette classe observe les models
		joueurModel.addObserver(this);
		grilleJeuModel.addObserver(this);
		grilleCible.addObserver(this);
	}

	
}
