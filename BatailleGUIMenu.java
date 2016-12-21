import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MenuBataille extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		panel.setLayout(null);
		
		
		

		
		JSpinner tailleQ = new JSpinner(new SpinnerNumberModel(15,10,25,1));
		tailleQ.setBounds(356, 13, 58, 20);
		tailleQ.setBackground(new Color(0, 0, 0));
		panel.add(tailleQ);
		
		JLabel lblChoissisezLaTaille = new JLabel("Choissisez la taille de votre quadrillage.");
		lblChoissisezLaTaille.setBounds(10, 16, 265, 14);
		panel.add(lblChoissisezLaTaille);
		
		JLabel lblChoissisezLadresseIp = new JLabel("Choissisez l'adresse IP de l'adversaire.");
		lblChoissisezLadresseIp.setBounds(10, 47, 265, 14);
		panel.add(lblChoissisezLadresseIp);
		
		textField = new JTextField();
		textField.setBounds(285, 44, 129, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(285, 183, 129, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Démarrer");
		btnNewButton_1.setBounds(10, 183, 142, 57);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 75, 129, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblChoisissezLePort = new JLabel("Choisissez le port.");
		lblChoisissezLePort.setBounds(10, 78, 265, 14);
		panel.add(lblChoisissezLePort);
		
		JCheckBox chckbxMusique = new JCheckBox("Musique?");
		chckbxMusique.setBounds(317, 102, 97, 23);
		panel.add(chckbxMusique);
	}
}
