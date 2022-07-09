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
 *This is the main menu . it displays the main menu interface and gives the choice to the players 
 *1. new game
 *2. resume
 *2. highScore etc
 */
public class Main_menu extends Application{
	private Scene scene;
	private int score;
	private boolean show_score=false;
	private Stage window;
	private static String[]  ar;
	private boolean can_resume;
	
	private PlayerList playerlist;					// serialize game and chech if we can resume or not if true then set can_resume to true else set it to false 
	private High_scores high; 		
	Options op;
	/**
	 * @param args
	 */
	public static void main(String[] args){	
		ar=args;
		launch(args);	

	}
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    public void start(Stage primarystage) throws Exception {
    		// TODO Auto-generated method stub
    		Pane root=new Pane();
    		op=new Options();	
    		window=primarystage;
    		playerlist= new PlayerList();
    		high=new High_scores();
    		root.setPrefSize(600, 800);
    		VBox menu=new VBox();
			menu.setTranslateX(400);
			menu.setTranslateY(400);
    		Label l=new Label("GAME OVER. Score is "+score );
    		GameData data=		deserializeDemo.desrialize();
    		this.can_resume=data.isAvailable();
			MenuButton new1=new MenuButton("New Game");
			MenuButton resume=new MenuButton("Resume");
			MenuButton high_scores=new MenuButton("High Scores");
			MenuButton options=new MenuButton("Options");
			MenuButton exit=new MenuButton("Exit");
			exit.setOnMouseClicked(e->{
			System.exit(0);
			});
			
			new1.setOnMouseClicked(e->{
				try {
					this.playerlist.start(window);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			options.setOnMouseClicked(e->{
				try {
					op.start(window);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			high_scores.setOnMouseClicked(e->{
				try {
					high.start(window);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			resume.setOnMouseClicked(e->{
				Game game= new Game();
				game.set_resume();
				try {
					try {
						game.start(window);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			if(this.isShow_score()){
				menu.getChildren().add(l);
			}
			menu.getChildren().addAll(new1);
			if(this.can_resume==true){
//				System.out.println("kat");
				menu.getChildren().add(resume);
			}
			menu.getChildren().addAll(high_scores,options,exit);
    		InputStream io=Files.newInputStream(Paths.get("res/images/snake1.jpg"));    		 
    		Image img =new Image(io);
    		io.close();
    		ImageView imgg=new ImageView(img);
    		imgg.setFitHeight(800);
    		imgg.setFitWidth(700);
    		root.getChildren().addAll(imgg,menu);
    		Scene scene = new Scene(root);
    		window.setScene(scene);
    		window.show();
    	}
	public boolean isShow_score() {
		return show_score;
	}
	public void setShow_score(int ab) {
		this.score=ab;
		this.show_score=true;
	}
}
/**
 * @author Akash17013 Aatish17001
 * menubutton
 */
class MenuButton extends StackPane{
		 private Text text;
		 MenuButton(String name){
			 text=new Text(name);
			 text.setFont(text.getFont().font(30));
			 text.setFill(Color.WHITE);
			 this.setAlignment(Pos.CENTER);
			 getChildren().addAll(text);
			 this.setOnMouseExited(e->{
				 text.setTranslateX(0);
				 text.setFill(Color.WHITE);
			 });
			 this.setOnMouseEntered(e->{
				 text.setTranslateX(10);
				 text.setFill(Color.RED);
			 });
			 this.setOnMousePressed(e->{
			 this.setEffect(new MotionBlur());
			 });
		 }
	}
