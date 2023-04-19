package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Fading to generate fading gif.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Fading extends GameObject 
{	
	/**
	 * Instantiates a new fading.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Fading(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "fading.gif"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "fading.gif"));
		}					
	}
	
	/**
	 * The method move to draw image.
	 */
	@Override
	public void move()
	{
		gc.drawImage(img,x,y, 1000, 650);
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