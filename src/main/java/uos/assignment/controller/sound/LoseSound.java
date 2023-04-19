package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;

/**
 * The Class LoseSound for the lose audio.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class LoseSound implements Sound
{
	private AudioClip loseSound;
	
	/**
	 * Instantiates a new lose sound.
	 */
	public LoseSound() 
	{
		if(Game.IS_JAR)
		{
			loseSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/lost.mp3").toExternalForm()); 
		}
		else
		{
			loseSound = new AudioClip(this.getClass().getResource("/media/audio/lost.mp3").toExternalForm());
		}			
		loseSound.setVolume(0.1);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		loseSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		loseSound.stop();		
	}
}