//Avec image en background.

package default_package;

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
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		

		
		JSpinner tailleQ = new JSpinner(new SpinnerNumberModel(15,10,25,1));
		tailleQ.setForeground(Color.GREEN);
		tailleQ.setBounds(235, 110, 58, 20);
		tailleQ.setBackground(Color.BLACK);
		panel.add(tailleQ);
		
		JLabel lblChoissisezLaTaille = new JLabel("Taille du quadrillage.");
		lblChoissisezLaTaille.setForeground(Color.BLACK);
		lblChoissisezLaTaille.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoissisezLaTaille.setBounds(10, 113, 200, 14);
		panel.add(lblChoissisezLaTaille);
		
		JLabel lblChoissisezLadresseIp = new JLabel("Adresse IP de l'adversaire.");
		lblChoissisezLadresseIp.setForeground(Color.BLACK);
		lblChoissisezLadresseIp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoissisezLadresseIp.setBounds(10, 144, 200, 14);
		panel.add(lblChoissisezLadresseIp);
		
		textField = new JTextField();
		textField.setBackground(Color.GREEN);
		textField.setBounds(235, 141, 129, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(235, 284, 129, 57);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Démarrer");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 284, 142, 57);
		panel.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.GREEN);
		textField_1.setBounds(235, 172, 129, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblChoisissezLePort = new JLabel("Numero de port.");
		lblChoisissezLePort.setForeground(Color.BLACK);
		lblChoisissezLePort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoisissezLePort.setBounds(10, 175, 200, 14);
		panel.add(lblChoisissezLePort);
		
		JCheckBox chckbxMusique = new JCheckBox("Musique?");
		chckbxMusique.setBackground(Color.GREEN);
		chckbxMusique.setBounds(235, 199, 97, 23);
		panel.add(chckbxMusique);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\JOE\\Desktop\\PM400x500px.png"));
		label.setBounds(0, 0, 374, 452);
		panel.add(label);
	}
}
