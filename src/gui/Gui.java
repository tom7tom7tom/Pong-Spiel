package gui;

import javax.swing.JFrame;

import actions.KeyHandler;
import game.GameLogic;


public class Gui {
	
	public int screenwidth = 800;
	public int screenheight = 600;
	private JFrame frame;
	
	public Gui(GameLogic spiellogik) {
		
		//screenwidth = 800;
		//screenheight = 600;
		//spiellogik.screenwidth = screenwidth;
		//spiellogik.screenheight = screenheight;

public class Gui 
{	
	private int screenwidth;
	private int screenheight;
	private JFrame frame;
	
	public Gui(GameLogic spiellogik) 
	{
		screenwidth = 800;
		screenheight = 600;
		spiellogik.screenwidth = screenwidth;
		spiellogik.screenheight = screenheight;

		frame = new JFrame();
		frame.setSize(screenwidth, screenheight);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyHandler(spiellogik));
		frame.requestFocus();
		
		Score score = new Score(spiellogik);
		score.setBounds(0, 0, 100, 20);
		score.setVisible(true);
		frame.add(score);
		
		Draw lbldraw = new Draw(spiellogik, screenwidth, screenheight);
		lbldraw.setBounds(0,0, screenwidth, screenheight);
		lbldraw.setVisible(true);
		frame.add(lbldraw);
		
		frame.setVisible(true);
	}

}
