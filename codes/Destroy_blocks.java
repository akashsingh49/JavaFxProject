import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * @author Akash2017013 Aatish2017001
 * A token which helps to destroy all the blocks present on the screen
 */
public class Destroy_blocks extends Tokens {

	/**
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	
	Destroy_blocks(int x, int y) {
		super(x, y,60,"destroy", Color.BLUEVIOLET,0);
		this.setArcHeight(60);
		this.setArcWidth(60);			
		// TODO Auto-generated constructor stub
	}
	@Override
	public void increasePoints() {
		// TODO Auto-generated method stub
		
	}

}
