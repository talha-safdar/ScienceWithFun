package uos.assignment.controller.sound;

/**
 * The Class GenerateSound to generate sound.
 * It uses class objects to play the appropriate audio.
 * It has nine field variables.
 * 
 * Facade pattern used.
 * 
 * @version 1.0
 */
public class GenerateSound 
{
	private Sound hoverSound;
	private Sound pressedSound;
	private Sound mainSound;
	private Sound gameSound;
	private Sound flashSound;
	private Sound victorySound;
	private Sound loseSound;
	private Sound flashHitSound;
	private Sound backgroundSound;
	
	/**
	 * Instantiates a new generate sound.
	 */
	public GenerateSound() 
	{
		hoverSound = new HoverSound();
		pressedSound = new PressedSound();
		mainSound = new MainSound();
		gameSound = new GameSound();
		flashSound = new FlashSound();
		victorySound = new VictorySound();
		loseSound = new LoseSound();
		flashHitSound = new FlashHitSound();
		backgroundSound = new BackgroundSound();
	}
	
	/**
	 * Play hover.
	 */
	public void playHover()
	{
		hoverSound.getSound();
	}	
	
	/**
	 * Play pressed.
	 */
	public void playPressed()
	{
		pressedSound.getSound();
	}
	
	/**
	 * Play main.
	 */
	public void playMain()
	{
		mainSound.getSound();
	}
	
	/**
	 * Stops main.
	 */
	public void stopMain()
	{
		mainSound.stopSound();
	}
	
	/**
	 * Play game.
	 */
	public void playGame()
	{
		gameSound.getSound();
	}
	
	/**
	 * Stops game.
	 */
	public void stopGame()
	{
		gameSound.stopSound();
	}
	
	/**
	 * Play flash.
	 */
	public void playFlash()
	{
		flashSound.getSound();
	}
	
	/**
	 * Play victory.
	 */
	public void playVictory()
	{
		victorySound.getSound();
	}
	
	/**
	 * Play lose.
	 */
	public void playLose()
	{
		loseSound.getSound();
	}
	
	/**
	 * Play hit.
	 */
	public void playHit()
	{
		flashHitSound.getSound();
	}
	
	/**
	 * stops hit.
	 */
	public void stopHit()
	{
		flashHitSound.stopSound();
	}
	
	/**
	 * Play background song.
	 */
	public void playBackground()
	{
		backgroundSound.getSound();
	}
}