package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			
	private static stopWatchX sw = new stopWatchX(250);
	private static stopWatchX timer = new stopWatchX(35);
	private static int increment1, increment2 ; 
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
		
			System.exit(0);
			break;
			
		case 'w':
			Main.textMessage = "";
			Main.textbackgroundBox.setTag("nothing");
			if (timer.isTimeUp()){
				Main.lastPosition.setCoords(Main.playergameSprite.getCoords().getX(), Main.playergameSprite.getCoords().getY());
				Main.playergameSprite.getCoords().adjustY(-16);
				Main.playergameSprite.setTag("stickV"+increment2); 
				increment2++;
				if (increment2 >= 16){
					increment2 = 0;
				}
				timer.resetWatch();
			}
			
			break;
		case 'a':
			Main.textMessage = ""; 										
			Main.textbackgroundBox.setTag("nothing");						
			if (timer.isTimeUp()){									
				Main.lastPosition.setCoords(Main.playergameSprite.getCoords().getX(), Main.playergameSprite.getCoords().getY());
				Main.playergameSprite.getCoords().adjustX(-16);
				Main.playergameSprite.setTag("stickL"+increment1);
				increment1++;
				if (increment1 >= 8){
					increment1 = 0;
				}
				timer.resetWatch();
			}
			break;
			
		case 's':
			Main.textMessage = "";
			Main.textbackgroundBox.setTag("nothing");
			if (timer.isTimeUp()){
				Main.lastPosition.setCoords(Main.playergameSprite.getCoords().getX(), Main.playergameSprite.getCoords().getY());
				Main.playergameSprite.getCoords().adjustY(16);
				Main.playergameSprite.setTag("stickV"+increment2);
				increment2++;
				if (increment2 >= 16){
					increment2 = 0;
				}
				timer.resetWatch();
			}
			break;
			
		case 'd':
			Main.textMessage = "";
			Main.textbackgroundBox.setTag("nothing");
			if (timer.isTimeUp()){
				Main.lastPosition.setCoords(Main.playergameSprite.getCoords().getX(), Main.playergameSprite.getCoords().getY());
				Main.playergameSprite.getCoords().adjustX(16);
				Main.playergameSprite.setTag("stickR"+increment1);
				increment1++;
				if (increment1 >= 8){
					increment1 = 0;
				}
				timer.resetWatch();
			}
			break;
		case '$':
			
			if(Main.checkCollision(Main.playerboundedBox, Main.car)){
				Main.textMessage = "There is no one in the car";
				Main.textbackgroundBox.setTag("textBackground");
			}
			
			if(Main.checkCollision(Main.playerboundedBox, Main.streetLight)){
				Main.textMessage = "This is a street light";
				Main.textbackgroundBox.setTag("textBackground");
			}
			break;
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}