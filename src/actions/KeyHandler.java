package actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GameLogic;

public class KeyHandler implements KeyListener {

	GameLogic gamelogic;

	public KeyHandler(GameLogic spiellogik) {
		gamelogic = spiellogik;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			gamelogic.keyLeftarrowpressed = true;
		
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			gamelogic.keyRightarrowpressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			gamelogic.keyUParrowpressed = true;
		
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gamelogic.keyDownarrowpressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			gamelogic.keyLeftarrowpressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			gamelogic.keyRightarrowpressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			gamelogic.keyUParrowpressed = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			gamelogic.keyDownarrowpressed = false;
		}
	}

}
