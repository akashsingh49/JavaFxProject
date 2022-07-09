import javafx.scene.paint.Color;
import java.util.*;

/**
 * @author Akash17013 Aatish17001
 * Contains information about the snake: its length, shield, validity, and move- access
 *
 */
public class Snake extends sprite{
	private static int length;
	private boolean shield;
	private int validity;
	private boolean cantmoveleft=false;
	private boolean cantmoveright=false;
	
	/**
	 * 
	 */
	Snake(){
		super(300,600,30,30,"snake",Color.ORANGE,0);
		this.setArcHeight(30);
		this.setArcWidth(30);			
		length=1;
		shield=false;
	}
	/**
	 * @return Can snake move left?
	 */
	boolean getcantmoveleft(){
		if(cantmoveleft)
			return true;
		return false;
	}
	/**
	 * @return  Can snake move right?
	 */
	boolean getcantmoveright(){
		if(cantmoveright)
			return true;
		return false;
	}
	/**
	 * 
	 */
	void cantmoveleft(){
		this.cantmoveleft=true;
		
	}
	/**
	 * 
	 */
	void cantmoveright(){
		this.cantmoveright=true;
		
	}
	/**
	 * @param takes snake parameter and helps in transalation
	 */
	Snake(Snake s){
		super((int)s.getTranslateX()+3,(int)s.getTranslateY()+(length*20),25,25,"snake",Color.ORANGE,0);
		this.setArcHeight(30);
		this.setArcWidth(30);			
		length++;
		shield=false;
	}
	/**
	 * @param time time for which shield is activated
	 */
	void activate_shield(int time){
		shield=true;
		validity=time+700;
	}
	/**
	 * @param timer checks shield 
	 * @return
	 */
	boolean check_shield(int timer){
		if(timer<this.validity){
			return true;
		}
		return false;
	}
	/**
	 * @param i decreases length by i unit 
	 */
	void decrease_length(int i){
		length-=i;
	}
	void moveleft(){
		if(this.cantmoveleft==false)
		setTranslateX(getTranslateX()-10);
		this.cantmoveleft=false;
	}
	void moveright(){
		if(this.cantmoveright==false)
		setTranslateX(getTranslateX()+10);
		this.cantmoveright=false;
	}
	void moveup(){
//		setTranslateY(getTranslateY()-5);
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}
