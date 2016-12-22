package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controller.BatailleController;
import controller.SecondThread;
import default_package.Main;
import model.GrilleJeuModel;
import model.JoueurModel;

public class BatailleGUICible extends BatailleVueGUI{

	private SecondThread secondThread;
	private JPanel contentPane;
	private Boutton[][] tabBoutton;
	private JTextPane txtpnVeuilezPositionnerVos;
	public static boolean phaseJeu = false; //définit si on est dans la phase de jeu ou de préparation
	
	public BatailleGUICible(GrilleJeuModel grilleJeuModel,JoueurModel joueurModel,GrilleJeuModel grilleCible,BatailleController controller) {
		
		super(grilleJeuModel, joueurModel,grilleCible,controller);
		secondThread = new SecondThread(controller);
		tabBoutton = new Boutton[Main.nbLignes][Main.nbColonnes];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Main.nbColonnes*21+10, Main.nbLignes*21+58);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtpnVeuilezPositionnerVos = new JTextPane();
		txtpnVeuilezPositionnerVos.setBackground(SystemColor.inactiveCaption);
		txtpnVeuilezPositionnerVos.setText("Grille Cible");
		panel.add(txtpnVeuilezPositionnerVos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		for(int i = 0;i<Main.nbLignes;i++){
			for(int j = 0;j<Main.nbColonnes;j++){
				if(i==0 || j==0){
					BouttonMarge button = new BouttonMarge();
					String text = String.valueOf(j);
					
					button.getButton().setFont(new Font("Lucida Grande", Font.PLAIN, 3));
					button.getButton().setText(text);
					
					GridBagConstraints gbc_button = new GridBagConstraints();
					gbc_button.insets = new Insets(0, 0, 1, 1);
					gbc_button.gridx = i; 
					gbc_button.gridy = j;
					button.setPosx(j);
					button.setPosy(i);
					panel_1.add(button.getButton(), gbc_button);
				}
				else{
					Boutton button = new Boutton();
					tabBoutton[i][j] = button;
					GridBagConstraints gbc_button = new GridBagConstraints();
					gbc_button.insets = new Insets(0, 0, 1, 1);
					gbc_button.gridx = i; //positionnement dans la grille
					gbc_button.gridy = j;
					button.setPosx(j);
					button.setPosy(i);
					/*
					button.getButton().addMouseListener(new java.awt.event.MouseAdapter() {
					    @SuppressWarnings("deprecation")
					    
						public void mouseEntered(java.awt.event.MouseEvent evt) {
					    	if(!button.cochee){
					    		
					    			tabBoutton[button.getPosy()][1].getButton().setBackground(new Color(113, 214, 66));
					    			tabBoutton[button.getPosy()][Main.nbLignes-1].getButton().setBackground(new Color(113, 214, 66));
					    		
					    			tabBoutton[button.getPosy()][button.getPosx()].getButton().setBackground(new Color(113, 214, 66));
					    			
					    			tabBoutton[1][button.getPosx()].getButton().setBackground(new Color(113, 214, 66));
					    			tabBoutton[Main.nbColonnes-1][button.getPosx()].getButton().setBackground(new Color(113, 214, 66));
					    			
					    	
					    	}
					    	
					    	
					    }

					    public void mouseExited(java.awt.event.MouseEvent evt) {
					    	if(!button.cochee){
					    		tabBoutton[button.getPosy()][1].getButton().setBackground(new Color(20, 99, 12));
				    			tabBoutton[button.getPosy()][Main.nbLignes-1].getButton().setBackground(new Color(20, 99, 12));
				    		
				    			tabBoutton[button.getPosy()][button.getPosx()].getButton().setBackground(new Color(20, 99, 12));
				    			
				    			tabBoutton[1][button.getPosx()].getButton().setBackground(new Color(20, 99, 12));
				    			tabBoutton[Main.nbColonnes-1][button.getPosx()].getButton().setBackground(new Color(20, 99, 12));
				    		
				    	
					    	}
					    	else{
					    		tabBoutton[button.getPosy()][1].getButton().setBackground(new Color(20, 99, 12));
				    			tabBoutton[button.getPosy()][Main.nbLignes-1].getButton().setBackground(new Color(20, 99, 12));
				    		
					    		button.getButton().setBackground(new Color(20, 99, 12));
					    		
					    		tabBoutton[1][button.getPosx()].getButton().setBackground(new Color(20, 99, 12));
				    			tabBoutton[Main.nbColonnes-1][button.getPosx()].getButton().setBackground(new Color(20, 99, 12));
					    	}
					    	
					    }
					});*/
					button.getButton().addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							
								if(joueurModel.isSonTour()){
									
									button.setCochee(true);
									int [] caseCochee = new int[2];
									
									caseCochee [0]= button.getPosx();
									caseCochee [1]= button.getPosy();
									
									String confirm = controller.tirer(caseCochee); //on tire et on récupère la confirmation
					
									if(confirm.equals("RATE")){
										button.getButton().setBackground(new Color(66, 116, 244));//bleu
									}
									else{
										button.getButton().setBackground(new Color(249, 46, 39));
										System.out.println("frontiere ultime");
									}
									 
									 new SecondThread(controller).start();
									
								}
						}
					});
					panel_1.add(button.getButton(), gbc_button);
				}
			}
		}
		
		
	
	}
	
	/**
	 * Cette classe permet de lier un boutton avec sa position dans la grille de jeu.
	 * @author kevin
	 *
	 */
	public class Boutton extends JFrame{
		private JButton button;
		private int posx;
		private int posy;
		private boolean cochee;
		public Boutton(){
			button = new JButton();
			button.setPreferredSize(new Dimension(20,20));
			button.setBackground(new Color(20, 99, 12));
			button.setOpaque(true);
			button.setBorderPainted(false);
			this.cochee = false;
		}
		public JButton getButton() {
			return button;
		}
		public void setButton(JButton button) {
			this.button = button;
		}
		public int getPosx() {
			return posx;
		}
		public void setPosx(int posx) {
			this.posx = posx;
		}
		public int getPosy() {
			return posy;
		}
		public void setPosy(int posy) {
			this.posy = posy;
		}
		public boolean isCochee() {
			return cochee;
		}
		public void setCochee(boolean cochee) {
			this.cochee = cochee;
		}
		
	}
	
	public class BouttonMarge extends JFrame{
		private JButton button;
		private int posx;
		private int posy;
		public BouttonMarge(){
			
			button = new JButton();
			button.setPreferredSize(new Dimension(20,20));
			button.setBackground(new Color(0, 0, 0));
			button.setOpaque(true);
			button.setBorderPainted(false);
			
		}
		public JButton getButton() {
			return button;
		}
		public void setButton(JButton button) {
			this.button = button;
		}
		public int getPosx() {
			return posx;
		}
		public void setPosx(int posx) {
			this.posx = posx;
		}
		public int getPosy() {
			return posy;
		}
		public void setPosy(int posy) {
			this.posy = posy;
		}
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(joueurModel.isSonTour()){
			txtpnVeuilezPositionnerVos.setText("Veuillez choisir votre cible");
			System.out.println("Votre tour");
		}
		else{
			txtpnVeuilezPositionnerVos.setText("Veuillez attendre votre tour");
		}
		for(int i = 0;i<Main.nbColonnes;i++){
			for(int j = 0;j<Main.nbLignes;j++){
				
				if(!joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleCible().getTabCase()[i][j].isEstDetruite()){
					tabBoutton[i][j].getButton().setBackground(new Color(66, 116, 244));
				}
				else if(joueurModel.getGrilleCible().getTabCase()[i][j].isEstUtilisee() && joueurModel.getGrilleCible().getTabCase()[i][j].isEstDetruite()){
					tabBoutton[i][j].getButton().setBackground(new Color(216, 41, 41));
				}
			}
		}
		
	}


}
