package uos.assignment.view;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import uos.assignment.controller.eventhandler.ChangeView;
import uos.assignment.controller.sound.ButtonEvent;
import uos.assignment.controller.sound.GenerateSound;
import uos.assignment.model.GameObjectFactory;
import uos.assignment.model.Keyword;

/**
 * The Class MainMenu to display the main menu.
 * It has nine field variables.
 * 
 * @version 1.0
 */
public class MainMenu 
{
	private Pane root;
	private Canvas canvas = new Canvas(1000, 650); 
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private ImageView background = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.BACKGROUND, 0, 0).getImg()));
	private GenerateSound generateSound = new GenerateSound(); // facade pattern (s)
	private Rectangle welcomeFrame = new Rectangle();
	private Label welcomeText = new Label();
	private Button startButton = new Button();
	private Hyperlink aboutButton = new Hyperlink();
	
	/**
	 * Instantiates a new main menu.
	 *
	 * @param stage the stage
	 */
	public MainMenu(Stage stage) 
	{
		root = new Pane();
		gc = canvas.getGraphicsContext2D();		
		gc.setFill(Color.AQUAMARINE);	
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());	
		
		generateSound.playMain();
		
		background.setFitHeight(650);
		background.setFitWidth(1000);
		background.setPreserveRatio(false);		
		background.setOnMouseClicked(e -> generateSound.playBackground());
		welcomeFrame.setX(0);
		welcomeFrame.setY(110);
		welcomeFrame.setWidth(1000);
		welcomeFrame.setHeight(100);
		welcomeFrame.setFill(Color.RED);
		welcomeFrame.opacityProperty().set(0.5);		
	    
	    welcomeText.setText("WELCOME");
	    welcomeText.setFont(Font.font("Arial Rounded MT Bold", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 100));
	    welcomeText.setAlignment(Pos.CENTER);
	    welcomeText.setTextFill(Color.BLACK);
	    welcomeText.minWidthProperty().bind(root.widthProperty());
	    welcomeText.setTranslateY(100);	    
	    
	    startButton.setText("START");
	    startButton.setTranslateX(300);
	    startButton.setMinWidth(400);
	    startButton.setTranslateY(400);
	    startButton.setMinHeight(100);
	    startButton.setFont(Font.font("Verdana Bold", FontWeight.BOLD, FontPosture.ITALIC, 40));
	    startButton.setStyle(Keyword.BUTTON);
	    startButton.setOnMouseEntered(e ->  new ButtonEvent(Keyword.ENTERED, startButton)); // hover
	    startButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED, startButton)); // normal
	    startButton.setOnMousePressed(e -> new ButtonEvent(Keyword.PRESSED, startButton)); // focused	    
	    startButton.setOnAction(e -> new ChangeView(Keyword.MTP, stage, generateSound)); // Strategy pattern (b)  	    	    
	    
	    aboutButton.setText("about");
	    aboutButton.setFont(new Font("Verdana Regular", 20));
	    aboutButton.setTranslateX((canvas.getWidth()-aboutButton.getWidth())/2-35);
	    aboutButton.setTranslateY(590);
	    aboutButton.setStyle(Keyword.ABOUT_BUTTON);
	    aboutButton.setOnMouseEntered(e -> aboutButton.setStyle(Keyword.ABOUT_BUTTON_ENTERED)); // hover
	    aboutButton.setOnMouseExited(e -> aboutButton.setStyle(Keyword.ABOUT_BUTTON)); // normal
	    aboutButton.setOnMousePressed(e -> aboutButton.setStyle(Keyword.ABOUT_BUTTON_PRESSED)); // focused
	    aboutButton.setOnAction(e -> new ChangeView(Keyword.MTA, stage, generateSound)); // strategy pattern (b)
	    
		root.getChildren().add(canvas);
		root.getChildren().add(background);
		root.getChildren().add(welcomeFrame);
		root.getChildren().add(welcomeText);
		root.getChildren().add(startButton);
		root.getChildren().add(aboutButton);		
	}
	
	/**
	 * Gets the root.
	 *
	 * @return the root
	 */
	public Pane getRoot() 
	{
		return root;
	}
}