package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import GAME.Handler;
import GAME.ID;

public abstract class entity {
	
	/*
	 PLAYER���󪺤����O
	 �t��k�M��L�ܼ�
	 */
		
	/**x�y��*/public static int x;
	/**y�y��*/public static int y;
	/**width�ܼ�*/public int width;
	/**height�ܼ�*/public int height;	
	public boolean solid;
	//public boolean jumping = false; //J
	//public boolean falling = true; //F
	/**x y�y�в��ʶq*/public int velX,velY;	
	public ID id;
	public Handler handler;
	
	//public double gravity= 0.0; //G	
	/**
	 ��kentity����
	 @param x x�y��
	 @param y y�y��
	 @param width width�ܼ�
	 @param height height�ܼ�
	 @param id �ۤv��������W��
	 @param handler Handler����
	 */
	public entity(int x,int y,int width,int height,boolean solid,ID id,Handler handler){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;		
		this.id=id;
		this.handler=handler;
		this.solid=solid;
	}
	/**
	 ��m����P�Ϥ��]�w����k
	 */
	public abstract void render(Graphics g);	
	public abstract void tick();
	/**
	 ��������
	 */
	public void die(){
		handler.removeEntity(this);
	}
	/**
	 �o��X�y��
	 */
	public static int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	/**
	 �o��Y�y��
	 */
	public static int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 �o��ID
	 */
	public ID getID() {
		return id;
	}
	public boolean isSolid() {
		return solid;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}	

	public Rectangle getBounds(){
		return new Rectangle(getX(),getY(),width,height);
	}	
	public Rectangle getBoundsTop(){
		return new Rectangle(getX()+10,getY(),width-20,5);
	}
	public Rectangle getBoundsBottom(){
		return new Rectangle(getX()+10,getY()+height-5,width-20,5);
	}
	public Rectangle getBoundsLeft(){
		return new Rectangle(getX(),getY()+10,5,height-20);
	}
	public Rectangle getBoundsRight(){
		return new Rectangle(getX()+width-5,getY()+10,5,height-20);
	}

}
