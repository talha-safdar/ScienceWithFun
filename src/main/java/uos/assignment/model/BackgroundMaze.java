package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class BackgroundMaze to generate the background of the maze.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class BackgroundMaze extends GameObject 
{	
	/**
	 * Instantiates a new background maze.
	 *
	 * @param gc the Graphics context
	 * @param x the top
	 * @param y the left
	 */
	public BackgroundMaze(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "backgroundMaze.png"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "backgroundMaze.png"));
		}	
	}
	
	/**
	 * the method move to draw image.
	 */
	@Override
	public void move()
	{
		gc.drawImage(img,x,y, 1000, 635);
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