import java.util.Random;

import javafx.scene.paint.Color;

/**
 * @author Akash2017013 Aatish2017001
 * this class represents ball- a token which is eaten by snake to increase its length.
 *
 */
public class Ball extends Tokens{
	
	/**
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 */
	Ball(int x,int y) {
		super(x, y,20,"ball", Color.YELLOW,getValue(10));
		this.setArcHeight(60);
		this.setArcWidth(60);			
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param i used for random function
	 * @return a random number
	 */
	public static int getValue(int i) {
		Random r= new Random();
		return r.nextInt(i)+5;
	}
	@Override
	public void increasePoints() {
			
	}

}
