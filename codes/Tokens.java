import javafx.scene.paint.Color;

/**
 * @author Akash17013 Aatish17001
 *  the abstract class token which is the parent class for the other tokens
 *  
 */
public abstract class Tokens extends sprite{
	/**
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param r dimension
	 * @param type type
	 * @param c color
	 * @param v value
	 */
	Tokens(int x, int y,int r,String type,Color c,int v) {
		super(x, y, r, r, type,c,v);
		// TODO Auto-generated constructor stub
	}
	private int points;
	public int getPoints() {
		return points;
	}

	/**
	 * @param points takes points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	public abstract void increasePoints();
}
