package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;
/**
 * The Class FlashSound for the audio of the flash when appears.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class FlashSound implements Sound  
{
	private AudioClip flashSound;
	
	/**
	 * Instantiates a new flashSound.
	 */
	public FlashSound() 
	{
		if(Game.IS_JAR)
		{
			flashSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/flashAppear.mp3").toExternalForm()); 
		}
		else
		{
			flashSound = new AudioClip(this.getClass().getResource("/media/audio/flashAppear.mp3").toExternalForm());
		}			
		flashSound.setVolume(0.1);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		flashSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		flashSound.stop();	
	}
}