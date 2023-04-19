package uos.assignment.controller.eventhandler;

import javafx.stage.Stage;
import uos.assignment.controller.sound.GenerateSound;

/**
 * The Interface Eventhandler has one signature to change view.
 * 
 * @version 1.0
 */
public interface Eventhandler 
{	
	/**
	 * execute method to change the view.
	 *
	 * @param viewTo the name of the view
	 * @param stage the stage of the current view
	 * @param generateSound the sound of the current view
	 */
	void execute(String viewTo, Stage stage, GenerateSound generateSound);
}