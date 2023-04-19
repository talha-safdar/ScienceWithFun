package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * The abstract Class GameObject to generate all the graphical elements.
 * It has eight field variables.
 * 
 * @version 1.0
 */
public class GameObject 
{
	protected String resource = "resources/media/images/"; // for jar export
	protected String resourceIn = "/media/images/"; // foe development
	protected GraphicsContext gc;
	protected Image img;
	protected double x, y;
	protected double dx=1, dy=1;
	protected double width, height;
	public Rectangle r;
	
	/**
	 * Instantiates a new game object.
	 *
	 * @param gc the graphic context
	 * @param x the x
	 * @param y the y
	 */
	public GameObject(GraphicsContext gc, double x, double y)
	{
		this.gc=gc;
		this.x=x;
		this.y=y;
		r=new Rectangle(0,0,width,height);
	}
	
	/**
	 * the update method to draw the rectangle around the image.
	 */
	protected void update()
	{
		if(img!=null)
		{
			gc.drawImage(img, x, y, 30, 30);
		}
	}
	
	/**
	 * The method move to draw image.
	 */
	public void move()
	{
		x+=dx;
		if(x>(800-width))
		{
			dx=-dx;
		}
		if(x<0)
		{
			dx=-dx;
		}
		y+=dy;
		if(y>(600-height))
		{
			dy=-dy;
		}
		if(y<0)
		{
			dy=-dy;
		}
		gc.drawImage(img,x,y,width,height);
		updateRectangle();
	}
	
	/**
	 * Update rectangle.
	 */
	public void updateRectangle()
	{
		r.setX(x);
		r.setY(y);
		r.setWidth(width);
		r.setHeight(height);
	}
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Image getImg()
	{
		return this.img;
	}
}