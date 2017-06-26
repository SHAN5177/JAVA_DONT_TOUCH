package tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import GAME.Handler;
import GAME.ID;

public class WinRb extends Tile{

	public WinRb(int x, int y, int width, int height, boolean solid, ID id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}
Image image;
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.RED);
		
		
		try {
            image = ImageIO.read(new File("RB.png"));
        }
        catch (Exception ex) {
            System.out.println("No example.jpg!!");
        }
         
        g.drawImage(image,x, y, width, height,null);
        //g.fillRect(x, y, width, height);
	}
	

	@Override
	public void tick() {}

}
