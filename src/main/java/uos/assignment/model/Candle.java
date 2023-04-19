package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Candle to generate the candle image.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Candle extends GameObject 
{	
	/**
	 * Instantiates a new candle.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Candle(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "candle.png"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "candle.png"));
		}	
	}
	
	/**
	 * The method move to draw image.
	 */
	@Override
	public void move()
	{
		gc.drawImage(img,x,y, 100, 100);
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Override
	public Image getImg()
	{
		return this.img;
	}
}