import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pong extends JFrame{
	private static final int width=600;
	private static final int height=600;
	private static final int widthField=600;
	private static final int heightField=400;
	
	public static Pong screen;

	//KeyListeners of game
	private KeyListener keyBegin;
	private KeyListener keyEnd;
	private Key keyGame;

	private static JLabel score;
	
	public Pong(){
		editScreen();
		initKeys();
		begin();
	}

	//init KeyListeners of game
	private void initKeys(){
		keyBegin=new KeyListener(){
			public void keyTyped(KeyEvent e){
			}
			public void keyReleased(KeyEvent e){
			}
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					getContentPane().removeAll();
					removeKeyListener(keyBegin);
					new newGame().execute();
				}	
			}
		};

		keyGame=new Key();

		keyEnd=new KeyListener(){
			public void keyTyped(KeyEvent e){
			}
			public void keyReleased(KeyEvent e){
			}
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					getContentPane().removeAll();
					removeKeyListener(keyEnd);
					begin();
				}	
			}
		};
	}

	//initial screen
	private void begin(){
		//game's name
		JLabel title=new JLabel("PONG");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Courier New",Font.BOLD,100));
		title.setForeground(Color.WHITE);
		title.setBounds(150,150,300,150);
		add(title);
		revalidate();
		repaint();

		//information keyboard
		JLabel information=new JLabel("PRESS SPACE FOR PLAY");
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setFont(new Font("Courier New",Font.BOLD,30));
		information.setForeground(Color.WHITE);
		information.setBounds(100,400,400,150);
		add(information);
		revalidate();
		repaint();
		
		addKeyListener(keyBegin);
	}

	//end of game
	public void end(int player,int scoreP1,int scoreP2){
		getContentPane().removeAll();
		removeKeyListener(keyGame);

		//information of winner player
		JLabel vic=new JLabel("PLAYER "+player+" WIN");
		vic.setHorizontalAlignment(SwingConstants.CENTER);
		vic.setFont(new Font("Courier New",Font.BOLD,50));
		vic.setForeground(Color.WHITE);
		vic.setBounds(50,150,500,150);
		add(vic);
		revalidate();
		repaint();

		//information of final score
		JLabel endScore=new JLabel(scoreP1+" X "+scoreP2);
		endScore.setHorizontalAlignment(SwingConstants.CENTER);
		endScore.setFont(new Font("Courier New",Font.BOLD,50));
		endScore.setForeground(Color.WHITE);
		endScore.setBounds(50,300,500,100);
		add(endScore);
		revalidate();
		repaint();

		//information keyboard
		JLabel information=new JLabel("PRESS SPACE FOR RETURN");
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setFont(new Font("Courier New",Font.BOLD,30));
		information.setForeground(Color.WHITE);
		information.setBounds(100,400,400,150);
		add(information);
		revalidate();
		repaint();

		addKeyListener(keyEnd);
	}

	//private class, that star the game
	private class newGame extends SwingWorker{
		public Object doInBackground()throws Exception{
			addKeyListener(new Key());//keys of game

			//put game's panel
			Paint p1=new Paint();
			p1.setBounds(0,100,widthField,heightField);
			add(p1);	
			revalidate();
			repaint();

			//put score's panel of game
			score=new JLabel();
			score.setBounds(200,25,200,50);
			score.setHorizontalAlignment(SwingConstants.CENTER);
			score.setFont(new Font("Courier New",Font.BOLD,30));
			score.setForeground(Color.WHITE);
			add(score);
			revalidate();
			repaint();
		
			Game.initGame();//init the game
			
			return null;
		}
	}

	//edit screen
	private void editScreen(){
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,height);
		setLocationRelativeTo(null);
		setTitle("PONG");
		setResizable(false);
		setVisible(true);
	}

	//get's methods
	public static int getWidthField(){
		return widthField;
	}
	public static int getHeightField(){
		return heightField;
	}
	public static JLabel getScore(){
		return score;
	}

	public static void main(String[] argc){
		screen=new Pong();
	}
}
