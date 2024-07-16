package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import game.GameLogic;

public class Score extends JLabel{

	public GameLogic spiellogik;
	
	public Score(GameLogic spiellogik) {
		this.spiellogik = spiellogik;
	}
	
public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.PLAIN, 60));
		// Zeichne alle Spielobjekte
		String score = spiellogik.scoreLeft + " : " + spiellogik.scoreRight;
		g.setColor(Color.WHITE);
		
		//scores
				g.drawString(String.valueOf(spiellogik.scoreLeft/10) + String.valueOf(spiellogik.scoreLeft%10), (spiellogik.screenwidth/2)-85, 50);
				g.drawString(String.valueOf(spiellogik.scoreRight/10) + String.valueOf(spiellogik.scoreRight%10), (spiellogik.screenwidth/2)+20, 50);
		
		repaint();
	}
	
}
