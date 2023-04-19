package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;

/**
 * The Class HoverSound for the hover sound.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class HoverSound implements Sound 
{
	private AudioClip hoverSound;
	
	/**
	 * Instantiates a new hover sound.
	 */
	public HoverSound() 
	{
		if(Game.IS_JAR)
		{
			hoverSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/hoverButton.mp3").toExternalForm());
		}
		else
		{
			hoverSound = new AudioClip(this.getClass().getResource("/media/audio/hoverButton.mp3").toExternalForm());
		}		
		hoverSound.setVolume(0.1);		
	}

	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		hoverSound.play();
	}

	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound() 
	{
		hoverSound.stop();
	}
}