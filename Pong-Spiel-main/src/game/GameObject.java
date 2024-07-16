package game;

import java.awt.Color;

public class GameObject {

	public int groesseX;
	public int groesseY;
	
	public int positionX;
	public int positionY;
	
	public Color color = Color.white;
	

	public GameObject(int posX, int posY, int breite, int hoehe) {
		positionX = posX;
		positionY = posY;
		groesseX = breite;
		groesseY = hoehe;
	}
	
	public void setPosX(int x) {
		positionX = x;
	}
	
	public void setPosY(int y) {
		positionY = y;
	}

}
