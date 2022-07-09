import java.io.Serializable;
import java.util.List;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import javafx.scene.text.Text;
/**
 * @author Akash2017013 Aatish2017001
 * The master class which starts the game.It has two threads . One for running the game and one for serializing. 
 */
public  class Gamestarter2 
{	
	public static boolean flag;;
	static Main_menu menu;
	static GameData myData;
	/**
	 * @author Akash2017013 Aatish2017001
	 * task 1 :  starts the main menu
	 * 
	 */
	public static class task1 implements Runnable
	{
		String[] args;
		public task1(String[] arg)
		{
			args=arg;
		}
		
		@Override
		public void run() 
		{
				menu.main(args);
		}
	}
	
	/**
	 * @author Akash2017013 Aatish2017001
	 * task 2 :  does serialization continuously
	 */
	public static class task2 implements Runnable
	{
		@Override
		public synchronized void run() 
		{	while(true)
			{	try {	
						serialize();
						System.out.println("One time serialization successful");
					}
				catch (IOException e1) 
					{	
						e1.printStackTrace();
					}
				try 
				{
					Thread.sleep(1000);  
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();  
				}
				
			}
		}
		
		/**
		 * @throws IOException
		 */
		private synchronized void serialize() throws IOException 
		{
			ObjectOutputStream out=null;
			try 
			{
				System.out.print(myData.isAvailable());
				out=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Aatish Chauhan\\Desktop\\a.txt"));
				out.writeObject(myData);
			}
			finally 
			{
				out.close();
			}
		}
		
		
	}
	
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException
	{
		myData=new GameData();
		menu= new Main_menu();
		flag=false;
		task1 t1=new task1(args);
		task2 t2=new task2();
		Thread th1=new Thread(t1);
		Thread th2=new Thread(t2);
		th1.start();
		th2.start();
		th1.join();
		th2.join();		
	}
}
