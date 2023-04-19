package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Confetti to generate the confetti gif for the victory.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Confetti extends GameObject 
{	
	/**
	 * Instantiates a new confetti.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Confetti(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "confetti.gif"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "confetti.gif"));
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