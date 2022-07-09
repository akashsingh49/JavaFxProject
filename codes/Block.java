import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Akash2017013 Aatish2017001
 * Block represents the class for the token which the snake has to destroy to score more
 */
public class Block extends sprite{
	private static int value;
	/**
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param w dimensions - width and length are the same. 
	 * @param h 
	 * @param length denotes length
	 */
	Block(int x, int y, int w, int h,int length) {
		super(x, y, w, h, "block", getColor(),getValue(length));
	//	this.setValue(value);
		this.setArcHeight(15);
		this.setArcWidth(15);

	}
	/**
	 * @return color
	 */
	static Color getColor(){
		double r= Math.random();
		if(r<0.33)
			return Color.GREEN;
		if(r<0.66)
			return Color.RED;
		else
			return Color.BLUE;
	}

	/**
	 * @param length sued for random function
	 * @return a random value
	 */
	public static int getValue(int length) {
		Random r= new Random();
		value=r.nextInt(length);
		if(value==0)
			value=1;
		return value+2;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
