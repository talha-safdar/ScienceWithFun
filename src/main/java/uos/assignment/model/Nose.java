package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Nose to generate the nose image.
 * 
 * @version 1.0
 */
public class Nose extends GameObject 
{	
	/**
	 * Instantiates a new nose.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Nose(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "nose.png"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "nose.png"));
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