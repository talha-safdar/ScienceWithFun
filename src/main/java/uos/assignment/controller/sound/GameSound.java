package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import uos.assignment.Game;

/**
 * The Class GameSound for the main background song.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class GameSound implements Sound  
{
	private AudioClip gameSound;
	
	/**
	 * Instantiates a new game sound.
	 */
	public GameSound() 
	{
		if(Game.IS_JAR)
		{
			gameSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/gameMusic.mp3").toExternalForm()); 
		}
		else
		{
			gameSound = new AudioClip(this.getClass().getResource("/media/audio/gameMusic.mp3").toExternalForm());
		}		
		gameSound.setVolume(0.1);
		gameSound.setCycleCount(MediaPlayer.INDEFINITE);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		gameSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		gameSound.stop();	
	}
}