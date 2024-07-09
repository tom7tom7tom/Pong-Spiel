package gameObjects;

import java.awt.desktop.SystemSleepEvent;
import java.util.Random;

import game.GameLogic;
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
	public int Speed;
	public int x;
	public int slowX;
	public int slowXend;

	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
		Random rnd = new Random();
		double RL =rnd.nextInt(2) ;
		double UO = rnd.nextInt(2);
		
		x= 2;
		Speed = 0;
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
	public void  stopUnden() {
		positionY = 0;
	}
	public void  stopOben() {
		positionY = 450;
	}
	
	
	public void rechtsLinks() {
		System.out.println(Speed);
		if (rechts == 1 && links == 0) {
			rechts = 0;

			links = 1;
		}else {
			rechts = 1;

			links = 0;
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
			
			Random rnd = new Random();
			if(Speed == 2000) {
				 slowX = 150;
				 slowXend = 650;
				x=3;
				System.out.println(Speed);
			}
			if(Speed == 2500) {
				x=4;
				System.out.println(Speed);
			}
			if(Speed == 3000) {
				x=5;
				System.out.println(Speed);
			}
			if(Speed == 3500) {
			 
				x=6;
				System.out.println(Speed);
			}
			if(Speed == 4000) {
				x=7;
				System.out.println(Speed);
			}
			if(Speed == 4500) {
				x=8;
				System.out.println(Speed);
			}
			if(Speed == 5000) {
				 
				x=9;
				System.out.println(Speed);
			}
			if(Speed == 5500) {
				x=10;
				System.out.println(Speed);
			}
			if(Speed == 6000) {
				x=11;
				System.out.println(Speed);
			}
			if(Speed == 6500) {
				 
				x=12;
				System.out.println(Speed);
			}
			if(Speed == 7000) {
				x=13;
				System.out.println(Speed);
			}
			if(Speed == 7500) {
				x=14;
				System.out.println(Speed);
			}
			if(Speed == 8000) {
				x=15;
				System.out.println(Speed);
			}
			if(Speed == 8250) {
				x=16;
				System.out.println(Speed);
			}
			if(Speed == 8500) {
				x=17;
				System.out.println(Speed);
			}
			if(Speed == 8750) {
				x=18;
				System.out.println(Speed);
			}
			if(Speed == 9000) {
				x=19;
				System.out.println(Speed);
			}
			if(Speed == 9250) {
				x=20;
				System.out.println(Speed);
			}
		if (Speed >= 1000 && positionX >=slowX  && positionX <= slowXend ) {
				
				
				if (Unden == 1) {
					
					
					if(richtung == 0) {
						positionY += rnd.nextInt(x) ;
					} 
					
					
				}
			
				if (Oben == 1) {
					
					
					  if (richtung == 0 ) {
						positionY -= rnd.nextInt(x) ;
					} 
					
					
				}
				if (rechts == 1) {
					
					
					if(richtung == 1) {
						positionX +=(rnd.nextInt(x)+1)/(rnd.nextInt(x)+1) ;
						
					} 
					
				}
				if (links == 1) {
					
					
					 if (richtung == 1 ) {
						positionX -= (rnd.nextInt(x)+1)/(rnd.nextInt(x)+1) ;
						
					} 
					
					
				}
				
				
			
			
			}
			
			if (Unden == 1) {
				
			
				if(richtung == 0) {
					positionY += 1 ;
				} 
				
				
			}
			if (rechts == 1) {
				
				
				if(richtung == 1) {
					positionX +=1 ;
					Speed += 1;
				} 
				
			}
			if (Oben == 1) {
				
				
				  if (richtung == 0 ) {
					positionY -= 1 ;
				} 
				
				
			}
			if (links == 1) {
				
			
				 if (richtung == 1 ) {
					positionX -= 1 ;
					Speed += 1;
				} 
				
				
			}
			if (positionY >= 540 ) {
				Unden = 0;
				Oben = 1;
				
			}
			if (positionY <= 0 ) {
				Unden = 1;
				Oben = 0;
				
			}
			if (positionX >= 700) {
				rechts = 0;
				links = 1;
				TorRechts++;  // Tor Rechts
				EndStart = 1;
				
			}
			if (positionX <= 100) {
				rechts = 1;
				links = 0;
				TorLinks++;    // Tor Links
				EndStart = 1;
			}
			
			if(EndStart == 1) {
				System.out.println(Speed);
				Speed = 0;
				
				positionX = 400;
				
				
				double RL =rnd.nextInt(2) ;
				double UO = rnd.nextInt(2);
				positionY = rnd.nextInt(540);
				
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
