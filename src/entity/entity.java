package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import GAME.Handler;
import GAME.ID;

public abstract class entity {
	
	/*
	 PLAYER物件的父類別
	 含方法和其他變數
	 */
		
	/**x座標*/public static int x;
	/**y座標*/public static int y;
	/**width變數*/public int width;
	/**height變數*/public int height;	
	public boolean solid;
	//public boolean jumping = false; //J
	//public boolean falling = true; //F
	/**x y座標移動量*/public int velX,velY;	
	public ID id;
	public Handler handler;
	
	//public double gravity= 0.0; //G	
	/**
	 方法entity說明
	 @param x x座標
	 @param y y座標
	 @param width width變數
	 @param height height變數
	 @param id 自己取的物件名稱
	 @param handler Handler物件
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
	 位置物件與圖片設定的方法
	 */
	public abstract void render(Graphics g);	
	public abstract void tick();
	/**
	 移除物件
	 */
	public void die(){
		handler.removeEntity(this);
	}
	/**
	 得到X座標
	 */
	public static int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	/**
	 得到Y座標
	 */
	public static int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 得到ID
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
