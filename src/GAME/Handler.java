package GAME;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import entity.Player;
import entity.entity;
import tile.CHKWIN;
import tile.Tile;
import tile.Wall;
import tile.WinRb;

public class Handler {
	
	public LinkedList<entity> entity=new LinkedList<entity>();
	public LinkedList<Tile> tile=new LinkedList<Tile>();
	
	public Handler(){
		createLevel();	
	}
	
	public void render(Graphics g){
		for(entity en:entity){
			en.render(g);
		}
		for(Tile ti:tile){
			ti.render(g);
		}
	}
	
	public void tick(){
		for(entity en:entity){
			en.tick();
		}
		for(Tile ti:tile){
			ti.tick();
		}
	}
	
	public void addEntity(entity en){
		entity.add(en);
	}
	public void removeEntity(entity en){
		entity.remove(en);
	}
	public void addTile(Tile ti){
		tile.add(ti);
	}
	public void removeTile(Tile ti){
		tile.remove(ti);
	}
	
	public void createLevel(){
		

		for(int i=0;i<Game.HEIGHT*Game.SCALE/64-2;i++){
			addTile(new Wall(64,i*64+64*2,64,64,true,ID.wall,this));
		}
		
		for(int i=0;i<580*Game.SCALE/64+20;i++){
			addTile(new Wall(i*64,Game.HEIGHT*Game.SCALE-64,64,64,true,ID.wall,this));
			addTile(new Wall(i*64,100,64,64,true,ID.wall,this));
		//	if(i!=0&&i!=1&&i!=16&&i!=17) addTile(new Wall(i*64,300,64,64,true,ID.wall,this));
		}
		
		for(int i=0;i<8;i++)addTile(new WinRb(3390,i*64+180,64,64,true,ID.rb,this));
		
		for(int i=0;i<10;i++){
			addTile(new Wall(3500,i*64+100,64,64,true,ID.wall,this));
		}
		
		//---------------------------¬W¤l------------------------//
		int j=10;
		for(int i=0;i<2;i++){
			for(int k=1;k<5;k+=1){
				addTile(new Wall(64*j*k,i*64+64*2,64,64,true,ID.wall,this));
			}
		}
		
		for(int i=0;i<4;i++){
			for(int k=1;k<5;k+=2){
				addTile(new Wall(64*j*k,i*64+64*7,64,64,true,ID.wall,this));
			}
		}
		for(int i=0;i<4;i++){
			for(int k=1;k<3;k+=1){
				addTile(new Wall(64*j*k,i*64+64*7,64,64,true,ID.wall,this));
			}
		}
		
		j+=3;
		for(int i=0;i<4;i++){
			for(int k=2;k<5;k+=2){
				addTile(new Wall(64*j*k,i*64+64*2,64,64,true,ID.wall,this));
			}			
		}
		
		for(int i=0;i<5;i++){
			addTile(new Wall(64*j*3-64*2,i*64+64*6,64,64,true,ID.wall,this));	
		}
		

		j+=2;
		
		for(int i=0;i<3;i++){
			for(int k=3;k<6;k+=2){
				addTile(new Wall(64*j*k,i*64+64*2,64,64,true,ID.wall,this));
			}
		}
		for(int i=0;i<3;i++){
			for(int k=3;k<6;k+=2){
				addTile(new Wall(64*j*k,i*64+64*8,64,64,true,ID.wall,this));
			}
		}
		
/*
		for(int i=0;i<4;i++){
			for(int k=1;k<6;k+=2){
				addTile(new Wall(64*j*k,i*64+64*2,64,64,true,ID.wall,this));
				//System.out.println(64*j*k);
			}
			
		}
		j+=1;
		for(int i=0;i<5;i++){
				addTile(new Wall(64*j*2,i*64+64*6,64,64,true,ID.wall,this));
				
		}
*/		
		//---------------------------¬W¤l------------------------// 

		
		
	/*	int width = level.getWidth();
		int height = level.getHeight();
		
		for(int y=0;y<height;y++){
			for(int x=0;x<width;x++){
				int pixel = level.getRGB(x, y);
				
				int red = (pixel>>16) &0xff;
				int blue = (pixel) &0xff;
				
				if(red==0&&blue==0) addTile(new Wall(x*64,y*64,64,64,true,ID.wall,this));
				if(red==0&&blue==255) addTile(new Wall(x*64,y*64,64,64,false,ID.player,this));
			}
		}
		*/
	}

}
