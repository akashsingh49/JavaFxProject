import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Akash17013 Aatish17001
 * displays the list of existing logged in players and allows to chose from them
 */
public class PlayerList extends Application{
	private Stage window;
	private Game game;
	private Gamestarter2 gamestart;
	private String[] ag;
	private High_scores high;
	/**
	 * @param args
	 */
	public static void main(String[] args){	
		launch(args);	
	}
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    public void start(Stage primarystage) throws Exception {
    		// TODO Auto-generated method stub
    		window=primarystage;
    		Pane root=new Pane();
    		game=new Game();
    		high=new High_scores();
    		root.setPrefSize(600, 800);
    		gamestart= new Gamestarter2();
    		VBox menu=new VBox();
			menu.setTranslateX(400);
			menu.setTranslateY(400);
			MenuButton p1=new MenuButton("Start Game");
    		InputStream io=Files.newInputStream(Paths.get("res/images/snake1.jpg"));    		 
    		Image img =new Image(io);
    		Label l = new Label("Name");
    		l.setTextFill(Color.WHITE);
    		TextField t= new TextField();
    		VBox v= new VBox();
    		v.setTranslateX(400);
    		v.setTranslateY(300);
    		v.getChildren().addAll(l,t,p1);
//    		menu.getChildren().addAll(p1);
    		io.close();
    		ImageView imgg=new ImageView(img);
    		imgg.setFitHeight(800);
    		imgg.setFitWidth(700);
    		root.getChildren().addAll(imgg,v);
    		
    		Scene scene = new Scene(root);
    		window.setScene(scene);
    		window.show();
    		p1.setOnMouseClicked(e->{
    			String s=t.getText();
    			System.out.println(s);
    			try {
    				game.set_current_name(s);
    				try {
						game.start(window);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		});

    	}
}
