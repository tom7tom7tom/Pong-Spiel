package gameObjects;

import java.awt.*;
//import java.awt.event.*;
import java.util.*;
//import javax.swing.*;
import game.GameObject;

//test123

public class Ball extends GameObject{
		Random random;
		public int xVelocity;
		public int yVelocity;
		public int initialSpeed = 1;
		
		public Ball(int x, int y, int width, int height) {
			super(x, y, width, height);
			random = new Random();
			int randomXDirection = random.nextInt(2);		//Gives us a number between 0 and 1 (0,1)
			if(randomXDirection == 0)		//If our number is 0 the ball moves left
				randomXDirection--;
			setXDirection(randomXDirection*initialSpeed);
			
			int randomYDirection = random.nextInt(2);
			if(randomYDirection == 0)		//If our number is 0 the ball moves up
				randomYDirection--;
			setYDirection(randomYDirection*initialSpeed);
		}
		
		public void setXDirection(int randomXDirection) {
			xVelocity = randomXDirection;
		}
		
		public void setYDirection(int randomYDirection) {
			yVelocity = randomYDirection;
		}
		
		public void move() {
			positionX += xVelocity;
			positionY += yVelocity;
		}
		
		public void drawBall(Graphics g) {
			g.setColor(Color.white);
			g.fillOval(positionX, positionY, groesseY, groesseX);
		}
		
		public void setDirection() {
			random = new Random();
			int randomXDirection = random.nextInt(2);		//Gives us a number between 0 and 1 (0,1)
			if(randomXDirection == 0)		//If our number is 0 the ball moves left
				randomXDirection--;
			setXDirection(randomXDirection*initialSpeed);
			
			int randomYDirection = random.nextInt(2);
			if(randomYDirection == 0)		//If our number is 0 the ball moves up
				randomYDirection--;
			setYDirection(randomYDirection*initialSpeed);
		}
		


	
}
