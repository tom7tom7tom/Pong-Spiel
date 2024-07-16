package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JLabel;

import game.GameLogic;
import game.GameObject;
import gameObjects.Ball;
import gameObjects.BeweglichesRechteck;

@SuppressWarnings("serial")
public class Draw extends JLabel{
	
	private int screenwidth;
	private int screenheight;
	ArrayList<GameObject> objekteImSpiel;

	public Draw(GameLogic spiellogik, int screenBreite, int screenHoehe) {
		objekteImSpiel = spiellogik.spielObjekte;
		screenwidth = screenBreite;
		screenheight = screenHoehe;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Zeichne Hintergrund
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenwidth, screenheight);
		
		// Zeichne alle Spielobjekte
		g.setColor(Color.WHITE);
		for (int i = 0; i < objekteImSpiel.size(); i++) {
			//isBallfale?
			GameObject aktuellesObjekt = objekteImSpiel.get(i);
			if(aktuellesObjekt instanceof Ball) {
				g.setColor(Color.WHITE);
				g.fillOval(aktuellesObjekt.positionX, aktuellesObjekt.positionY, aktuellesObjekt.groesseX, aktuellesObjekt.groesseY);
						
			}else if(aktuellesObjekt instanceof BeweglichesRechteck){
				g.setColor(aktuellesObjekt.color);
				g.fillRect(aktuellesObjekt.positionX, aktuellesObjekt.positionY, aktuellesObjekt.groesseX, aktuellesObjekt.groesseY);
			}
			//line in the middle
			g.setColor(Color.WHITE);
			g.drawLine(screenwidth/2, 0, screenwidth/2, screenheight);
		}
		
				
		repaint();
	}
	
}