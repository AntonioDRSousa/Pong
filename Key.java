import java.awt.event.*; 

public class Key implements KeyListener,codeKeys{
	public void keyTyped(KeyEvent e){
	}
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_W){
			Game.keys[b_W]=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			Game.keys[b_S]=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			Game.keys[b_UP]=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			Game.keys[b_DOWN]=false;		
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
            Game.keys[b_Space]=false;
		}			
	}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_W){
			Game.keys[b_W]=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			Game.keys[b_S]=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			Game.keys[b_UP]=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			Game.keys[b_DOWN]=true;		
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
            Game.keys[b_Space]=true;
		}			
	}
}
