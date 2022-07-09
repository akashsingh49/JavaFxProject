import javafx.scene.paint.Color;

/**
 * @author Akash17013 Aatish17001
 * this class is for Shield which helps to get protection from the blocks. 
 */
public class Shield extends Tokens{

	/**
	 * @param x X-coordinate
	 * @param y Y- coordinate 
	 */
	Shield(int x, int y) {
		super(x, y,60,"shield", Color.BLUEVIOLET,0);
		this.setArcHeight(60);
		this.setArcWidth(60);			
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increasePoints() {
		// TODO Auto-generated method stub
	}
}
