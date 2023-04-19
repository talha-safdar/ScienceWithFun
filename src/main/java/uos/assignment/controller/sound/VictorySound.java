package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import uos.assignment.Game;

/**
 * The Class VictorySound to play the victory sound.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class VictorySound implements Sound
{
	private AudioClip victorySound;
	
	/**
	 * Instantiates a new victory sound.
	 */
	public VictorySound() 
	{
		if(Game.IS_JAR)
		{
			victorySound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/victory.mp3").toExternalForm()); 
		}
		else
		{
			victorySound = new AudioClip(this.getClass().getResource("/media/audio/victory.mp3").toExternalForm());
		}			
		victorySound.setVolume(0.1);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		victorySound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		victorySound.stop();	
	}
}