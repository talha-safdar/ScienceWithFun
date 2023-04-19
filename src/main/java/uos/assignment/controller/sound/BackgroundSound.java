package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;

/**
 * The Class BackgroundSound for the background music when playing.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class BackgroundSound implements Sound  
{
	private AudioClip backgroundSound; // define AudioClip
	
	/**
	 * Instantiates a new backgroundSound.
	 */
	public BackgroundSound() 
	{
		if(Game.IS_JAR)
		{
			backgroundSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/noseHonk.mp3").toExternalForm()); 
		}
		else
		{
			backgroundSound = new AudioClip(this.getClass().getResource("/media/audio/noseHonk.mp3").toExternalForm());
		}					
		backgroundSound.setVolume(0.1);	// set the volume
	}
	
	/**
	 * Gets the sound
	 */
	@Override
	public void getSound() 
	{
		backgroundSound.play();		
	}
	
	/**
	 * Stops the sound
	 */
	@Override
	public void stopSound()
	{
		backgroundSound.stop();	
	}
}