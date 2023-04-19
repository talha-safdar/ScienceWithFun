package uos.assignment.controller.eventhandler;

import javafx.stage.Stage;
import uos.assignment.controller.sound.GenerateSound;
import uos.assignment.model.Keyword;
import uos.assignment.view.About;
import uos.assignment.view.ChooseDifficulty;
import uos.assignment.view.MainMenu;
import uos.assignment.view.PlayGame;

/**
 * The Class ManageView implements the interface Eventhandler.
 * 
 * @version 1.0
 */
public class ManageView implements Eventhandler
{
	
	/**
	 * override execute method to change the view.
	 *
	 * @param viewTo the name of the view
	 * @param stage the stage of the current view
	 * @param generateSound the sound of the current view
	 */
	@Override
	public void execute(String viewTo, Stage stage, GenerateSound generateSound) 
	{
		if(viewTo.equals(Keyword.MTA)) // if MainMenu to About 
		{
			About view = new About(stage); // new stage
			stage.getScene().setRoot(view.getRoot()); // set new view
			stage.setTitle("About"); // set title
			generateSound.stopMain(); // stop sound
		}
		else if(viewTo.equals(Keyword.ATM)) // if About to MainMenu
		{			
			MainMenu view = new MainMenu(stage);
			stage.getScene().setRoot(view.getRoot());
			stage.setTitle("Sciene with Fun");
		}	
		else if(viewTo.equals(Keyword.MTP)) // if MainMenu to PlayGame
		{			
			PlayGame view = new PlayGame(stage);
			generateSound.stopMain();
			stage.getScene().setRoot(view.getRoot());
			stage.setTitle("Sciene with Fun");
		}	
		else if(viewTo.equals(Keyword.PTM)) // if PlayGame to MainMenu
		{			
			MainMenu view = new MainMenu(stage);
			generateSound.stopGame();
			stage.getScene().setRoot(view.getRoot());
			stage.setTitle("Science with Fun");
		}	
		else if(viewTo.equals(Keyword.PTC)) // if PlayGame to ChooseDifficulty
		{			
			ChooseDifficulty view = new ChooseDifficulty(stage);
			generateSound.stopGame();	
			stage.getScene().setRoot(view.getRoot());
			stage.setTitle("Choose difficulty");
		}	
		
		else if(viewTo.equals(Keyword.CTP)) // if ChooseDifficulty to PlayGame
		{			
			PlayGame view = new PlayGame(stage);
			stage.getScene().setRoot(view.getRoot());
			stage.setTitle("Sciene with Fun");
			generateSound.stopMain();
		}		
	}
}