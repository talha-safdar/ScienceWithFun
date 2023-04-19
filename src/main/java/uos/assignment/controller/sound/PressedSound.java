package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;

/**
 * The Class PressedSound to play audio when click on button.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class PressedSound implements Sound 
{
	private AudioClip pressedSound;
	
	/**
	 * Instantiates a new pressed sound.
	 */
	public PressedSound() 
	{
		if(Game.IS_JAR)
		{
			pressedSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/clickButton.mp3").toExternalForm());
		}
		else
		{
			pressedSound = new AudioClip(this.getClass().getResource("/media/audio/clickButton.mp3").toExternalForm());
		}		
		pressedSound.setVolume(0.1);
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		pressedSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound() 
	{
		pressedSound.stop();
	}
}