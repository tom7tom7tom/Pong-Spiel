package game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.*;

import gameObjects.Ball;
import gameObjects.BeweglichesRechteck;
import gui.Draw;

public class GameLogic 
{
	
	private Timer gameTimer;
	public int screenwidth = 800;
	public int screenheight = 600;
	public ArrayList<GameObject> spielObjekte;
	
	final static int ballDiameter = 20;
	public int paddleHeight = 100;
	public int paddleSpeed = 2;
	public int scoreLeft = 0;
	public int scoreRight = 0;
	
	public boolean keyLeftarrowpressed;
	public boolean keyRightarrowpressed;
	

	public boolean keyUParrowpressed;
	public boolean keyDownarrowpressed;
	
	public GameLogic() {
		//Gui.screenwidth = 800;
		//Gui.screenheight = 600;
	public GameLogic() 
	{

		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		
		keyLeftarrowpressed = false;
		keyRightarrowpressed = false;
		
		// Objekte im Spiel:
		Ball ball = new Ball((screenwidth/2)-(ballDiameter/2),(screenheight/2)-(ballDiameter/2), ballDiameter, ballDiameter);
		spielObjekte.add(ball);
		
		BeweglichesRechteck leftPaddle = new BeweglichesRechteck(70, 220, 20, 100);
		spielObjekte.add(leftPaddle);
		leftPaddle.richtung = 0; // Startrichtung
		BeweglichesRechteck rightPaddle = new BeweglichesRechteck(710, 220, 20, 100);
		spielObjekte.add(rightPaddle);
		//BeweglichesRechteck beispielObjekt3 = new BeweglichesRechteck(400, 400, 20, 20);
		//spielObjekte.add(beispielObjekt3);
		System.out.println("" + ((screenwidth/2)-(ballDiameter/2)) + "    " + ((screenheight/2)-(ballDiameter/2)) + "   " + ballDiameter);
		
		
		gameTimer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run() {
				// Laufende Ausführungen im Spiel:
				
				ball.move();
				System.out.println(ball.positionX + "+" + ball.positionY);
				checkCollision(ball, rightPaddle, leftPaddle);
				//beispielObjekt3.automatischeBallbewegung();
				
				if (keyLeftarrowpressed) {
					leftPaddle.positionY -= paddleSpeed;// key W
				} else if (keyRightarrowpressed) {
					leftPaddle.positionY += paddleSpeed;// Key S

				if (keyLeftarrowpressed) 
				{
					beispielObjekt2.positionX -= 1;
				}
				 else if (keyRightarrowpressed) 
				{
					beispielObjekt2.positionX += 1;

				}
				if (keyUParrowpressed) {
					rightPaddle.positionY -= paddleSpeed;// Key UP
				} else if (keyDownarrowpressed) {
					rightPaddle.positionY += paddleSpeed;// Key Down
				}
				
			}
		}, 0, 5);
	}
	
	public void checkCollision(Ball ball, BeweglichesRechteck rightPaddle, BeweglichesRechteck leftPaddle) {
		//bounce ball off top & bottom window edges
			if(ball.positionY <= 0) {
				ball.setYDirection(-ball.yVelocity);
			}
			if(ball.positionY >= screenheight - ballDiameter) {
				ball.setYDirection(-ball.yVelocity);
			}
		
		//bounces ball off paddles
			if(intersects(ball, leftPaddle)) {
				ball.xVelocity = Math.abs(ball.xVelocity);
				//increase the Velocity after it bounces off a paddle
				ball.xVelocity++; 		//optional for more difficulty
				if(ball.yVelocity > 0)
					ball.yVelocity++;	//optional for more difficulty
				else
					ball.yVelocity--;
					ball.setXDirection(ball.xVelocity);
					ball.setYDirection(ball.yVelocity);
			}
			
			if(intersects(ball, rightPaddle)) {
				ball.xVelocity = Math.abs(ball.xVelocity);
				//increase the Velocity after it bounces off a paddle
				ball.xVelocity++; 		//optional for more difficulty
				if(ball.yVelocity > 0)
					ball.yVelocity++;	//optional for more difficulty
				else
					ball.yVelocity--;
					ball.setXDirection(-ball.xVelocity);
					ball.setYDirection(ball.yVelocity);
			}
			
			//give a leftPaddle point and ####later####  creates new paddles and ball ####later####
			if(ball.positionX <= 0) {
				scoreLeft++;
				newSet(ball);
				//newPaddles();
				//newBall();
				System.out.println("Player 2:" + scoreLeft);
			}
			//give the right paddle a point and ####later####creates new paddles and ball ####later####
			if(ball.positionX >= screenwidth-ballDiameter) {
				scoreRight++;
				newSet(ball);
				//newPaddles();
				//newBall();
				System.out.println("Player 1:" + scoreRight);
			}
			
			if (leftPaddle.positionY <= 0) {
				leftPaddle.positionY=0;
			}
			if(leftPaddle.positionY >= (screenheight - paddleHeight)) {
				leftPaddle.positionY = screenheight - paddleHeight;
			}
			
			if (rightPaddle.positionY <= 0) {
				rightPaddle.positionY=0;
			}
			if (rightPaddle.positionY >= (screenheight - paddleHeight)) {
				rightPaddle.positionY = screenheight - paddleHeight;
			}
	}
	
	public boolean intersects(Ball ball, BeweglichesRechteck Paddle) {
        return (Paddle.positionX < ball.positionX + ballDiameter &&
                Paddle.positionX + Paddle.groesseX > ball.positionX &&
                Paddle.positionY < ball.positionY + ballDiameter &&
                Paddle.positionY + Paddle.groesseY > ball.positionY);
    }
	
	public void newSet(Ball ball) {
		ball.setPosX((screenwidth/2)-(ballDiameter/2));
		ball.setPosY((screenheight/2)-(ballDiameter/2));
		ball.setDirection();
		ball.move();
		
	}
}
