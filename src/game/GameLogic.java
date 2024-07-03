package game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import gameObjects.Ball;
import gameObjects.BeweglichesRechteck;


public class GameLogic {
	
	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	public ArrayList<GameObject> spielObjekte;
	
	final static int ballDiameter = 20;
	
	public int scoreLeft = 0;
	
	public boolean keyLeftarrowpressed;
	public boolean keyRightarrowpressed;
	
	public boolean keyUParrowpressed;
	public boolean keyDownarrowpressed;
	
	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		
		keyLeftarrowpressed = false;
		keyRightarrowpressed = false;
		
		// Objekte im Spiel:
		BeweglichesRechteck beispielObjekt1 = new BeweglichesRechteck(90, 100, 20, 20);
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		BeweglichesRechteck beispielObjekt2 = new BeweglichesRechteck(710, 400, 20, 20);
		spielObjekte.add(beispielObjekt2);
		//BeweglichesRechteck beispielObjekt3 = new BeweglichesRechteck(400, 400, 20, 20);
		//spielObjekte.add(beispielObjekt3);
		System.out.println("" + ((screenwidth/2)-(ballDiameter/2)) + "    " + ((screenheight/2)-(ballDiameter/2)) + "   " + ballDiameter);
		Ball ball = new Ball((screenwidth/2)-(ballDiameter/2),(screenheight/2)-(ballDiameter/2), ballDiameter, ballDiameter);
		spielObjekte.add(ball);
		
		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				// Laufende Ausführungen im Spiel:
				
				
				//beispielObjekt3.automatischeBallbewegung();
				
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
				
			}
		}, 0, 5);
	}
	
}
