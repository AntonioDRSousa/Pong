import javax.swing.*;
import java.awt.*;

public class Tab{
	private static final int speed=3;
	private static final int width=15;
	private static final int height=100;
	private Point coord;
	private Rectangle ret;

	public Tab(int x,int y){
		coord=new Point(x,y);
		ret=new Rectangle(x,y,width,height);
	}

	//draw Tab
	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		g.fill(ret);
	}

	//up movement of Tab
	public void moveUp(){
		if(!Game.getBall().intersection(ret)){//verify if Tab move for one place that it isn't Ball's location
			if((coord.getY()-speed)>=0){
				coord.setY(coord.getY()-speed);
			}
			else{
				coord.setY(0);
			}
			ret.setBounds((int)coord.getX(),(int)coord.getY(),width,height);
		}
	}

	//down moement of Tab
	public void moveDown(){
		if(!Game.getBall().intersection(ret)){//verify if Tab move for one place that it isn't Ball's location
			if((coord.getY()+speed)<=(Pong.getHeightField()-height)){
				coord.setY(coord.getY()+speed);
			}
			else{
				coord.setY(Pong.getHeightField()-height);
			}
			ret.setBounds((int)coord.getX(),(int)coord.getY(),width,height);
		}
	}

	// get's methods
	public Rectangle getRet(){
		return ret;
	}
}

	
