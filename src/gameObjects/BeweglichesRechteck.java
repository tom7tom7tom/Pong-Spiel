package gameObjects;

import game.GameObject;

public class BeweglichesRechteck extends GameObject {
	
	public byte richtung;
	public int schritteInGleicherRichtung;
	public int rechts;
	public int Unden;
	public int links;
	public int Oben;
	
	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
		rechts = 1;
		Unden = 1;
		links = 0;
		Oben = 0;
	}
	
	
	public void automatischeKreisbewegung() {
		
		
	
		
	if (Unden == 1) {
		
	
		if(richtung == 0) {
			positionY += 1;
		} 
		
		
	}
	if (rechts == 1) {
		
		
		if(richtung == 1) {
			positionX += 1;
		} 
		
	}
	if (Oben == 1) {
		
		
		  if (richtung == 0 ) {
			positionY -= 1;
		} 
		
		
	}
	if (links == 1) {
		
	
		 if (richtung == 1 ) {
			positionX -= 1;
		} 
		
		
	}
	if (positionY == 540 ) {
		Unden = 0;
		Oben = 1;
		
	}
	if (positionY == 0 ) {
		Unden = 1;
		Oben = 0;
		
	}
	if (positionX == 700) {
		rechts = 0;
		links = 1;
	}
	if (positionX == 100) {
		rechts = 1;
		links = 0;
	}
	
	
	
	
		if (schritteInGleicherRichtung > 2) {
			richtung += 1;
			if (richtung > 2) {
				richtung = 0;
			}
			schritteInGleicherRichtung = 0;
		} else {
			schritteInGleicherRichtung += 1;
		}
		
		
		
		
	}
}
