import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import java.awt.Color;

public class MenuBataille extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBataille frame = new MenuBataille();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuBataille() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		
		JCheckBoxMenuItem chckbxmntmChoissisezVotreQuadrillage = new JCheckBoxMenuItem("Choissisez votre quadrillage");
		panel.add(chckbxmntmChoissisezVotreQuadrillage);
		
		JSpinner spinner = new JSpinner( ); //JSpinner spinner = new JSpinner( new SpinnerNumberModel( 2,1,7,1 ) );
		spinner.setBackground(new Color(400, 400, 400));
		panel.add(spinner);
	}

}
