
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;

/**
 * @author Akash17013 Aatish17001
 * This is the game class which 
 *
 */
public class Game extends Application {
	private double time=0;			// serialize this class at every moment i.e. serialize func must be there in update func
									// if face problem in serializing  whole class then serialize snake,sn,Elements,Values,player
	int mod=300;
	public static void main(String[] args){	
		launch(args);	
	}
	
	public static void begin(String[] args){	
		launch(args);	
	}
	private int count=0;
	private Label l;
	private boolean if_resume;
	private boolean active_magnet;
	private int time_of_active_magnet=1000;;
	private boolean playing;
	private Players current=new Players(1,"ab","12 oct,2017");
	private Text t;
	private Main_menu main_menu= new Main_menu();
	private Snake snake;
	private List <sprite> Elements= new ArrayList<sprite>();
	private List<Snake> sn= new ArrayList<Snake>();
	private Pane root = new Pane();
	private Stage window;
	List <Text> Values= new ArrayList<Text>();
	void serialise_player(Players current){
		//serialize player to the file used by highscores used to read <players>  
	}
	public void set_resume(){
		if_resume=true;
	}
	public void addobj(double time){
			if(time%mod==20){
				double m=Math.random();
				int ans= (int)(m*10);
				this.insert_coin(ans);
			}
			if((time%mod==40) ){
			double m=Math.random();
			int ans= (int)(m*10);
			if(m<0.16){
			this.insert_shield(ans);
			}
			else if(m<0.33)
				this.insert_destroy_block(ans);
			else if(m<0.50)
				this.insert_magnet(ans);
			else
				this.insert_ball(ans);
		}
		if(time%mod==0 ){
		for(int i=0;i<10;i++){
			double r=   Math.random();
				if(r<0.5)
			{
			this.insert_block(i);
			}
			else if(r<0.6){
			Wall wall=new Wall(60*i,50);
			root.getChildren().addAll(wall);
			Elements.add(wall);
			}
			}
		}
	}
	@Override	
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
			window=primaryStage;
			MenuBar m= new MenuBar();
			playing = true;
			
			Gamestarter2.flag=true;
			this.active_magnet=false;
			VBox menu=new VBox();
			root.setPrefSize(600, 800);
			Magnet m22 = new Magnet(150,300);
			root.getChildren().add(m22);
			Menu options= new Menu("Options");
			Menu newgame= new Menu("Start A New Game..");
			Menu mainmenu= new Menu("Go To Main Menu..");
			newgame.setOnAction(e->{
				try {
					this.start(window);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			mainmenu.setOnAction(e->{
				Main_menu m1= new Main_menu();
				try {
					m1.start(window);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			options.getItems().add(newgame);
			options.getItems().add(mainmenu);
			newgame.setOnAction(e->{
				try {
					try {
						new Game().start(window);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			sprite abc= new sprite(0,0,600,800,"heyy",Color.BLACK,7);
			newgame.setOnAction(e->{
				System.out.println("Shh");
			});
			root.getChildren().add(abc);
			snake=new Snake();	
			t= new Text(Integer.toString(snake.getLength()));
			t.setX(310);
			t.setY(600);
			t.setFill(Color.WHITE);
			AnimationTimer timer=new AnimationTimer(){
				@Override
				public void handle(long now){
					if(playing==true)
					update(snake);
				}
			};
			timer.start();
	   		root.getChildren().addAll(snake,t);	
	   		for(int k=0;k<2;k++){
				Snake s= new Snake(snake);					
				sn.add(s);
				root.getChildren().add(s);
				}
			t.setText(Integer.toString(snake.getLength()));
    		l= new Label("Your score:"+current.getScore());
    		l.setTextFill(Color.WHITE);
    		m.getMenus().add(options);
			
    		menu.getChildren().addAll(m,root,l);
			Scene scene= new Scene(menu,600,800);
			if(if_resume==true){
		   		try {
					GameData data=deserializeDemo.desrialize();
					snake.setLength(data.getSnakelength());
					if(data.getSnakelength()-2>0);
					for(int k=0;k<data.getSnakelength()-2;k++){
						Snake s= new Snake(snake);					
						sn.add(s);
						root.getChildren().add(s);
						}
					current=data.getCurrentPlayer();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		   		
			}
			else{

			}
			scene.setFill(Color.BLACK);
			scene.setOnKeyPressed(e->{
				switch(e.getCode()){
				case UP : snake.moveup();
							for(int i=0;i<sn.size();i++){
								sn.get(i).moveup();
							}

	
			   	  break;
				case LEFT : if(snake.getTranslateX()>0){
							if(!snake.getcantmoveleft())
							t.setTranslateX(t.getTranslateX()-10);
							snake.moveleft();
							for(int i=0;i<sn.size();i++){
								sn.get(i).moveleft();
							}}

			      break;
				case RIGHT : 	if(snake.getTranslateX()<570){
								if(!snake.getcantmoveright())
								t.setTranslateX(t.getTranslateX()+10);
								snake.moveright();
								for(int i=0;i<sn.size();i++){
								sn.get(i).moveright();
								} 
				}
								break;
				}
			});
			
			window.setScene(scene);	
			window.show();

    }

	private void update(Snake snake){
	//	System.out.println(time);
		time+=1;
		if(this.time_of_active_magnet>0){
			this.time_of_active_magnet--;
			if(this.time_of_active_magnet==0)
			this.active_magnet=false;
		}
	/*	if(time>500)
			time=0;
	*/	addobj(time);
		for(int i=0;i<Elements.size();i++){
		if(Elements.get(i).getTranslateY()>=750){
			root.getChildren().remove(Elements.get(i).getT());
			root.getChildren().remove(Elements.get(i));

			Elements.remove(i);
		}}
		for(int i=0;i<Elements.size();i++){
			if(this.active_magnet==true){
				if(Elements.get(i).getType().contains("coin")){
					int abc=(int) Math.abs(snake.getTranslateX()-Elements.get(i).getTranslateX());
				//	System.out.println(abc);
					int bcd=(int) (snake.getTranslateY()-Elements.get(i).getTranslateY());
					if( abc<150 && bcd<50){
						current.IncreaseScore(10);
						root.getChildren().remove(Elements.get(i).getT());
						root.getChildren().remove(Elements.get(i));
						Elements.remove(i);
					}
				}
			}}
		for(int i=0;i<Elements.size();i++){
			
			Elements.get(i).movedown(this.get_diffiulty());
			if(Elements.get(i).getBoundsInParent().intersects(snake.getBoundsInParent())){

			switch(Elements.get(i).getType()){
			case "ball" :  								
					for(int k=0;k<Elements.get(i).value;k++){
					Snake s= new Snake(snake);					
					sn.add(s);
					root.getChildren().add(s);
					}
					t.setText(Integer.toString(snake.getLength()));
					root.getChildren().remove(Elements.get(i).getT());
					root.getChildren().remove(Elements.get(i));
					Elements.remove(i);
			
			
			break;
			case "block":		System.out.println(snake.check_shield((int)time));
								if(snake.check_shield((int)time)){
								current.IncreaseScore(Elements.get(i).getValue());
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
							}
								else	{
							if(Elements.get(i).getValue()<=5 && snake.getLength()>=5){
								current.IncreaseScore(Elements.get(i).getValue());
								snake.decrease_length(Elements.get(i).getValue());
								for(int j=0;j<Elements.get(i).getValue();j++){
									root.getChildren().remove(sn.get(sn.size()-1));
									sn.remove(sn.size()-1);			
								}
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
							}
							else if(Elements.get(i).getValue()>=snake.getLength()){
									try {
											playing=false;
											main_menu.setShow_score(current.getScore());
											end();
											main_menu.start(window);
											
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							}
							else{
								current.IncreaseScore(Elements.get(i).getValue());
								snake.decrease_length(Elements.get(i).getValue());
								for(int j=0;j<Elements.get(i).getValue();j++){
									root.getChildren().remove(sn.get(sn.size()-1));
									sn.remove(sn.size()-1);			
								}
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
							}
							t.setText(Integer.toString(snake.getLength()));}
			break;
			case "wall": 		try {
									if(Elements.get(i).getTranslateX()<snake.getTranslateX()){
										snake.cantmoveleft();
									for(int ik=0;ik<sn.size();ik++){
										sn.get(ik).cantmoveleft();
									}
			}
									else
									{		
										snake.cantmoveright();
										for(int ik=0;ik<sn.size();ik++){
										sn.get(ik).cantmoveright();
									}
			}
									
										} catch (Exception e) {
								e.printStackTrace();
								}
								break;
			case "destroy":		root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
								int p=des();
								current.IncreaseScore(p);
								break;
								
			case 	"shield": 	snake.activate_shield((int)time);
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
								break;
			case 	"magnet": 	this.active_magnet=true;
							
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
			break;
			case  "coin": 		current.IncreaseScore(10);
								root.getChildren().remove(Elements.get(i).getT());
								root.getChildren().remove(Elements.get(i));
								Elements.remove(i);
								break;
		}
		}}
		for(int i=0;i<Values.size();i++){
			Values.get(i).setTranslateY(Values.get(i).getTranslateY()+this.get_diffiulty());
		}
		serialize();
		l.setText("Your score:"+current.getScore());
	}
	private void end(){
		Gamestarter2.myData.getList().add(current);
		Gamestarter2.myData.setSnakelength(0);
		
		Gamestarter2.myData.setAvailable(false);
		System.out.println("GAME END "+		Gamestarter2.myData.isAvailable());
//		Gamestarter2.flag=false;
	}
	private void serialize(){
	
		Gamestarter2.myData.setAvailable(true);
		Gamestarter2.myData.setCurrentPlayer(current);
		Gamestarter2.myData.setSnakelength(snake.getLength());

	}
	public void set_current_name(String s){
//		current.setName(s);
		current= new Players(0,s, "5 dec 2017");
	}
	private int des(){
		int points=0;
		for(int i=0;i<Elements.size();i++){
			if(Elements.get(i).getType().contains("block") && Elements.get(i).getTranslateY()<800){
			points+=Elements.get(i).getValue();
			root.getChildren().remove(Elements.get(i).getT());
			root.getChildren().remove(Elements.get(i));
			Elements.remove(i);
			i--;
			}
		}
		return points;
	}
	private int get_diffiulty(){
		// TODO Auto-generated method stub
		int c=(snake.getLength()/10)+1;
		if(c>5)
			c=5;
		int trm=(int)time/1000;
		if(c<trm)
			c=trm;

		mod=300-(50*c);
		if(mod<50)
			mod=50;
		return c;
	}
	private void insert_ball(int i){
		Ball ball=new Ball((int)(60*i),0);
		Elements.add(ball);
		Text t= new Text(Integer.toString(ball.getValue()));
		t.setX((60*i)+5);
		t.setY(0);
		t.setFill(Color.WHITE);
		ball.setT(t);
		Values.add(ball.getT());
		root.getChildren().addAll(ball.getT(),ball);
	}
	private void insert_coin(int i){
		Coins coin=new Coins((int)(60*i),0);
		Elements.add(coin);
		Text t= new Text("$");
		t.setX((60*i)+10);
		t.setY(20);
		t.setFill(Color.RED);
		t.setFont(t.getFont().font(20));
		coin.setT(t);
		Values.add(coin.getT());
		//coin.setEffect(new Lighting());
		root.getChildren().addAll(coin,coin.getT());
	}
	private void insert_block(int i){
		Block block= new Block(60*i,0,60,60,snake.getLength());
		Text t= new Text(Integer.toString(block.getValue()));
		t.setTranslateX((60*i)+20);
		t.setTranslateY(40);
		t.setFont(t.getFont().font(30));
		t.setFill(Color.WHITE);
		block.setT(t);
		Values.add(block.getT());
		root.getChildren().addAll(block,block.getT());
		Elements.add(block);
	}
	private void insert_magnet(int i){
		Magnet magnet= new Magnet(60*i,0);
		Text t= new Text("M");
		t.setTranslateX((60*i)+18);
		t.setTranslateY(40);
		t.setFont(t.getFont().font(30));
		t.setFill(Color.WHITE);
		magnet.setT(t);
		Values.add(magnet.getT());
		root.getChildren().addAll(magnet,magnet.getT());
		Elements.add(magnet);
	}
	private void insert_destroy_block(int i){
		Destroy_blocks dest= new Destroy_blocks(60*i,50);
		Text t= new Text("D");
		t.setTranslateX((60*i)+18);
		t.setTranslateY(90);
		t.setFont(t.getFont().font(30));
		t.setFill(Color.WHITE);
		dest.setT(t);
		Values.add(dest.getT());
		root.getChildren().addAll(dest,dest.getT());
		Elements.add(dest);

	}
	private void insert_shield(int i){
		Shield shield= new Shield(60*i,50);
		Text t= new Text("S");
		t.setTranslateX((60*i)+18);
		t.setTranslateY(90);
		t.setFont(t.getFont().font(30));
		t.setFill(Color.WHITE);
		shield.setT(t);
		Values.add(shield.getT());
		root.getChildren().addAll(shield,shield.getT());
		Elements.add(shield);

	}
}
	class sprite extends Rectangle{
	private String type;
	protected int value;
	private Text t;
	sprite(int x,int y,int w,int h,String type,Color color, int v){
	super(w,h,color);
	this.type=type;
	this.value=v;
	setTranslateX(x);
	setTranslateY(y);
	if(type.contains("ball")){
		this.setArcHeight(30);
		this.setArcWidth(30);			
	}
	}
	String getType(){
		return type;
	}
	void movedown(int i){
		setTranslateY(this.getTranslateY()+i);
	}
	int getValue(){
		return value;
	}
	Text getT(){
		return t;
	}
	void setT(Text t){
		this.t=t;
	}

}
//	Refernce(2 Youtube Videos):
//		https://youtu.be/FVo1fm52hz0
//		https://youtu.be/aOcow70vqb43
