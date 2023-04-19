package uos.assignment.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uos.assignment.controller.eventhandler.ChangeView;
import uos.assignment.model.GameObjectFactory;
import uos.assignment.model.Keyword;

/**
 * The Class About to display information about the copyright.
 * It has twenty field variables.
 * 
 * @version 1.0
 */
public class About 
{
	private Pane root; // main pane for this view
	private Canvas canvas = new Canvas(1000, 650); // create canvas
	private GraphicsContext gc = canvas.getGraphicsContext2D(); // creative tools
	private Rectangle frame = new Rectangle();
	private Text info = new Text();
	private Text graphical = new Text();
	private Text backgroundBackBox = new Text();
	private Text candle = new Text();
	private Text noseBrainFlash = new Text();
	private Text eyes = new Text();
	private Text hand = new Text();
	private Text confetti = new Text();
	private Text fading = new Text();
	private Text audio = new Text();
	private Text flashAppearGameMusicHitLost = new Text();
	private Text mainMusicVictory = new Text();
	private Text noseHonk = new Text();
	private Button mainMenu = new Button();	
	private ImageView background = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.FADING, 0, 0).getImg()));
	
	/**
	 * Instantiates a new about.
	 *
	 * @param stage the stage
	 */
	public About(Stage stage) 
	{
		root = new Pane();		
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
				
		background.setFitHeight(650);
		background.setFitWidth(1000);
		background.setOpacity(0.3);
		background.setPreserveRatio(false);		
		
		frame.setWidth(500);
		frame.setHeight(500);
		frame.setArcHeight(50);
		frame.setArcWidth(50);
		frame.setX((canvas.getWidth()-frame.getWidth())/2);
		frame.setY((canvas.getHeight()-frame.getHeight())/2-30);
		frame.setFill(Color.WHITE);
		frame.setOpacity(0.9);
		
		info.setText("Copyright list:");
		info.setFont(new Font("Verdana Bold", 20));
		info.setLayoutY(100);
		info.setLayoutX(300);
		
		graphical.setText("Graphical");
		graphical.setFont(new Font("Verdana Bold", 16));
		graphical.setLayoutY(150);
		graphical.setLayoutX(300);	
		
		backgroundBackBox.setText("Background, backgroudMaze, infoBox: own");
		backgroundBackBox.setFont(new Font("Verdana", 12));
		backgroundBackBox.setLayoutY(170);
		backgroundBackBox.setLayoutX(300);		

		candle.setText("candle: Alfredo Hernandez - Flaticon");
		candle.setFont(new Font("Verdana", 12));
		candle.setLayoutY(190);
		candle.setLayoutX(300);
		
		noseBrainFlash.setText("nose, brain, flash: Freepik - Flaticon");
		noseBrainFlash.setFont(new Font("Verdana", 12));
		noseBrainFlash.setLayoutY(210);
		noseBrainFlash.setLayoutX(300);

		eyes.setText("eyes: Smashicons - Flaticon");
		eyes.setFont(new Font("Verdana", 12));
		eyes.setLayoutY(230);
		eyes.setLayoutX(300);
		
		hand.setText("hand, hurtHand: Vitaly Gorbachev - Flaticon");
		hand.setFont(new Font("Verdana", 12));
		hand.setLayoutY(250);
		hand.setLayoutX(300);
		
		confetti.setText("confetti: acegif.com");
		confetti.setFont(new Font("Verdana", 12));
		confetti.setLayoutY(270);
		confetti.setLayoutX(300);
		
		fading.setText("fading: tumblr.com");
		fading.setFont(new Font("Verdana", 12));
		fading.setLayoutY(290);
		fading.setLayoutX(300);
		
		audio.setText("Audio");
		audio.setFont(new Font("Verdana Bold", 16));
		audio.setLayoutY(350);
		audio.setLayoutX(300);	
		
		flashAppearGameMusicHitLost.setText("flashAppear, gameMusic, hit, lost: https://www.zapsplat.com");
		flashAppearGameMusicHitLost.setFont(new Font("Verdana", 12));
		flashAppearGameMusicHitLost.setLayoutY(370);
		flashAppearGameMusicHitLost.setLayoutX(300);
		
		mainMusicVictory.setText("mainMusic, victory: FiftySounds");
		mainMusicVictory.setFont(new Font("Verdana", 12));
		mainMusicVictory.setLayoutY(390);
		mainMusicVictory.setLayoutX(300);
		
		noseHonk.setText("noseHonk: The Arcadian - Youtube");
		noseHonk.setFont(new Font("Verdana", 12));
		noseHonk.setLayoutY(410);
		noseHonk.setLayoutX(300);
		
	    mainMenu.setText("HOME");	    
	    mainMenu.setMinWidth(200);	    
	    mainMenu.setMinHeight(50);
	    mainMenu.setTranslateY(570);
	    mainMenu.setTranslateX(400);
	    mainMenu.setFont(new Font("Verdana Bold", 20));
	    mainMenu.setStyle(Keyword.BUTTON);
	    mainMenu.setOnMouseEntered(e -> mainMenu.setStyle(Keyword.ENTERED_BUTTON)); // hover
	    mainMenu.setOnMouseExited(e -> mainMenu.setStyle(Keyword.BUTTON)); // normal
	    mainMenu.setOnMousePressed(e -> mainMenu.setStyle(Keyword.PRESSED_BUTTON)); // focused
	    mainMenu.setOnAction(e -> new ChangeView(Keyword.ATM, stage, null)); // Strategy pattern (b)
		
		root.getChildren().add(canvas);
		root.getChildren().add(background);
		root.getChildren().add(frame);
		root.getChildren().add(mainMenu);
		root.getChildren().add(info);
		root.getChildren().add(graphical);
		root.getChildren().add(backgroundBackBox);
		root.getChildren().add(candle);
		root.getChildren().add(noseBrainFlash);
		root.getChildren().add(eyes);
		root.getChildren().add(hand);
		root.getChildren().add(confetti);
		root.getChildren().add(fading);
		root.getChildren().add(audio);
		root.getChildren().add(flashAppearGameMusicHitLost);
		root.getChildren().add(mainMusicVictory);
		root.getChildren().add(noseHonk);
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