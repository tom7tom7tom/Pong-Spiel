package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import gameObjects.BeweglichesRechteck;
import schole1.Fachklasse_RechtwinkligesDreieck;

public class GameLogic {
	
	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;
	
	public boolean keyLeftarrowpressed;
	public boolean keyRightarrowpressed;
	
	public boolean keyUParrowpressed;
	public boolean keyDownarrowpressed;
	 
	 

	
	
	
	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		
		keyLeftarrowpressed = false;
		keyRightarrowpressed = false;
		
		Random rnd = new Random();
		int ballRand =rnd.nextInt(520) ;
		
		
		
		
		
		// Objekte im Spiel:
		BeweglichesRechteck beispielObjekt1 = new BeweglichesRechteck(90, 100, 20, 110);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		BeweglichesRechteck beispielObjekt2 = new BeweglichesRechteck(710, 400, 20, 110);
		spielObjekte.add(beispielObjekt2);
		BeweglichesRechteck beispielObjekt3 = new BeweglichesRechteck(400,ballRand , 20, 20);
		spielObjekte.add(beispielObjekt3);
		
		
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				// Laufende Ausführungen im Spiel:
			
				if(beispielObjekt3.positionX == 690 && beispielObjekt2.positionY-20 < beispielObjekt3.positionY && beispielObjekt2.positionY+100> beispielObjekt3.positionY) {
					beispielObjekt3.rechtsLinks();;
				}
				if(beispielObjekt3.positionX == 110 && beispielObjekt1.positionY-20 < beispielObjekt3.positionY && beispielObjekt1.positionY+100> beispielObjekt3.positionY) {
					beispielObjekt3.rechtsLinks();;
				}
				
				beispielObjekt3.automatischeBallbewegung();
				
				if (keyLeftarrowpressed) {
					beispielObjekt1.positionY -= 1;// key W
				} else if (keyRightarrowpressed) {
					beispielObjekt1.positionY += 1;// Key S
				}
				if (keyUParrowpressed) {
					beispielObjekt2.positionY -= 1;// Key UP
				} else if (keyDownarrowpressed) {
					beispielObjekt2.positionY += 1;// Key Down
				}
				if(beispielObjekt1.positionY < 0) {
					beispielObjekt1.stopUnden();
				}
				if(beispielObjekt1.positionY > 450) {
					beispielObjekt1.stopOben();;
				}
				if(beispielObjekt2.positionY < 0) {
					beispielObjekt2.stopUnden();
				}
				if(beispielObjekt2.positionY > 450) {
					beispielObjekt2.stopOben();;
				}
				
				
			}
		}, 0, 5);
	}
	
}
