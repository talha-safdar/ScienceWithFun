package uos.assignment.controller;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uos.assignment.model.Flash;
import uos.assignment.model.GameObject;
import uos.assignment.view.PlayGame;
import javafx.event.EventHandler;

/**
 * The Class MovePlayer to move the character around the maze.
 * It has three field variables.
 * 
 * @version 1.0
 */
public class MovePlayer implements EventHandler<KeyEvent> 
{	
	private Flash gameObject;
	private int up = 1, down = 2, left = 3, right = 4;
	private int checkCollission;

	/**
	 * Instantiates a new move player.
	 *
	 * @param gameObject the game object
	 * @param animationTimer the animation timer
	 * @param checkCollision the check collision
	 */
	public MovePlayer(GameObject gameObject, int checkCollision) 
	{
		super();
		this.gameObject = (Flash) gameObject; // cast to Flash because is a sub-type
		this.checkCollission = checkCollision;		
	}

	/**
	 * the method handle to move the character and record the direction.
	 * it increases the number of hits when hit.
	 *
	 * @param keyEvent the key event
	 */
	@Override
	public void handle(KeyEvent keyEvent) 
	{
		if(checkCollission == 0)
		{			
			if(keyEvent.getCode() == KeyCode.D) 
			{
				gameObject.moveRight();
				PlayGame.direction = 1; // left
			}
			if(keyEvent.getCode() == KeyCode.A) 
			{
				gameObject.moveLeft();
				PlayGame.direction = 2; // right
			}
			if(keyEvent.getCode() == KeyCode.S) 
			{
				gameObject.moveDown();
				PlayGame.direction = 3; // up
			}
			if(keyEvent.getCode() == KeyCode.W) 
			{
				gameObject.moveUp();
				PlayGame.direction = 4; // down
			}	
		}
		else if (checkCollission == up)
		{
			if(keyEvent.getCode() == KeyCode.S) 
			{
				PlayGame.outOfScore++; // increase hit score by one
				PlayGame.scoreInfo.setText("Hits: " + PlayGame.outOfScore + " / " + DifficultyLevel.getDifficultyLevel()); // update view
				gameObject.moveDown(); // move down
			}		
		}
		else if (checkCollission == down)
		{
			if(keyEvent.getCode() == KeyCode.W) 
			{
				PlayGame.outOfScore++;
				PlayGame.scoreInfo.setText("Hits: " + PlayGame.outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
				gameObject.moveUp();
			}	
		}
		else if (checkCollission == left)
		{
			if(keyEvent.getCode() == KeyCode.D) 
			{
				PlayGame.outOfScore++;
				PlayGame.scoreInfo.setText("Hits: " + PlayGame.outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
				gameObject.moveRight();
			}
		}
		else if (checkCollission == right)
		{
			if(keyEvent.getCode() == KeyCode.A) 
			{
				PlayGame.outOfScore++;
				PlayGame.scoreInfo.setText("Hits: " + PlayGame.outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
				gameObject.moveLeft();
			}
		}
	}
}