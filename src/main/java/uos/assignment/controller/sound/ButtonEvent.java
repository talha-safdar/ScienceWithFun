package uos.assignment.controller.sound;

import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import uos.assignment.model.Keyword;

/**
 * The Class ButtonEvent used to manage the animations and sounds.
 * It has three field variables.
 * 
 * @version 1.0
 */
public class ButtonEvent 
{	
	private Button button;	
	private ToggleButton toggleButton;	
	private GenerateSound generateSound = new GenerateSound(); // initialise GenerateSound
	
	/**
	 * Instantiates a new buttonEvent.
	 *
	 * @param action the action
	 * @param button the button
	 */
	public ButtonEvent(String action, Button button) 
	{
		this.button = button;
		
		if(action.equals(Keyword.ENTERED)) // if cursor hover
		{
			generateSound.playHover();
			this.button.setStyle(Keyword.ENTERED_BUTTON); 
		}
		
		else if(action.equals(Keyword.PRESSED)) // if cursor pressed
		{
			generateSound.playPressed();
			this.button.setStyle(Keyword.PRESSED_BUTTON);
		}
		else if(action.equals(Keyword.EXITED)) // if cursor focus out
		{
			this.button.setStyle(Keyword.BUTTON);
		}
	}
	
	/**
	 * Instantiates a new buttonEvent.
	 *
	 * @param action the action
	 * @param toggleButton the toggle button
	 */
	public ButtonEvent(String action, ToggleButton toggleButton) 
	{
		this.toggleButton = toggleButton;		
		if(action.equals(Keyword.HOVER_EASY)) // if cursor over easy button
		{
			generateSound.playHover();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_EASY_HOVER);
		}		
		else if(action.equals(Keyword.PRESSED_EASY)) // if cursor pressed easy button
		{
			generateSound.playPressed();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_EASY_PRESSED);
		}
		else if(action.equals(Keyword.EXITED_EASY)) // if cursor focused out easy button
		{
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_EASY);
		}
		
		if(action.equals(Keyword.HOVER_NORMAL)) // if cursor hover normal button
		{
			generateSound.playHover();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL_HOVER);
		}		
		else if(action.equals(Keyword.PRESSED_NORMAL)) // if cursor pressed normal button
		{
			generateSound.playPressed();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL_PRESSED);
		}
		else if(action.equals(Keyword.EXITED_NORMAL)) // if cursor focused out normal button
		{
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL);
		}
		
		if(action.equals(Keyword.HOVER_HARD)) // if cursor hover hard button
		{
			generateSound.playHover();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_HARD_HOVER);
		}		
		else if(action.equals(Keyword.PRESSED_HARD)) // if cursor pressed hard button
		{
			generateSound.playPressed();
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_HARD_PRESSED);
		}
		else if(action.equals(Keyword.EXITED_HARD)) // if cursor focused out hard button
		{
			this.toggleButton.setStyle(Keyword.TOGGLE_BUTTON_HARD);
		}
	}
}