package uos.assignment.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import uos.assignment.controller.eventhandler.ChangeView;
import uos.assignment.controller.sound.ButtonEvent;
import uos.assignment.controller.sound.GenerateSound;
import uos.assignment.controller.DifficultyLevel;
import uos.assignment.model.GameObjectFactory;
import uos.assignment.model.Keyword;
import javafx.scene.input.MouseEvent;

/**
 * The Class ChooseDifficulty to change the difficulty level.
 * It as fifteen field variables. 
 * 
 * @version 1.0
 */
public class ChooseDifficulty 
{
	private Pane root;
	private Canvas canvas = new Canvas(1000, 650);
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private ImageView background = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.BACKGROUND, 0, 0).getImg()));
	private GenerateSound generateSound = new GenerateSound(); // facade pattern (s)
	private Rectangle frame = new Rectangle();
	private Label text = new Label();
	private Separator separator = new Separator();
	private ToggleButton easyButton = new ToggleButton();
	private ToggleButton normalButton = new ToggleButton();
	private ToggleButton hardButton = new ToggleButton();
	private ToggleGroup levelGroup = new ToggleGroup();
	private VBox vboxButtons = new VBox();
	private Button confirmButton = new Button();
	private DropShadow shadow = new DropShadow();
	
	/**
	 * Instantiates a new choose difficulty.
	 *
	 * @param stage the stage
	 */
	public ChooseDifficulty(Stage stage) 
	{
		root = new Pane();
		gc = canvas.getGraphicsContext2D();		
		gc.setFill(Color.AQUAMARINE);	
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		generateSound.playMain();
		
		background.setFitHeight(650);
		background.setFitWidth(1000);
		background.setPreserveRatio(false);		
		
		frame.setWidth(500);
		frame.setHeight(500);
		frame.setArcHeight(50);
		frame.setArcWidth(50);
		frame.setX((canvas.getWidth()-frame.getWidth())/2);
		frame.setY((canvas.getHeight()-frame.getHeight())/2);		
		frame.setFill(Color.WHITE);		
		shadow.setRadius(50);
		frame.setEffect(shadow);
			    
		text.setText("Choose Difficulty");
	    text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 48));
	    text.setAlignment(Pos.CENTER);
	    text.setTextFill(Color.BLACK);
	    text.minWidthProperty().bind(root.widthProperty());
	    text.setTranslateY(100);
	    
	    separator.setMinWidth(400);	    
	    separator.setMinHeight(200);
	    separator.setLayoutX((canvas.getWidth()-separator.getMinWidth())/2);
	    separator.setLayoutY(100);	    
	    
		easyButton.setText("Easy");
		easyButton.setSelected(false);
		easyButton.setMinWidth(200);
		easyButton.setFont(new Font("verdana", 25));
		easyButton.setStyle(Keyword.TOGGLE_BUTTON_EASY);
		easyButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.HOVER_EASY, easyButton)); // hover
		easyButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_EASY, easyButton)); // normal
		easyButton.setOnMousePressed(new EventHandler<MouseEvent>() 
		{			
			@Override
			public void handle(MouseEvent event) 
			{				
				if(confirmButton.isDisabled()) { confirmButton.setDisable(false); }
				easyButton.setToggleGroup(levelGroup);
				new ButtonEvent(Keyword.PRESSED_EASY, easyButton); // focused
				easyButton.setOnMouseExited(null);
				normalButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL);
	    		hardButton.setStyle(Keyword.TOGGLE_BUTTON_HARD);
	    		normalButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_NORMAL, normalButton)); // normal
        		hardButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_HARD, hardButton)); // normal
			}
		});
		
		normalButton.setText("Normal");
		normalButton.setMinWidth(200);
		normalButton.setFont(new Font("verdana", 25));
		normalButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL);
		normalButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.HOVER_NORMAL, normalButton)); // hover
		normalButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_NORMAL, normalButton)); // normal
		normalButton.setOnMousePressed(new EventHandler<MouseEvent>() 
		{			
			@Override
			public void handle(MouseEvent event) 
			{
				if(confirmButton.isDisabled()) { confirmButton.setDisable(false); }
				hardButton.setToggleGroup(levelGroup);
				new ButtonEvent(Keyword.PRESSED_NORMAL, normalButton); // focused
				normalButton.setOnMouseExited(null);
				easyButton.setStyle(Keyword.TOGGLE_BUTTON_EASY);
				hardButton.setStyle(Keyword.TOGGLE_BUTTON_HARD);
				easyButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_EASY, easyButton)); // normal
        		hardButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_HARD, hardButton)); // normal
			}			
		});		
		
		hardButton.setText("Hard");
		hardButton.setMinWidth(200);
		hardButton.setFont(new Font("verdana", 25));		
		hardButton.setStyle(Keyword.TOGGLE_BUTTON_HARD);
		hardButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.HOVER_HARD, hardButton)); // hover
		hardButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_HARD, hardButton)); // normal
		hardButton.setOnMousePressed(new EventHandler<MouseEvent>() 
		{			
			@Override
			public void handle(MouseEvent event) 
			{
				if(confirmButton.isDisabled()) { confirmButton.setDisable(false); }
				hardButton.setToggleGroup(levelGroup);
				new ButtonEvent(Keyword.PRESSED_HARD, hardButton);
				hardButton.setOnMouseExited(null);
				easyButton.setStyle(Keyword.TOGGLE_BUTTON_EASY);
				normalButton.setStyle(Keyword.TOGGLE_BUTTON_NORMAL);
				easyButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_EASY, easyButton)); // normal
				normalButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED_NORMAL, normalButton)); // normal
			}			
		});
		
		easyButton.setToggleGroup(levelGroup);
		normalButton.setToggleGroup(levelGroup);
		hardButton.setToggleGroup(levelGroup);		
		vboxButtons.getChildren().addAll(easyButton, normalButton, hardButton);
		VBox.setMargin(easyButton, new Insets(0, 0, 15, 0));
		VBox.setMargin(normalButton, new Insets(0, 0, 15, 0));
		vboxButtons.setLayoutX((canvas.getWidth()-easyButton.getMinWidth())/2);
		vboxButtons.setLayoutY((frame.getHeight()-vboxButtons.getMinHeight())/2);		
	    		
		confirmButton.setDisable(true);
		confirmButton.setText("Confirm");	    
		confirmButton.setMinWidth(200);
		confirmButton.setMinHeight(50);
		confirmButton.setTranslateY(frame.getHeight()-10);
		confirmButton.setTranslateX((canvas.getWidth()-confirmButton.getMinWidth())/2);		
		confirmButton.setFont(new Font("Verdana Bold", 20));
		confirmButton.setStyle(Keyword.BUTTON);
		confirmButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.ENTERED, confirmButton)); // hover
		confirmButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED, confirmButton)); // normal
		confirmButton.setOnMousePressed(e -> new ButtonEvent(Keyword.PRESSED, confirmButton)); // focused
		confirmButton.setOnAction(new EventHandler<ActionEvent>() 
		{			
			@Override
			public void handle(ActionEvent actionEvent) 
			{	
				// if any difficulty level selected
				if(easyButton.isSelected() == true || normalButton.isSelected() == true || hardButton.isSelected() == true)
				{
					if(easyButton.isSelected() == true)
					{
						DifficultyLevel.setDifficultyLevel(1);
					}
					else if(normalButton.isSelected() == true)
					{
						DifficultyLevel.setDifficultyLevel(2);
					}
					else if(hardButton.isSelected() == true)
					{
						DifficultyLevel.setDifficultyLevel(3);
					}					
					new ChangeView(Keyword.CTP, stage, generateSound); // strategy pattern (b)
				}				
			}
		});
	    
		root.getChildren().add(canvas);
		root.getChildren().add(background);
		root.getChildren().add(frame);
		root.getChildren().add(text);
		root.getChildren().add(confirmButton);
		root.getChildren().add(separator);
		root.getChildren().add(vboxButtons);
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