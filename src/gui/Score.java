package gui;

import java.awt.Color;
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

		// Zeichne Hintergrund
		//g.setColor(Color.BLACK);
		//g.fillRect(0, 0, 300, 300);		//Übermalen der Fläche des Scores (die Werte sind noch unpassen)
		
		// Zeichne alle Spielobjekte
		String score = spiellogik.scoreLeft + " : " + spiellogik.scoreRight;
		g.setColor(Color.WHITE);
		g.drawChars(score.toCharArray(), 0, score.length(), 70, 15);		//Koordinaten für Text nicht mittig
		
		
		repaint();
	}
	
}
