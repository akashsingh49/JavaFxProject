import java.io.Serializable;

/**
 * @author Akash17013 Aatish17001
 * This class stores the details  of an individual player  
 */
public class Players implements Comparable, Serializable  {
	private int score;
	private String name;
	private String date;
	
	/**
	 * @param score has current score
	 * @param name Name of the player
	 * @param date date on which player started playing.
	 */
	public Players(int score,String name,String date)
	{
		this.score=score;
		this.name=name;
		this.date=date;
	}
	/**
	 * @return score of player
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score takes and sets score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @param score 
	 */
	public void IncreaseScore(int score) {
		this.score += score;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object arg0) 
	{
	Players arg1 = (Players)arg0;	
	if(this.score>arg1.score)
	{
		return 1;
	}
	else 
	{
		return 0;
	}
	
	}
	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
