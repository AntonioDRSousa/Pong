import javax.swing.*;
import java.awt.*;
import java.lang.Math.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Ball{
	private static final int speed=5;
	private static final int radius=10;
	private Point coord;
	private double vx,vy;//vx and vy are component vectors of Ball's velocity
	private Ellipse2D circle;

	public Ball(int x,int y){
		coord=new Point(x-radius,y-radius);// x-radius and y-radius because (x,y) are center of circle
		randomVelocity();
	}

	//randomiza velocity
	private void randomVelocity(){
		int grad=(int)(Math.random()*61)+15;//15 to 75 grads
		double rad=Math.toRadians(grad);

		vx=Math.cos(rad)*speed;
		vy=Math.sin(rad)*speed;

		if(((int)(Math.random()*2)+1)==2){
			vx=-vx;
		}
		if(((int)(Math.random()*2)+1)==2){
			vy=-vy;
		}
	}

	//draw Ball
	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		circle=new Ellipse2D.Double((int)coord.getX(),(int)coord.getY(),2*radius,2*radius);
		g.fill(circle);
	}

	//intersection methods
	private boolean intersection(Shape shapeA, Shape shapeB){
	   Area areaA = new Area(shapeA);
	   areaA.intersect(new Area(shapeB));
	   return !areaA.isEmpty();
	}
	public boolean intersection(Shape shape) {
		return intersection(shape,circle);
	}

	//movement method of Ball
	public void move(){
		Ellipse2D newCircle=new Ellipse2D.Double((int)coord.getX()+vx,(int)coord.getY()+vy,2*radius,2*radius);//circle in next step
		Ellipse2D newCircleTest=new Ellipse2D.Double((int)coord.getX()-vx,(int)coord.getY()+vy,2*radius,2*radius);//circle for test type of moviment
		
		if( ((coord.getY()+vy)<0) || ((coord.getY()+2*radius+vy)>Pong.getHeightField()) ){
			vy=-vy;
		}
		else if((coord.getX()+vx)<0){
			Game.goal(2);
			coord.setX(Game.getBallX0());
			coord.setY(Game.getBallY0());
			randomVelocity();
		}
		else if((coord.getX()+vx)>Pong.getWidthField()){
			Game.goal(1);
			coord.setX(Game.getBallX0());
			coord.setY(Game.getBallY0());
			randomVelocity();
		}

		if(intersection(Game.getTab(1).getRet(),newCircle)){
			if(intersection(Game.getTab(1).getRet(),newCircleTest)){
				vy=-vy;
			}
			else{
				vx=-vx;
			}
		}
		else if(intersection(Game.getTab(2).getRet(),newCircle)){
			if(intersection(Game.getTab(2).getRet(),newCircleTest)){
				vy=-vy;
			}
			else{
				vx=-vx;
			}
		}
		
		coord.setX(coord.getX()+vx);
		coord.setY(coord.getY()+vy);
	}
}
