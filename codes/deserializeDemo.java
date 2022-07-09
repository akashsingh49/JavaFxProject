import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Akash2017013 Aatish2017001
 * This class  has a function to deserialize the data.
 */
public class deserializeDemo 
{
	/**
	 * @return the object which has just been deserialized 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static GameData desrialize() throws IOException,ClassNotFoundException
	{
		ObjectInputStream in=null;
		GameData mydata;
		try 
		{
			in=new ObjectInputStream(new FileInputStream("C:\\Users\\Aatish Chauhan\\Desktop\\a.txt"));
			mydata=(GameData) in.readObject();
		}
		finally
		{
			in.close();
		}
		return mydata;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException
	{
		GameData gd=desrialize();
		System.out.println(gd.getSnakelength());
		for (Players p : gd.getList()) 
		{
			System.out.print(p.getName()+" "+p.getScore()+" "+p.getDate());
			System.out.println();
		}
		Players p1=gd.getCurrentPlayer();
		System.out.print(p1.getName()+" "+p1.getScore()+" "+p1.getDate());
	}
	
}
