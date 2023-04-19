package uos.assignment.controller.sound;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import uos.assignment.Game;

/**
 * The Class MainSound to play the main menu song.
 * It has one field variable.
 * 
 * @version 1.0
 */
public class MainSound implements Sound 
{
	private AudioClip mainSound;
	
	/**
	 * Instantiates a new main sound.
	 */
	public MainSound() 
	{
		if(Game.IS_JAR)
		{
			mainSound = new AudioClip(ClassLoader.getSystemResource("resources/media/audio/mainMusic.mp3").toExternalForm()); 
		}
		else
		{
			mainSound = new AudioClip(this.getClass().getResource("/media/audio/mainMusic.mp3").toExternalForm());
		}		
		mainSound.setVolume(0.1);
		mainSound.setCycleCount(MediaPlayer.INDEFINITE);		
	}
	
	/**
	 * Gets the sound.
	 */
	@Override
	public void getSound() 
	{
		mainSound.play();		
	}
	
	/**
	 * Stops the sound.
	 */
	@Override
	public void stopSound()
	{
		mainSound.stop();	
	}
}