import java.util.Random;

import javafx.scene.paint.Color;
/**
 * @author Akash2017013 Aatish2017001
 * represents token which needs to be eaten to increase score by 10
 */
public class Coins extends sprite{
	
	/**
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	Coins(int x, int y) {
		super(x, y,30,30, "coin", Color.YELLOW,getValue(10));
		this.setArcHeight(60);
		this.setArcWidth(60);			
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param i for random function
	 * @return a random number based on i
	 */
	public static int getValue(int i) {
		Random r= new Random();
		return r.nextInt(i)+5;
	}

}
