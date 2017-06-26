package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GAME.Game;
import entity.entity;

public class KeyInput implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(entity en:Game.handler.entity){
			
			switch(key){
			case KeyEvent.VK_UP:
				en.setVelY(-3);
				break;
			case KeyEvent.VK_DOWN:
				en.setVelY(+3);
				break;
			case KeyEvent.VK_RIGHT:
				en.setVelX(+7);
				break;
	/*		case KeyEvent.VK_LEFT:
				en.setVelX(-5);
				break;	
				*/
			}
		}
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
for(entity en:Game.handler.entity){
			
			switch(key){
			case KeyEvent.VK_UP:
				en.setVelY(0);
				break;
			case KeyEvent.VK_DOWN:
				en.setVelY(0);
				break;
/*			case KeyEvent.VK_RIGHT:
				en.setVelX(0);
				break;
			case KeyEvent.VK_LEFT:
				en.setVelX(0);
				break; */
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//NOT USING
		
	}

}
