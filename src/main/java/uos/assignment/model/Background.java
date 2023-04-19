package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Background to generate the background image for the main menu.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Background extends GameObject 
{	
	/**
	 * Instantiates a new background.
	 *
	 * @param gc the graphic context
	 * @param x the top
	 * @param y the left
	 */
	public Background(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y); // superclass constructor
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "background.png"));
		}
		else
		{
			img = new Image(getClass().getResource(resourceIn + "background.png").toExternalForm());
		}
		
	}
	
	/**
	 * the method move to draw image.
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