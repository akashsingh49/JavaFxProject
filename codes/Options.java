import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
 * helps in making the Options interface in the game 
 * - lists all the option and decides what to do when some option is clicked
 */
public class Options extends Application{
	private Stage window;
	Main_menu Menu;
	public static void main(String[] args){	
		launch(args);	
	}
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    public void start(Stage primarystage) throws Exception {
    		// TODO Auto-generated method stub
    		Pane root=new Pane();
    		Menu= new Main_menu();
    		window=primarystage;
    		root.setPrefSize(600, 800);
    		VBox menu=new VBox();
			menu.setTranslateX(400);
			menu.setTranslateY(400);
			MenuButton a1=new MenuButton("Graphic Settings");
			MenuButton a2=new MenuButton("Sound Settings");
			MenuButton a3=new MenuButton("Blah Blah Settings");
			MenuButton back=new MenuButton("Back to Main Menu");
			menu.getChildren().addAll(a1,a2,a3,back);
    		InputStream io=Files.newInputStream(Paths.get("res/images/snake1.jpg"));    		 
    		Image img =new Image(io);
    		io.close();
    		back.setOnMouseClicked(e->{
    			try {
					Menu.start(window);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		});
    		ImageView imgg=new ImageView(img);
    		imgg.setFitHeight(800);
    		imgg.setFitWidth(700);
    		root.getChildren().addAll(imgg,menu);
    		Scene scene = new Scene(root);
    		window.setScene(scene);
    		window.show();
    	
    	}
    
}