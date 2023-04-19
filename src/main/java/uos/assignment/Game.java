package uos.assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uos.assignment.view.MainMenu;

/**
 * The Class Game to start the entire game.
 * It has four field variables.
 * 
 * @version 1.0
 */
public class Game extends Application 
{
	private Scene scene;
	private MainMenu mainMenu;
	private Image icon;	
	public static final boolean IS_JAR = false; // true=export false=develop
	
	/**
	 * The main method.
	 *
	 * @param args the argument
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}

	/**
	 * the start method to change the view
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		if(IS_JAR) // true=export false=develop
		{
			icon = new Image(ClassLoader.getSystemResourceAsStream("resources/media/images/logo.png"));
		}
		else
		{
			icon = new Image(getClass().getResource("/media/images/logo.png").toExternalForm());
		}

		primaryStage.setTitle("Science with Fun");		
		primaryStage.getIcons().add(icon);
		primaryStage.setResizable(false);	
		mainMenu = new MainMenu(primaryStage);
		scene = new Scene(mainMenu.getRoot(), 1000, 650);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}