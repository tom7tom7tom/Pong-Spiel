package actions;

import org.w3c.dom.Text;

import game.GameLogic;
import gui.Gui;

public class Main {

	public static void main(String[] args) {
		GameLogic spiellogik = new GameLogic();
		new Gui(spiellogik);
		
		
	}

	
	
	
}
