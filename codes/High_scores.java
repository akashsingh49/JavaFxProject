import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.*;
/**
 * @author Akash17013
 * @author Aatish17001
 * helps in making the highscore interface
 */
public class High_scores extends Application {
	private Stage window;
	Main_menu menu;									
	static ArrayList<Players> entries =new ArrayList<>();     // desrialize file and load each players element one by one in arraylist
	Comparator<Players> c=new Comparator<Players>()
			{
				public int compare(Players p1,Players p2)
				{
					if(p1.getScore()<p2.getScore())
						return 1;
					else
						return -1;
				}
	};
	/**
	 * 
	 */
	public void sortHighScores()
	{
		entries.sort(c);
		int i=0;
		for(Players players : entries){
			if(i<10)
				i++;
			else
				entries.remove(players);	
		}
	}
	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage primarystage) throws Exception {
		// TODO Auto-generated method stub
		window=primarystage;
		Pane root=new Pane();
		menu=new Main_menu();
		root.setPrefSize(600, 800);
		VBox menu0=new VBox();
		menu0.setTranslateX(0);
		menu0.setTranslateY(200);
//		deserializeDemo d= new deserializeDemo();  //commented
		GameData data=		deserializeDemo.desrialize();
		for(int i=0;i<data.getList().size();i++){
			Players p= data.getList().get(i);
			entries.add(p);
/*			System.out.println(p.getName()+" "+p.getScore()+" "+p.getDate());
			Label l= new Label(p.getName()+" "+p.getScore()+" "+p.getDate());
			menu0.getChildren().add(l);*/
		}
		this.sortHighScores();
		for(int i=0;i<entries.size();i++){
//			System.out.println(entries.getName()+" "+entries.getScore()+" "+p.getDate());
			Players p=entries.get(i);
			Label l= new Label(p.getName()+" , "+p.getScore()+" , "+p.getDate());
			l.setTextFill(Color.WHITE);
			l.setPrefHeight(40);
			l.setPrefWidth(300);
			menu0.getChildren().add(l);
		}
		entries.removeAll(entries);
		InputStream io=Files.newInputStream(Paths.get("res/images/snake1.jpg"));    		 
		Image img =new Image(io);
		io.close();
		MenuButton main= new MenuButton("Main Menu");
		main.setOnMouseClicked(e->{
			try {
				menu.start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		main.setMaxWidth(50);
		ImageView imgg=new ImageView(img);
		imgg.setFitHeight(800);
		imgg.setFitWidth(600);
		menu0.setTranslateX(400);
		menu0.setTranslateY(300);
//		menu0.getChildren().addAll(imgg,main);
		menu0.getChildren().add(main);
		root.getChildren().add(imgg);
		root.getChildren().addAll(menu0);	
	//	root.getChildren().add(menu0);
		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);
		window.setScene(scene);
		window.show();
	}
	

	
    	
}
