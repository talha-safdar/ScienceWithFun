package uos.assignment.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import uos.assignment.controller.eventhandler.ChangeView;
import uos.assignment.controller.sound.ButtonEvent;
import uos.assignment.controller.sound.GenerateSound;
import uos.assignment.controller.DifficultyLevel;
import uos.assignment.controller.MovePlayer;
import uos.assignment.model.Flash;
import uos.assignment.model.GameObject;
import uos.assignment.model.GameObjectFactory;
import uos.assignment.model.Keyword;
import uos.assignment.model.Maze;

/**
 * The Class PlayGame to display the main interface to play the game.
 * It has twenty-six field variables.
 * 
 * @version 1.0
 */
public class PlayGame 
{
	public static int direction = 0;
	public static int outOfScore=0;
	public static Label scoreInfo = new Label();
	private Pane root;// main pane for this view
	private Canvas canvas = new Canvas(1000, 650); 
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private GameObject confetti = new GameObjectFactory(gc).createObject(Keyword.CONFETTI, 0, 0);
	private GameObject flash = new GameObjectFactory(gc).createObject(Keyword.FLASH, 150, 270);		
	private GameObject backgroundMaze = new GameObjectFactory(gc).createObject(Keyword.BACKGROUND_MAZE, 0, 0); // abstract factory pattern (c)
	private ImageView hand = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.HAND, 30, 250).getImg()));
	private ImageView candle = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.CANDLE, 30, 400).getImg()));
	private ImageView brain = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.BRAIN, 850, 250).getImg()));
	private ImageView eyes = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.EYES, 850, 100).getImg()));
	private ImageView nose = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.NOSE, 850, 400).getImg()));
	private ImageView info = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.INFO, 900, 100).getImg()));
	private ImageView hurtHand = (new ImageView(new GameObjectFactory(gc).createObject(Keyword.HURT_HAND, 30, 270).getImg()));
	private ImageView backMaze = new ImageView(backgroundMaze.getImg());
	private boolean checkIfWon = false;	
	private boolean checkIfHit = false;
	private int sendCollission=0;
	private ArrayList<Rectangle> mazeEdges = new ArrayList<Rectangle>();
	private ArrayList<Rectangle> limitStart = new ArrayList<Rectangle>();
	private ArrayList<Rectangle> losePoints = new ArrayList<Rectangle>();
	private ArrayList<Rectangle> winPoint = new ArrayList<Rectangle>();
	private GenerateSound generateSound = new GenerateSound(); // facade pattern (s)
	private AnimationTimer collissionTimer = new AnimationTimer() 
	{
		@Override
		public void handle(long now) 
		{		
			
			gc.setFill(Color.LIGHTBLUE);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			flash.move();
			backgroundMaze.move(); // maze background
			sendCollission = 0;
			for (Rectangle startEdges : limitStart)
			{
				flash.move();
				 // if going outside the maze from start point
				if(flash.r.intersects(startEdges.getX(),startEdges.getY(),startEdges.getWidth(),startEdges.getHeight())) 
				{
					flash = new Flash(gc, 150, 270);
				}
			}
			for (Rectangle endLose : losePoints) 
			{
				flash.move();
				// if reached wrong exit
				if (flash.r.intersects(endLose.getX(),endLose.getY(),endLose.getWidth(),endLose.getHeight())) 
				{
					generateSound.stopGame();
					generateSound.playLose();
					losePoints();
				}
			}
			for (Rectangle endWin : winPoint) 
			{
				flash.move();
				// if reached correct exit
				if (flash.r.intersects(endWin.getX(),endWin.getY(),endWin.getWidth(),endWin.getHeight())) 
				{
					flash = new Flash(gc, 750, 280);
					checkIfWon = true;
					victoryPoint();
				}
			}
			
			for(Rectangle edge : mazeEdges) 
			{
				flash.move();	
				 // if hit any side of inside the maze
				if(flash.r.intersects(edge.getX(),edge.getY(),edge.getWidth(),edge.getHeight())) 
				{					
					gc.setFill(Color.YELLOW);
					gc.fillRect(flash.r.getX(),flash.r.getY(),flash.r.getWidth(),flash.r.getHeight());
					checkIfHit = true;						
				}
					
				else
				{
					root.setOnKeyPressed(new MovePlayer(flash, sendCollission));
					checkIfHit = false;
				}
				if (checkIfHit == true) // collided to a side
				{	
					
					if(outOfScore+1 < DifficultyLevel.getDifficultyLevel()) // if current hit is less than the total
					{
						//  up = 1, down = 2, left = 3, right = 4;
						// record the direction and only allow to go to the position during the collision
						if(direction == 1) 
						{
							sendCollission = 4; 
						}
						else if (direction == 2)
						{
							sendCollission = 3;
						}
						else if (direction == 3)
						{
							sendCollission = 2;
						}
						else if (direction == 4)
						{
							sendCollission = 1;
						}
					}		
					else
					{
						generateSound.stopGame(); 
						generateSound.playLose();	
		            	flash = new Flash(gc, 150, 270);				            
						outOfScore=0; // once hit is max reset the hits
						scoreInfo.setText(Keyword.HITS + outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
						generateSound.playGame();
					}		
					generateSound.playHit();
					root.setOnKeyPressed(new MovePlayer(flash, sendCollission));						
				}
			}		
			generateSound.stopHit(); 
		}
	};			

	/**
	 * the victoryPoint method for the victory.
	 * it plays victory audio and victory animation.
	 */
	private void victoryPoint()
	{		
		flash.move();
		generateSound.stopGame();
		generateSound.playVictory();
		victoryTimer.start();		
	}	
	
	private AnimationTimer victoryTimer = new AnimationTimer() // victory animation play continuously
	{		
		@Override
		public void handle(long now) 
		{
			collissionTimer.stop();
			gc.setFill(Color.LIGHTBLUE);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			flash.move();
			backgroundMaze.move(); // maze background
			confetti.move();	
		}
	};
	
	/**
	 * the losePoints method for the lose.
	 * it plays lose audio and resets the position 
	 * of the character.
	 */
	private void losePoints()
	{
		flash.move();
		flash = new Flash(gc, 150, 270); // reset the initial position
		outOfScore=0; // reset the hits score to zero
		scoreInfo.setText(Keyword.HITS + outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
		generateSound.playGame();
	}
		
	/**
	 * Instantiates a new play game.
	 *
	 * @param stage the stage
	 */
	public PlayGame(Stage stage) 
	{
		root = new Pane();		
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		generateSound.playGame(); // play game music in background
		
		final Timeline generateFlash = new Timeline(new KeyFrame(Duration.millis(8000), new EventHandler<ActionEvent>() 
		{
            @Override
            public void handle(ActionEvent actionEvent) 
            {
            	collissionTimer.start(); // generate flash       	
            	generateSound.playFlash(); // play flash appearing sound
            }
        }) , new KeyFrame(Duration.seconds(0)));		
		generateFlash.play(); // to delay flash showing
    			
		Maze maze = new Maze(this); // create maze
		Group wholeMaze = new Group();
		wholeMaze.getChildren().addAll(maze.generateMaze());
		for(Node edge : wholeMaze.getChildren())
		{				
			mazeEdges.add((Rectangle) edge); // add each side of the maze to mazeEdges for collision detection
		}
		
		Rectangle startLimit, startLimit2, startLimit3; // to prevent going outside the maze
		startLimit = new Rectangle();
		startLimit.setX(150);
		startLimit.setY(240);
		startLimit.setWidth(50);
		startLimit.setHeight(10);
		startLimit.setFill(Color.LIGHTBLUE);
		
		startLimit2 = new Rectangle();
		startLimit2.setX(140);
		startLimit2.setY(240);
		startLimit2.setWidth(10);
		startLimit2.setHeight(110);
		startLimit2.setFill(Color.LIGHTBLUE);
		
		startLimit3 = new Rectangle();
		startLimit3.setX(150);
		startLimit3.setY(340);
		startLimit3.setWidth(50);
		startLimit3.setHeight(10);
		startLimit3.setFill(Color.LIGHTBLUE);
		
		Group startingPointMaze = new Group(startLimit,startLimit2, startLimit3);
		for(Node limit : startingPointMaze.getChildren())
		{				
			limitStart.add((Rectangle) limit); // add each side of the limit points to limitStart for collision detection
		}
		
		// for background use limitStart approach
		Rectangle loseExit, winExit, loseExit2; 
				
		loseExit = new Rectangle(); // for lose exit
		loseExit.setX(760);
		loseExit.setY(110);
		loseExit.setWidth(10);
		loseExit.setHeight(70);
		loseExit.setFill(Color.LIGHTBLUE);
		
		winExit = new Rectangle(); // for victory exit
		winExit.setX(760);
		winExit.setY(270);
		winExit.setWidth(10);
		winExit.setHeight(70);
		winExit.setFill(Color.LIGHTBLUE);		

		loseExit2 = new Rectangle(); // for lose exit
		loseExit2.setX(760);
		loseExit2.setY(410);
		loseExit2.setWidth(10);
		loseExit2.setHeight(70);
		loseExit2.setFill(Color.LIGHTBLUE);
		
		Group losePointMaze = new Group(loseExit,loseExit2);
		Group winPointMaze = new Group(winExit);
		for(Node loseExits : losePointMaze.getChildren())
		{				
			losePoints.add((Rectangle) loseExits); // add lose exits to losePoints for detection
		}
		for(Node winExits : winPointMaze.getChildren())
		{				
			winPoint.add((Rectangle) winExits); // add win exit to winPoint for detection
		}
		
		// current position of candle, hand, hurtHand, eyes, brain, nose, info, backMaze
		candle.setFitHeight(250);
		candle.setFitWidth(250);
		candle.setLayoutX(250);
		candle.setLayoutY(270);		

		hand.setFitHeight(250);
		hand.setFitWidth(250);
		hand.setLayoutX(400);
		hand.setLayoutY(90);
		
		hurtHand.setFitHeight(250);
		hurtHand.setFitWidth(250);
		hurtHand.setLayoutX(400);
		hurtHand.setLayoutY(90);		
		
		eyes.setFitHeight(100);
		eyes.setFitWidth(100);
		eyes.setLayoutX(850);
		eyes.setLayoutY(100);
		
		brain.setFitHeight(100);
		brain.setFitWidth(100);
		brain.setLayoutX(850);
		brain.setLayoutY(250);
		
		nose.setFitHeight(100);
		nose.setFitWidth(100);
		nose.setLayoutX(850);
		nose.setLayoutY(400);
		
		info.setFitHeight(150);
		info.setFitWidth(150);
		info.setLayoutX(25);
		info.setLayoutY(60);
		
		backMaze.setFitHeight(490);
		backMaze.setFitWidth(570);
		backMaze.setLayoutX((canvas.getWidth()-backMaze.getFitWidth())/2-15);
		backMaze.setLayoutY(((canvas.getHeight()-backMaze.getFitHeight())/2)-30);		
		
		Group desitnationImages = new Group();
		desitnationImages.getChildren().addAll(eyes, brain, nose); // group destination images	
		
		Separator separator = new Separator(); // the horizontal line between the game and the buttons
	    separator.setMinWidth(900);	    
	    separator.setMinHeight(0);
	    separator.setLayoutX((canvas.getWidth()-separator.getMinWidth())/2);
	    separator.setLayoutY(580);    	    
	    
		Button resetButton = new Button("Reset"); // the reset button
		resetButton.setDisable(true);
		resetButton.setTranslateX(710);		
		resetButton.setTranslateY(597);
		resetButton.setMinWidth(100);
		resetButton.setMinHeight(1);
		resetButton.setFont(new Font("Verdana Bold", 20));
		resetButton.setStyle("-fx-background-color: lime;" + "-fx-background-radius: 50;");
		resetButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.ENTERED, resetButton)); // hover
		resetButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED, resetButton)); // normal
		resetButton.setOnMousePressed(e -> new ButtonEvent(Keyword.PRESSED, resetButton)); // focused
		resetButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				if (checkIfWon == true) // if player won the game
				{					
					victoryTimer.stop(); // stop victory animation
					collissionTimer.start(); // start the collision timer
				}
				generateSound.stopGame(); // stop the background music
				generateSound.playGame(); // play the background music
				flash = new Flash(gc, 150, 250); // restore initial position
				outOfScore=0; // reset hits count
				scoreInfo.setText(Keyword.HITS + outOfScore + " / " + DifficultyLevel.getDifficultyLevel());	
			}	    	
	    });
		
		// enabled the reset button after the animation finishes
		final Timeline resetEnableTimeline = new Timeline(new KeyFrame(Duration.millis(11000), new EventHandler<ActionEvent>() 
		{
            @Override
            public void handle(ActionEvent actionEvent) 
            {
            	resetButton.setDisable(false); // enable reset button
            }
        }), new KeyFrame(Duration.seconds(0)));		
		resetEnableTimeline.play(); // to delay reset enabling	  
		
		Button homeButton = new Button("Home"); // the home button
		homeButton.setTranslateX(50);
		homeButton.setTranslateY(597);
		homeButton.setMinWidth(100);
		homeButton.setMinHeight(1);
		homeButton.setFont(new Font("Verdana Bold", 20));
		homeButton.setStyle(Keyword.BUTTON);
		homeButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.ENTERED, homeButton)); // hover
		homeButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED, homeButton)); // normal
		homeButton.setOnMousePressed(e -> new ButtonEvent(Keyword.PRESSED, homeButton)); // focused
		homeButton.setOnAction(new EventHandler<ActionEvent>() 
		{			
			@Override
			public void handle(ActionEvent actionEvent) 
			{
				generateFlash.stop();
				new ChangeView(Keyword.PTM, stage, generateSound); // go to main menu	
			}
		});	
		
		Button difficultyButton = new Button("Difficulty"); // the difficulty button
		difficultyButton.setTranslateX(820);
		difficultyButton.setTranslateY(597);
		difficultyButton.setMinWidth(100);
		difficultyButton.setMinHeight(1);
		difficultyButton.setFont(new Font("Verdana Bold", 20));
		difficultyButton.setStyle(Keyword.BUTTON);
		difficultyButton.setOnMouseEntered(e -> new ButtonEvent(Keyword.ENTERED, difficultyButton)); // hover
		difficultyButton.setOnMouseExited(e -> new ButtonEvent(Keyword.EXITED, difficultyButton)); // normal
		difficultyButton.setOnMousePressed(e -> new ButtonEvent(Keyword.PRESSED, difficultyButton)); // focused
		difficultyButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			
			@Override
			public void handle(ActionEvent actionEvent) 
			{
				generateFlash.stop();
				outOfScore=0;
				scoreInfo.setText(Keyword.HITS + outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
				new ChangeView(Keyword.PTC, stage, generateSound);
			}
		});
				
		// scoring
		scoreInfo.setText(Keyword.HITS + outOfScore + " / " + DifficultyLevel.getDifficultyLevel());
		scoreInfo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
		scoreInfo.setLayoutX(400);
		scoreInfo.setLayoutY(605);		
		
		// ROTATE - hand, hurtHand
		RotateTransition rotateHand = new RotateTransition(Duration.millis(1600), hand);
		RotateTransition rotateHurtHand = new RotateTransition(Duration.millis(1600), hurtHand);		
		rotateHand.delayProperty().set(Duration.millis(1000));
		rotateHand.setByAngle(-90);
		rotateHand.setCycleCount(2);
		rotateHand.setAutoReverse(true);		
		rotateHurtHand.delayProperty().set(Duration.millis(1000));
		rotateHurtHand.setByAngle(-90);
		rotateHurtHand.setCycleCount(2);
		rotateHurtHand.setAutoReverse(true);
		
		// hold the hand, hurtHand positions before rotating for a while (wait) then rotate
		SequentialTransition rotateHandSeqTrans = new SequentialTransition (new PauseTransition(Duration.millis(220)), rotateHand); // wait
		SequentialTransition rotateHurtHandSeqTrans = new SequentialTransition (new PauseTransition(Duration.millis(220)), rotateHurtHand); // wait
		rotateHandSeqTrans.play();
		rotateHurtHandSeqTrans.play();
		
		// also move a bit horizontally towards left when touching the flame
		TranslateTransition handMoveToFlame = new TranslateTransition();
		TranslateTransition hurtHandMoveToFlame = new TranslateTransition();
		handMoveToFlame.delayProperty().set(Duration.millis(1500));
		handMoveToFlame.setDuration(Duration.millis(900));
		handMoveToFlame.setNode(hand);
		handMoveToFlame.setByX(-40);
		handMoveToFlame.setCycleCount(2);
		handMoveToFlame.setAutoReverse(true);
	    SequentialTransition handMoveToFlameSeqTrans = new SequentialTransition (new PauseTransition(Duration.millis(900)), handMoveToFlame); // wait 		
	    handMoveToFlameSeqTrans.play();        	     
	     
		hurtHandMoveToFlame.delayProperty().set(Duration.millis(1500));
		hurtHandMoveToFlame.setDuration(Duration.millis(900));
		hurtHandMoveToFlame.setNode(hurtHand);
		hurtHandMoveToFlame.setByX(-40);
		hurtHandMoveToFlame.setCycleCount(2);
		hurtHandMoveToFlame.setAutoReverse(true);
	    SequentialTransition hurtHandMoveToFlameSeqTrans = new SequentialTransition (new PauseTransition(Duration.millis(900)), hurtHandMoveToFlame); // wait 		
	    hurtHandMoveToFlameSeqTrans.play();
		
	    // AFTER ROTATE, MOVE and touched the flame, disappear hand and keep hurtHand
		FadeTransition disappearHand = new FadeTransition(Duration.millis(1000), hand);
		disappearHand.setDelay(Duration.millis(3000));
		disappearHand.setFromValue(1.0);		
		disappearHand.setToValue(0.0);		
		disappearHand.play();
		
		// then after touch move back
		TranslateTransition handMoveBack = new TranslateTransition();
		handMoveBack.delayProperty().set(Duration.millis(4000));
		handMoveBack.setDuration(Duration.millis(900));
		handMoveBack.setNode(hurtHand);
		handMoveBack.setByX(20);
		handMoveBack.play();		     
		     
		// MOVE - candle, hurtHand towards left end of the screen
		TranslateTransition candleMoving = new TranslateTransition();
		TranslateTransition hurtHandMoving = new TranslateTransition();		
		candleMoving.delayProperty().set(Duration.millis(6000));
		candleMoving.setDuration(Duration.millis(900));
		candleMoving.setNode(candle);
		candleMoving.setByX(-310);
		candleMoving.setByY(50);			
		hurtHandMoving.delayProperty().set(Duration.millis(6000));
		hurtHandMoving.setDuration(Duration.millis(1000));	
		hurtHandMoving.setNode(hurtHand);
		hurtHandMoving.setByX(-450);
		hurtHandMoving.setByY(80);		
		candleMoving.play();
		hurtHandMoving.play();
		
		// SCALE - candle, hurtHand make them smaller
		ScaleTransition scaleCandle = new ScaleTransition(Duration.millis(1000), candle);
		ScaleTransition scaleHurtHand = new ScaleTransition(Duration.millis(2000), hurtHand);
		scaleCandle.setDelay(Duration.millis(5200));
		scaleCandle.setByX(-0.6);
		scaleCandle.setByY(-0.6);				
		scaleHurtHand.setDelay(Duration.millis(5200));		
		scaleHurtHand.setByX(-0.6);		
		scaleHurtHand.setByY(-0.6);
		scaleCandle.play();
		scaleHurtHand.play();		
		
		// COVER - candle, hand, info, scoreInfo (hide)
		Rectangle coverInfo = new Rectangle();
		Rectangle coverCandle = new Rectangle();
		Rectangle coverHand = new Rectangle();
		Rectangle coverScoreInfo = new Rectangle();
		coverInfo.setWidth(150);
		coverInfo.setHeight(150);
		coverInfo.setLayoutX(25);
		coverInfo.setLayoutY(60);
		coverInfo.setFill(Color.LIGHTBLUE);
		
		coverCandle.setWidth(60);
		coverCandle.setHeight(250);
		coverCandle.setLayoutX(345);
		coverCandle.setLayoutY(270);
		coverCandle.setFill(Color.LIGHTBLUE);
		
		coverHand.setWidth(250);
		coverHand.setHeight(250);
		coverHand.setLayoutX(400);
		coverHand.setLayoutY(90);
		coverHand.setFill(Color.LIGHTBLUE);
		
		coverScoreInfo.setWidth(130);
		coverScoreInfo.setHeight(25);
		coverScoreInfo.setLayoutX(400);
		coverScoreInfo.setLayoutY(605);
		coverScoreInfo.setFill(Color.LIGHTBLUE);
		
		// UNCOVER - candle, hand, info, scoreInfo (reveal)
		FadeTransition uncoverInfo = new FadeTransition(Duration.millis(900), coverInfo);
		FadeTransition uncoverCandle = new FadeTransition(Duration.millis(900), coverCandle);
		FadeTransition uncoverHand = new FadeTransition(Duration.millis(900), coverHand);
		FadeTransition uncoverScoreInfo = new FadeTransition(Duration.millis(900), coverScoreInfo);
		uncoverInfo.setFromValue(1.0);
		uncoverInfo.setDelay(Duration.millis(10000));
		uncoverInfo.setToValue(0.0);
		
		uncoverCandle.setFromValue(1.0);
		uncoverCandle.setDelay(Duration.millis(200));
		uncoverCandle.setToValue(0.0);	
		
		uncoverHand.setFromValue(1.0);
		uncoverHand.setDelay(Duration.millis(200));
		uncoverHand.setToValue(0.0);
		
		uncoverScoreInfo.setFromValue(1.0);
		uncoverScoreInfo.setDelay(Duration.millis(7000));
		uncoverScoreInfo.setToValue(0.0);
		
		uncoverInfo.play();
		uncoverCandle.play();
		uncoverHand.play();	 
		uncoverScoreInfo.play();
		
		// COVER - maze, destinations (hide)
		Rectangle coverMaze = new Rectangle();
		Rectangle coverDestinationImages = new Rectangle();
		coverMaze.setWidth(570);
		coverMaze.setHeight(490);		
		coverMaze.setLayoutY(((canvas.getHeight()-coverMaze.getHeight())/2)-30);
		coverMaze.setLayoutX((canvas.getWidth()-coverMaze.getWidth())/2-15);
		coverMaze.setFill(Color.LIGHTBLUE);
		
		coverDestinationImages.setWidth(100);
		coverDestinationImages.setHeight(390);
		coverDestinationImages.setLayoutY(110);
		coverDestinationImages.setLayoutX(850);
		coverDestinationImages.setFill(Color.LIGHTBLUE);
	     
		// UNCOVER - maze, destination (reveal)
		FadeTransition uncoverMaze = new FadeTransition(Duration.millis(1000), coverMaze);
		FadeTransition uncoverDestinationImages = new FadeTransition(Duration.millis(1000), coverDestinationImages);
		uncoverMaze.setFromValue(1.0);
		uncoverMaze.setDelay(Duration.seconds(8));
		uncoverMaze.setToValue(0.0);
		
		uncoverDestinationImages.setFromValue(1.0);
		uncoverDestinationImages.setDelay(Duration.seconds(9));
		uncoverDestinationImages.setToValue(0.0);
		
		uncoverMaze.play();
		uncoverDestinationImages.play();	     
		
		Rectangle backMaze = new Rectangle();
		backMaze.setWidth(570);
		backMaze.setHeight(490);
		backMaze.setLayoutY(50);
		backMaze.setLayoutX(200);
		backMaze.setFill(Color.SILVER);
		backMaze.toBack();
		
		root.getChildren().add(startingPointMaze);
		root.getChildren().add(losePointMaze);
		root.getChildren().add(winPointMaze);	
		root.getChildren().add(canvas);		
		root.getChildren().add(resetButton);
		root.getChildren().add(homeButton);
		root.getChildren().add(difficultyButton);
		root.getChildren().add(wholeMaze);
		root.getChildren().add(desitnationImages);
		root.getChildren().add(scoreInfo);
		root.getChildren().add(separator);		
		root.getChildren().add(coverMaze);
		root.getChildren().add(coverDestinationImages);		
		root.getChildren().add(hurtHand);
		root.getChildren().add(hand);
		root.getChildren().add(candle);
		root.getChildren().add(info);
		root.getChildren().add(coverCandle);
		root.getChildren().add(coverHand);
		root.getChildren().add(coverInfo);
		root.getChildren().add(coverScoreInfo);
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