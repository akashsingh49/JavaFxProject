import javafx.scene.paint.Color;

/**
 * @author Akash17013 Aatish17001
 * token wall which restricts the movement of snake
 */
public class Wall extends sprite{
	Wall(int x, int y) {
		super(x,-100, 10,(int)(Math.random()*300)+150 , "wall", getColor(),4);
		this.setArcHeight(15);
		this.setArcWidth(15);

	}
	/**
	 * @return returns color 
	 */
	static Color getColor(){
		return Color.WHITE;
	}
}
