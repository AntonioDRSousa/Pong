import javax.swing.*;
import java.awt.*;

public class Game implements codeKeys{
	public static boolean[] keys;//keys pressed

	//initial coordenates of ball and tabs
	private static final int BallX0=300;
	private static final int BallY0=200;
	private static final int Tab1X0=25;
	private static final int Tab2X0=553;
	private static final int TabY0=150;

	//objects of Game
	private static Tab t1;
	private static Tab t2;
	private static Ball b;

	//score of players
	private static int scoreP1;
	private static int scoreP2;

	//principal method of game
	public static void initGame(){
		initElements();
		initScore();
		keys=new boolean[5];
		boolean paused=false;//pause game
		boolean keyLog=true;//verifica se tecla foi pressionada 1 vez, impede que leia mais que uma pressao de tecla no caso da pausa

		//game loop
		while(true){
			try{Thread.sleep(10);}catch(Exception erro){}

			//pause or unpause the game
			if(Game.keys[b_Space]){
				if(keyLog){
					paused=!paused;
					keyLog=false;
				}
			}
			else{
				keyLog=true;
			}

			if(!paused){//verify if game is paused or not
				b.move();//move ball
				detectMovement();//move tabs
				Pong.getScore().setText(scoreP1+" X "+scoreP2);//update score of game

				//verify if game is finish
				if(scoreP1==3){
					Pong.screen.end(1,scoreP1,scoreP2);
					break;
				}
				else if(scoreP2==3){
					Pong.screen.end(2,scoreP1,scoreP2);
					break;
				}
			}
		}
	}

	//set initial score of game
	private static void initScore(){
		scoreP1=0;
		scoreP2=0;
	}

	//put initial objects in game(ball and tabs)
	private static void initElements(){
		t1=new Tab(Tab1X0,TabY0);
		t2=new Tab(Tab2X0,TabY0);
		b=new Ball(BallX0,BallY0);
	}

	//method of goal
	public static void goal(int player){
		if(player==1){
			scoreP1++;
		}
		else if(player==2){
			scoreP2++;
		}
	}

	//draw objects of game(ball and tabs)
	public static void draw(Graphics2D g){
		try{
			t1.draw(g);
			t2.draw(g);
			b.draw(g);
		}
		catch(Exception e){
		}
	}

 	//verify pressed keys and move tabs
	private static void detectMovement(){
		if(Game.keys[b_W]){
			t1.moveUp();
		}
		if(Game.keys[b_S]){
			t1.moveDown();
		}
		if(Game.keys[b_UP]){
			t2.moveUp();
		}
		if(Game.keys[b_DOWN]){
			t2.moveDown();
		}
	}

	// get's methods
	public static Tab getTab(int i){
		if(i==1){
			return t1;
		}
		else if(i==2){
			return t2;
		}
		return null;
	}
	public static Ball getBall(){
		return b;
	}

	public static int getBallX0(){
		return BallX0;
	}
	public static int getBallY0(){
		return BallY0;
	}	
}
