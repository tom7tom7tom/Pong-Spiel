package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.GameLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GameLogic objGameLogic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI(new GameLogic()); //Übergabeparameter in Klammern wichtig
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
	public MainGUI(GameLogic gameLogic) { //Übergabeparameter wichtig
		this.objGameLogic = gameLogic; //Notwendig für Funktion
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("start 2P");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Notwendig um Spiel zu Starten
				GameLogic spiellogik = new GameLogic();
				new Gui(spiellogik);
				dispose(); 
			}
		});
		btnStart.setBounds(176, 88, 89, 23);
		contentPane.add(btnStart);
		
		JLabel lblNewLabel = new JLabel("PONG");
		lblNewLabel.setBounds(199, 48, 41, 29);
		contentPane.add(lblNewLabel);
	}
}
