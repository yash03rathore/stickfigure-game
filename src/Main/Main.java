package Main;

import java.awt.Color;
import java.util.ArrayList;
import Data.Vector2D;
import Data.Box;
import Data.spriteInfo;
import logic.Control;


public class Main{
	public static int imageCounter = 0; 			
	public static String textMessage = ""; 				
	public static String textTrigger = "nothing";
	public static Vector2D playerlastPosition = new Vector2D(0, 0); 
	public static Vector2D playercurrentPosition = new Vector2D(135, 135); 			
	public static spriteInfo playergameSprite = new spriteInfo(playercurrentPosition, "stickR"+imageCounter);
	public static spriteInfo textbackgroundBox = new spriteInfo(new Vector2D(410, 500), textTrigger);
	public static spriteInfo lastPosition = new spriteInfo (playerlastPosition, playergameSprite.getTag()); 
	public static Box car = new Box(685, 985, 235, 520); 
	public static Box streetLight = new Box(90, 180, 290, 655); 
	public static ArrayList<Box> gameboxes = new ArrayList<>(); 	
	public static ArrayList<spriteInfo> gamesprites = new ArrayList<>(); 	
	public static Box playerboundedBox;
	
	public static void main(String[] args) {
		Control ctrl = new Control();				/* Do NOT remove! */
		ctrl.gameLoop();							/* Do NOT remove! */
	}
	
	public static void start() {
		
		gameboxes.add(new Box(0, 1215, 0, 45));  
		gameboxes.add(new Box(0, 1215, 650, 700));	
		gameboxes.add(new Box(0, 10, 45, 650));	
		gameboxes.add(new Box(1150, 1280, -128, 848));	
		gameboxes.add(new Box(700, 970, 250, 508)); 
		gameboxes.add(new Box(105, 165, 305, 640)); 

		gamesprites.add(new spriteInfo(new Vector2D(0, 0), "background")); 
		gamesprites.add(playergameSprite);
		gamesprites.add(textbackgroundBox);
	}
		
	public static void update(Control ctrl) {
		playerboundedBox = new Box(playergameSprite, 10, 10, 20, 30);  	
		
		
		for (int i = 0; i < gameboxes.size(); i++)
			if (checkCollision(playerboundedBox, gameboxes.get(i)))
				bouncePlayer(); 
		
		for (int i = 0; i < gamesprites.size(); i++)
			ctrl.addSpriteToFrontBuffer(gamesprites.get(i).getCoords().getX(), gamesprites.get(i).getCoords().getY(), 
					gamesprites.get(i).getTag());
		
		ctrl.drawString(425, 550, textMessage, Color.WHITE);
	}
	
	public static boolean checkCollision(Box box1, Box box2){
		if (((box1.getX1() > box2.getX2()) 
			|| (box1.getX2() < box2.getX1()) 
			|| (box1.getY1() > box2.getY2()) 
			|| (box1.getY2() < box2.getY1())))
			return false;
		else 
			return true;
		}

	
	public static void bouncePlayer(){
		if ((playergameSprite.getCoords().getX() - lastPosition.getCoords().getX()) != 0){
			if ((playergameSprite.getCoords().getX() - lastPosition.getCoords().getX()) > 0)		
				playergameSprite.getCoords().adjustX(-16);								
			if ((playergameSprite.getCoords().getX() - lastPosition.getCoords().getX()) < 0)  	
				playergameSprite.getCoords().adjustX(+16);
		}
		if ((playergameSprite.getCoords().getY() - lastPosition.getCoords().getY()) != 0){
			if ((playergameSprite.getCoords().getY() - lastPosition.getCoords().getY()) > 0)		
				playergameSprite.getCoords().adjustY(-16);
			if ((playergameSprite.getCoords().getY() - lastPosition.getCoords().getY()) < 0)		
				playergameSprite.getCoords().adjustY(+16);
		}
	}
}


	
	


