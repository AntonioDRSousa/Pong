public class Point{
	private double x;
	private double y;

	public Point(double a,double b){
		x=a;
		y=b;
	}

	public void setX(double a){
		x=a;
	}

	public void setY(double a){
		y=a;
	}

	public void setPosition(double a, double b){
		setX(a);
		setY(b);
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}
	
}
