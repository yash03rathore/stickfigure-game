package Data;

public class Box {

	private spriteInfo spriteData;
	private int x1, x2, y1, y2;
	
	public Box(int box_x1, int box_x2, int box_y1, int box_y2) {
		x1 = box_x1;
		x2 = box_x2;
		y1 = box_y1;
		y2 = box_y2;
	}
	
	public Box(spriteInfo box_sprite) {
		spriteData = box_sprite;
		x1 = spriteData.getCoords().getX();
		x2 = spriteData.getCoords().getX() + 128;
		y1 = spriteData.getCoords().getY();
		y2 = spriteData.getCoords().getY() + 128;
	}
	
	public Box(spriteInfo box_sprite, int adjustX1, int adjustX2, int adjustY1, int adjustY2) {
		spriteData = box_sprite;
		x1 = spriteData.getCoords().getX() + adjustX1;
		x2 = spriteData.getCoords().getX() + adjustX2;
		y1 = spriteData.getCoords().getY() + adjustY1;
		y2 = spriteData.getCoords().getY() + adjustY2;
		
	}
	public String toString(){
		return "x1 = " + x1 + " x2 = " + x2 + " y1 = " + y1 + " y2 = " + y2;
	}
	
	public int getX1(){
		return x1;
	}
	
	public int getX2(){
		return x2;
	}
	
	public int getY1(){
		return y1;
	}
	
	public int getY2(){
		return y2;
	}
	
	public void setX1(int Value_x1){
		x1 = Value_x1;
	}
	
	public void setX2(int Value_x2){
		x2 = Value_x2;
	}
	
	public void setY1(int Value_y1){
		y1 = Value_y1;
	}
	
	public void setY2(int Value_y2){
		y2 = Value_y2;
	}
	
	
	
	
}
