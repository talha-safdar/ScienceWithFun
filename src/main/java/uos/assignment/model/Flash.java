package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uos.assignment.Game;

/**
 * The Class Flash to generate the main character flash.
 * It extends GameObject class.
 * 
 * @version 1.0
 */
public class Flash extends GameObject 
{
	private int speed = 16; // the speed of the character
	private int wid = 30; // the width of the image
	private int hei = 50; // the height of the image
	
	/**
	 * Instantiates a new flash.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public Flash(GraphicsContext gc, double x, double y) 
	{
		super(gc, x, y);
		if(Game.IS_JAR)
		{
			img = new Image(ClassLoader.getSystemResourceAsStream(resource + "flash.png"));
		}
		else
		{
			img = new Image(getClass().getResourceAsStream(resourceIn + "flash.png"));
		}	
		width = wid;
		height = hei;
	}

	/**
	 * The method move to draw image.
	 */
	@Override
	public void move()
	{
		gc.drawImage(img,x,y, wid, hei);
		updateRectangle();
	}
	
	/**
	 * Sets the horizontal position.
	 *
	 * @param horizontal the horizontal
	 */
	public void setX(double horizontal)
	{
		this.x = horizontal;
	}
	
	/**
	 * Sets the vertical position.
	 *
	 * @param vertical the vertical
	 */
	public void setY(double vertical)
	{
		this.y = vertical;
	}
	
	/**
	 * The method move to draw image left.
	 */
	public void moveLeft()
	{
		x-= speed;
	}
	
	/**
	 * The method move to draw image right.
	 */
	public void moveRight()
	{
		x+= speed;
	}
	
	/**
	 * The method move to draw image up.
	 */
	public void moveUp()
	{
		y-= speed;
	}
	
	/**
	 * The method move to draw image down.
	 */
	public void moveDown()
	{
		y+= speed;
	}
}