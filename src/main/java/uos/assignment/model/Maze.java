package uos.assignment.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import uos.assignment.view.PlayGame;

/**
 * The Class Maze to generate the maze for the game.
 * It has three field variables.
 * 
 * @version 1.0
 */
public class Maze 
{
	@SuppressWarnings("unused")
	private PlayGame pg;
	private ArrayList<Rectangle> join = new ArrayList<Rectangle>();
	private Rectangle l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24;
	
	/**
	 * Instantiates a new maze.
	 *
	 * @param pg the pg
	 */
	public Maze(PlayGame pg) 
	{
		this.pg = pg;
	}
	
	@SuppressWarnings("unused")
	private Maze() {}
	
	/**
	 * Generate maze.
	 *
	 * @return the array list
	 */
	public ArrayList<Rectangle> generateMaze()
	{	
		l1 = new Rectangle();
		l1.setX(200); // move horizontally
		l1.setY(50); // move vertically
		l1.setWidth(570); // set width
		l1.setHeight(10); // set height
		l1.setArcWidth(10.0f); // set corner width
		l1.setArcHeight(10.0f); // set corner height
		l1.setFill(Color.BROWN); // set colour
		join.add(l1); // add in the array list
		
		l2 = new Rectangle();
		l2.setX(200);
		l2.setY(50);
		l2.setWidth(10);
		l2.setHeight(200);
		l2.setArcWidth(10.0f);
		l2.setArcHeight(10.0f);
		l2.setFill(Color.BROWN);
		join.add(l2);
		
		l3 = new Rectangle();
		l3.setX(200);
		l3.setY(530);
		l3.setWidth(570);
		l3.setHeight(10);
		l3.setArcWidth(10.0f);
		l3.setArcHeight(10.0f);
		l3.setFill(Color.BROWN);
		join.add(l3);
		
		l4 = new Rectangle();
		l4.setX(200);
		l4.setY(340);
		l4.setWidth(10);
		l4.setHeight(200);
		l4.setArcWidth(10.0f);
		l4.setArcHeight(10.0f);
		l4.setFill(Color.BROWN);
		join.add(l4);
		
		l5 = new Rectangle();
		l5.setX(275);
		l5.setY(130);
		l5.setWidth(10);
		l5.setHeight(330);
		l5.setArcWidth(10.0f);
		l5.setArcHeight(10.0f);
		l5.setFill(Color.BROWN);
		join.add(l5);
		
		l6 = new Rectangle();
		l6.setX(275);
		l6.setY(450);
		l6.setWidth(260);
		l6.setHeight(10);
		l6.setArcWidth(10.0f);
		l6.setArcHeight(10.0f);
		l6.setFill(Color.BROWN);
		join.add(l6);
		
		l7 = new Rectangle();
		l7.setX(350);
		l7.setY(50);
		l7.setWidth(10);
		l7.setHeight(170);
		l7.setArcWidth(10.0f);
		l7.setArcHeight(10.0f);
		l7.setFill(Color.BROWN);
		join.add(l7);
		
		l8 = new Rectangle();
		l8.setX(350);
		l8.setY(210);
		l8.setWidth(100);
		l8.setHeight(10);
		l8.setArcWidth(10.0f);
		l8.setArcHeight(10.0f);
		l8.setFill(Color.BROWN);
		join.add(l8);
		
		l9 = new Rectangle();
		l9.setX(350);
		l9.setY(130);
		l9.setWidth(100);
		l9.setHeight(10);
		l9.setArcWidth(10.0f);
		l9.setArcHeight(10.0f);
		l9.setFill(Color.BROWN);
		join.add(l9);
		
		l10 = new Rectangle();
		l10.setX(350);
		l10.setY(290);
		l10.setWidth(10);
		l10.setHeight(85);
		l10.setArcWidth(10.0f);
		l10.setArcHeight(10.0f);
		l10.setFill(Color.BROWN);
		join.add(l10);
		
		l11 = new Rectangle();
		l11.setX(350);
		l11.setY(290);
		l11.setWidth(260);
		l11.setHeight(10);
		l11.setArcWidth(10.0f);
		l11.setArcHeight(10.0f);
		l11.setFill(Color.BROWN);
		join.add(l11);
		
		l12 = new Rectangle();
		l12.setX(520);
		l12.setY(50);
		l12.setWidth(10);
		l12.setHeight(170);
		l12.setArcWidth(10.0f);
		l12.setArcHeight(10.0f);
		l12.setFill(Color.BROWN);
		join.add(l12);
		
		l13 = new Rectangle();
		l13.setX(430);
		l13.setY(370);
		l13.setWidth(10);
		l13.setHeight(90);
		l13.setArcWidth(10.0f);
		l13.setArcHeight(10.0f);
		l13.setFill(Color.BROWN);
		join.add(l13);
		
		l14 = new Rectangle();
		l14.setX(430);
		l14.setY(370);
		l14.setWidth(340);
		l14.setHeight(10);
		l14.setArcWidth(10.0f);
		l14.setArcHeight(10.0f);
		l14.setFill(Color.BROWN);
		join.add(l14);
		
		l15 = new Rectangle();
		l15.setX(760);
		l15.setY(50);
		l15.setWidth(10);
		l15.setHeight(60);
		l15.setArcWidth(10.0f);
		l15.setArcHeight(10.0f);
		l15.setFill(Color.BROWN);
		join.add(l15);
		
		l16 = new Rectangle();
		l16.setX(760);
		l16.setY(180);
		l16.setWidth(10);
		l16.setHeight(90);
		l16.setArcWidth(10.0f);
		l16.setArcHeight(10.0f);
		l16.setFill(Color.BROWN);
		join.add(l16);
		
		l17 = new Rectangle();
		l17.setX(760);
		l17.setY(340);
		l17.setWidth(10);
		l17.setHeight(70);
		l17.setArcWidth(10.0f);
		l17.setArcHeight(10.0f);
		l17.setFill(Color.BROWN);
		join.add(l17);
		
		l18 = new Rectangle();
		l18.setX(760);
		l18.setY(480);
		l18.setWidth(10);
		l18.setHeight(60);
		l18.setArcWidth(10.0f);
		l18.setArcHeight(10.0f);
		l18.setFill(Color.BROWN);
		join.add(l18);
		
		l19 = new Rectangle();
		l19.setX(600);
		l19.setY(180);
		l19.setWidth(10);
		l19.setHeight(120);
		l19.setArcWidth(10.0f);
		l19.setArcHeight(10.0f);
		l19.setFill(Color.BROWN);
		join.add(l19);
		
		l20 = new Rectangle();
		l20.setX(600);
		l20.setY(450);
		l20.setWidth(10);
		l20.setHeight(90);
		l20.setArcWidth(10.0f);
		l20.setArcHeight(10.0f);
		l20.setFill(Color.BROWN);
		join.add(l20);
		
		l21 = new Rectangle();
		l21.setX(680);
		l21.setY(260);
		l21.setWidth(10);
		l21.setHeight(200);
		l21.setArcWidth(10.0f);
		l21.setArcHeight(10.0f);
		l21.setFill(Color.BROWN);
		join.add(l21);
		
		l22 = new Rectangle();
		l22.setX(600);
		l22.setY(130);
		l22.setWidth(10);
		l22.setHeight(60);
		l22.setArcWidth(10.0f);
		l22.setArcHeight(10.0f);
		l22.setFill(Color.BROWN);
		join.add(l22);
		
		l23 = new Rectangle();
		l23.setX(600);
		l23.setY(180);
		l23.setWidth(170);
		l23.setHeight(10);
		l23.setArcWidth(10.0f);
		l23.setArcHeight(10.0f);
		l23.setFill(Color.BROWN);
		join.add(l23);
		
		l24 = new Rectangle();
		l24.setX(670);
		l24.setY(50);
		l24.setWidth(10);
		l24.setHeight(60);
		l24.setArcWidth(10.0f);
		l24.setArcHeight(10.0f);
		l24.setFill(Color.BROWN);
		join.add(l24);
		
		return join;		
	}
}