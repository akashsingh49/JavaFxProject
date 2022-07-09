import javafx.scene.paint.Color;

/**
 * @author Akash17013 Aatish17001
 * this class represents the token magnet which attracts all the coins nearby the snake 
 */
public class Magnet extends Tokens{
	
	/**
	 * @param x Coordinate
	 * @param y Coordinate
	 */
	Magnet(int x, int y) {
		super(x, y,60,"magnet", Color.BLUEVIOLET,0);
		this.setArcHeight(60);
		this.setArcWidth(60);			
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void increasePoints() {
			
	}

}
