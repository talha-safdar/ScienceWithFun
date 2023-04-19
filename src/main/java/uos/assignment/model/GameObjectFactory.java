package uos.assignment.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * A factory for creating GameObject objects.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class GameObjectFactory 
{
	private GraphicsContext gc;

	/**
	 * Instantiates a new game object factory.
	 *
	 * @param gc the graphic context
	 */
	public GameObjectFactory(GraphicsContext gc) 
	{
		this.gc = gc;
	}

	/**
	 * Creates a new GameObject object.
	 *
	 * @param gameObject the game object
	 * @param x the x
	 * @param y the y
	 * @return the game object
	 */
	public GameObject createObject(String gameObject, double x, double y)
	{
		if(gameObject.equals(Keyword.BACKGROUND))
		{
			return new Background(gc, x, y);
		}
		else if(gameObject.equals(Keyword.BACKGROUND_MAZE))
		{
			return new BackgroundMaze(gc, x, y);
		}
		else if(gameObject.equals(Keyword.BRAIN))
		{
			return new Brain(gc, x, y);
		}
		else if(gameObject.equals(Keyword.CANDLE))
		{
			return new Candle(gc, x, y);
		}
		else if(gameObject.equals(Keyword.HAND))
		{
			return new Hand(gc, x, y);
		}
		else if(gameObject.equals(Keyword.CONFETTI))
		{
			return new Confetti(gc, x, y);
		}
		else if(gameObject.equals(Keyword.EYES))
		{
			return new Eyes(gc, x, y);
		}
		else if(gameObject.equals(Keyword.HURT_HAND))
		{
			return new HurtHand(gc, x, y);
		}
		else if(gameObject.equals(Keyword.INFO))
		{
			return new Info(gc, x, y);
		}
		else if(gameObject.equals(Keyword.NOSE))
		{
			return new Nose(gc, x, y);
		}
		else if(gameObject.equals(Keyword.FLASH))
		{
			return new Flash(gc, x, y);
		}
		else if(gameObject.equals(Keyword.FADING))
		{
			return new Fading(gc, x, y);
		}
		return null;
	}
}