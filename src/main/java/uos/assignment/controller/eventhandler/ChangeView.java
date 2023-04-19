package uos.assignment.controller.eventhandler;

import javafx.stage.Stage;
import uos.assignment.controller.sound.GenerateSound;

/**
 * 
 * The class ChangeView, is used to change views.
 * It has one field variable.
 * 
 * Strategy design pattern used.
 * 
 * @version 1.0
 * 
 */
public class ChangeView 
{	
	private ManageView manageView = new ManageView(); 
	
	/**
	 * 
	 * Instantiates a new ChangeView using parameters.
	 * 
	 * @param viewTo the view name
	 * @param stage the stage of the current view
	 * @param generateSound the sound of the current view
	 */
	public ChangeView(String viewTo, Stage stage, GenerateSound generateSound) 
	{
		manageView.execute(viewTo, stage, generateSound); // call execute method
	}
}