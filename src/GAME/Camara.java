package GAME;

import entity.entity;

public class Camara {
	
	public int x,y;
	
	public void tick(entity player){
		setX(-player.getX()+Game.WIDTH/2+100);
		setY(-player.getY()+Game.HEIGHT/2+200);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
