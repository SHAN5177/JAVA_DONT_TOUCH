package tile;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import GAME.Game;
import GAME.Handler;
import GAME.ID;
import entity.Player;

public class CHKWIN extends Tile{

	public CHKWIN(int x, int y, int width, int height, boolean solid, ID id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}
Image image;
	@Override
	public void render(Graphics g) {
		//g.setColor(Color.RED);
		
		
		try {
            image = ImageIO.read(new File("WIN1.png"));
        }
        catch (Exception ex) {
            System.out.println("No example.jpg!!");
        }
         
        g.drawImage(image,x, y, width, height,null);
        //System.out.println("!!");
        //g.fillRect(x, y, width, height);
	}
	

	@Override
	public void tick() {
	}

}