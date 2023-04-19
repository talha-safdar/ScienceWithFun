package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Brain to generate the brain image.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Brain extends GameObject 
{	
	/**
	 * Instantiates a new brain.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Brain(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "brain.png"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "brain.png"));
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