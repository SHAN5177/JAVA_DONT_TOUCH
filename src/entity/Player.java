package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import GAME.Game;
import GAME.Handler;
import GAME.ID;
import tile.CHKWIN;
import tile.Tile;

public class Player extends entity{

	public Player(int x, int y, int width, int height, boolean solid, ID id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}
	
	Image image;
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		
		try {
            image = ImageIO.read(new File("player.png"));
        }
        catch (Exception ex) {
            System.out.println("No example.png!!");
        }
         
        g.drawImage(image,x, y, width, height,null);
		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		if(x<=0)x=0;
		if(y<=0)y=0;
		
		if(x+width>=3500) x=3500-width;
		if(y+height>=2500) y=2500-width;
		
		for(Tile t:handler.tile){
			if(!t.solid) break;
			if(t.getID()==ID.wall){
				
				if(getBoundsTop().intersects(t.getBounds())){
					setVelY(0);
					y = t.getY()+t.height;
					if(t.getID()==ID.wall) Game.Die();
					die();
					//Tile.die();
				}
				if(getBoundsBottom().intersects(t.getBounds())){
					setVelY(0);
					y = t.getY()-t.height;
					if(t.getID()==ID.wall) Game.Die();
					die();
				}
				if(getBoundsLeft().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()+t.width;
					if(t.getID()==ID.wall) Game.Die();
					die();
				}
				if(getBoundsRight().intersects(t.getBounds())){
					setVelX(0);
					x = t.getX()-t.width;
					if(t.getID()==ID.wall) Game.Die();
					die();
					//if(t.getID()==ID.rb) Game.switchLevel();
				}				
			}	
			
			
			if(t.getID()==ID.rb){
				
				if(getBoundsTop().intersects(t.getBounds())){
					if(t.getID()==ID.rb) Game.switchLevel();
					die();
				}
				if(getBoundsBottom().intersects(t.getBounds())){
					if(t.getID()==ID.rb) Game.switchLevel();
					die();
				}
				if(getBoundsLeft().intersects(t.getBounds())){
					if(t.getID()==ID.rb) Game.switchLevel();
					die();
				}
				if(getBoundsRight().intersects(t.getBounds())){
					if(t.getID()==ID.rb) Game.switchLevel();
					die();
				}	

			}	
			
		}
	}

}
