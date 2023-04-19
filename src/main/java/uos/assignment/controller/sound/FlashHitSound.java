package uos.assignment.controller.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uos.assignment.Game;

/**
 * The Class FlashHitSound for the flash when hits.
 * It has two field variables
 * 
 * @version 1.0
 */
public class FlashHitSound implements Sound  
{	
	private Media hit;
	private MediaPlayer flashHitSound;
	
	/**
	 * Instantiates a new flashHitSound.
	 */
	public FlashHitSound() 
	{
		if(Game.IS_JAR)
		{
			hit = new Media(ClassLoader.getSystemResource("resources/media/audio/hit.mp3").toExternalForm());
		}
		else
		{
			hit = new Media(this.getClass().getResource("/media/audio/hit.mp3").toExternalForm());
		}					
		flashHitSound = new MediaPlayer(hit);
		flashHitSound.setVolume(0.1);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		flashHitSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		if(Game.IS_JAR)
		{
			hit = new Media(ClassLoader.getSystemResource("resources/media/audio/hit.mp3").toExternalForm());	
		}
		else
		{
			hit = new Media(this.getClass().getResource("/media/audio/hit.mp3").toExternalForm());
		}							
		flashHitSound = new MediaPlayer(hit);
		flashHitSound.setVolume(0.1);
	}		
}