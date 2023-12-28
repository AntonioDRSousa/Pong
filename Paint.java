import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0,0,600,600);

		g.setColor(Color.WHITE);
		g.drawLine(0,0,0,600);
		g.drawLine(0,0,600,0);
		g.drawLine(0,399,600,399);
		g.drawLine(593,0,593,399);
		g.drawLine(300,0,300,500);
		
		Game.draw(g2);
		repaint();
	}
}
