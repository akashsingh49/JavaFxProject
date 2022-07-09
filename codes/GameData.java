import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 
 * this has the data to be serialized  
 * 1. snakelength
 * 2. currentplayer
 * 3. list
 * 4. isAvailable
 *
 */
public class GameData implements Serializable
{
	private int snakelength=0;
	private Players currentPlayer;
	private ArrayList<Players> list;
	private boolean isAvailable; 
	
	public int getSnakelength() {
		return snakelength;
	}
	public void setSnakelength(int snakelength) {
		this.snakelength = snakelength;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Players getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Players currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public ArrayList<Players> getList() {
		return list;
	}
	public void setList(ArrayList<Players> list) {
		this.list = list;
	}
	
	/**
	 * @param snakelength 
	 * @param currentPlayer
	 * @param list
	 */
	public GameData(int snakelength, Players currentPlayer, ArrayList<Players> list) {
		
		this.snakelength = snakelength;
		this.currentPlayer = currentPlayer;
		this.list = list;
	}
	/**
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public GameData() throws ClassNotFoundException, IOException
	{
//		this.snakelength=9;
		try{
		GameData data=		deserializeDemo.desrialize();
		list=data.list;
		this.currentPlayer=new Players(200, "Aatish", "2 dec 2018");
		this.isAvailable=data.isAvailable;
		}
		
		catch(NullPointerException e){
			Players p= new Players(40, "Ayush", "25 dec 2017");
			list= new ArrayList<Players>();
			list.add(p);
			currentPlayer=p;

			this.isAvailable=false;
		}

		
	/*	Players player4=new Players(40, "Ayush", "25 dec 2017");
		Players player5=new Players(25, "Sehaj", "17 dec 2017");
		Players player6=new Players(20, "Sachin", "15 dec 2017");
		Players player7=new Players(344, "Ashutosh", "15 dec 2017");
		Players player8=new Players(555, "Vinay", "12 dec 2017");
		Players player9=new Players(523, "Vishal", "1 dec 2017");
	*/	//Players player10=new Players(523, "Aman", "2 dec 2017");
	/*	this.list.add(player4);
		this.list.add(player5);
		this.list.add(player6);
		this.list.add(player7);
		this.list.add(player8);
		this.list.add(player9);
	*/	//this.list.add(player10);*/
//		currentPlayer=null;

	}
	
	
	
}
