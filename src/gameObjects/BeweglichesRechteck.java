package gameObjects;

import java.awt.desktop.SystemSleepEvent;
import java.util.Random;

import game.GameObject;

public class BeweglichesRechteck extends GameObject {
	
	public byte richtung;
	public int schritteInGleicherRichtung;
	public int rechts;
	public int links;
	public int Unden;
	public int Oben;
	public int TorRechts;
	public int TorLinks;
	public int EndStart;

	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
		Random rnd = new Random();
		double RL =rnd.nextInt(2) ;
		double UO = rnd.nextInt(2);
		
		TorLinks = 0;
		TorRechts = 0;
		EndStart = 0;
		
		if (RL  == 1){
			rechts = 1;
			links = 0;
		}else {
		rechts = 0;

		links = 1;
		}
		if (UO == 1) {
		Unden = 1;
		Oben = 0;
		}else {
		Unden = 0;
		Oben = 1;
		}
	}
	
	
	public void automatischeKreisbewegung() {
		
		
	
		if(richtung == 0) {
			positionX += 1;
		} else if (richtung == 1 ) {
			positionY += 1;
		} 
		
		else if (richtung == 2  ) {
			positionX -= 1;
		} else if (richtung == 3) {
			positionY -= 1;
		}
		if (schritteInGleicherRichtung > 3) {
			richtung += 1;
			if (richtung > 3) {
				richtung = 0;
			}
			schritteInGleicherRichtung = 0;
		} else {
			schritteInGleicherRichtung += 1;
		}
	}
		public void automatischeBallbewegung() {
			
			
			
			
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
				TorRechts++;  // Tor Rechts
				EndStart = 1;
				
			}
			if (positionX == 100) {
				rechts = 1;
				links = 0;
				TorLinks++;    // Tor Links
				EndStart = 1;
			}
			
			if(EndStart == 1) {
				positionY = 270;
				positionX = 400;
				
				Random rnd = new Random();
				double RL =rnd.nextInt(2) ;
				double UO = rnd.nextInt(2);
				
				if (RL  == 1){
					rechts = 1;
					links = 0;
				}else {
				rechts = 0;

				links = 1;
				}
				if (UO == 1) {
				Unden = 1;
				Oben = 0;
				}else {
				Unden = 0;
				Oben = 1;
				
				}
				EndStart = 0;
				
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

