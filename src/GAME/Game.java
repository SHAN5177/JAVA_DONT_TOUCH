package GAME;

import java.awt.Canvas;//add picture
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;//make a window
import javax.swing.JOptionPane;

import entity.Player;
import entity.entity;
import input.KeyInput;
import tile.CHKDIE;
import tile.CHKWIN;
import tile.Tile;
import tile.Wall;
import tile.WinRb;

public class Game extends Canvas implements Runnable{ 

	
	public static final int WIDTH = 270, HEIGHT = WIDTH/14*10, SCALE = 4; 
	public static final String TITLE="NYAN SQUARE DON't TOUCH THE WALL";
	
	
	private Thread td; 
//	private static Thread td1;
	private boolean running = false;
//	private BufferedImage image ;	
	
	public static Handler handler;
	public Camara cam; //MAKE PY MD 
	
	
	public int getFrameWidth(){
		return WIDTH*SCALE;
	}
	
	public int getFrameHeight(){
		return HEIGHT*SCALE;
	}	
	
	private synchronized void start(){
		
		if(running) return;
		running = true; 
		td = new Thread(this,"Thread");
		td.start();
		
		//System.out.println("TMD JAVA GAME!!!!");
	}
	
	private synchronized void stop(){
		
		if(!running) return;
		running=false;
		
		
		try {
			td.join(); 
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime(); //目前系統時間
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000.0/60.0;
		int frames = 0;
		int ticks = 0;
		
/*		long now = System.nanoTime();
		System.out.println(now-lastTime);
		//測試last到now經過的時間~~~
*/		
		while(running){	//OUT FRAME 
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns; 
			lastTime = now;
			while(delta>=1){
				tick();
				ticks++;
				delta--;
			} 
			render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000){
				timer+=1000;
				System.out.println(frames+" F PER S /"+ticks+" UD PER S ");
				frames = 0;
				ticks = 0;
			}
			//tick();
		}
		stop();
	}	
	
	
	public void render(){
		
		BufferStrategy bs =this.getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//g.setColor(Color.BLACK);
		g.setColor(new Color(213,207,064));
		//g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		g.fillRect(0, 0,getWidth(),getHeight());
		
		g.translate(cam.getX(), cam.getY());
		handler.render(g);
		g.dispose();
		bs.show();			
	}
	
	
	
	public void tick(){
		handler.tick();
		
		for(entity e:handler.entity){
			
			if(e.getID()==ID.player){
				cam.tick(e);
			}
		}
	}
	

	
	public static void switchLevel(){
		System.out.println(Player.x+"   "+Player.y);

		handler = new Handler();
		handler.addTile(new CHKWIN(Player.x-240,Player.y-295,WIDTH*SCALE+10,HEIGHT*SCALE+10,true,ID.rb,handler));
		//JOptionPane.showMessageDialog(null, "Score=", "Score", JOptionPane.INFORMATION_MESSAGE );
	}
	
	public static void Die(){
		//System.out.println("TMD JAVA GAME!!!!");
		//entity.die();
		handler = new Handler();
		handler.addTile(new CHKDIE(Player.x-240,Player.y-300,WIDTH*SCALE+10,HEIGHT*SCALE+10,true,ID.wall,handler));
	}

	public Game(){
		Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	private void init(){
		handler = new Handler();
		cam = new Camara();
		addKeyListener(new KeyInput());
		handler.addEntity(new Player(300,400,64,64,true,ID.player,handler));
	//	handler.addTile(new WinRb(200,200,64,64,true,ID.wall,handler));
		
	/*	try {
			image = ImageIO.read(getClass().getResource("map.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		handler.createLevel(image);
		*/
	}

	public static void main(String[] args){
		Game game = new Game();
		JFrame jf = new JFrame(TITLE);
		jf.add(game);
		jf.pack();
			
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setVisible(true);
		
		jf.setLocationRelativeTo(null);//WTF is it?
		//jf.setLocation(800,300);//first appearance
		jf.setIconImage(jf.getToolkit().getImage("test.jpg"));//視窗的頭貼
		game.start();
	}

}
