import javax.sound.sampled.AudioPermission;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ScrollPane;
import javafx.scene.media.MediaView;
import javafx.util.Duration; 

public class finalProject extends Application {
	
	private Duration duration;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane pane = new BorderPane();
		BorderPane altpane = new BorderPane();
		
		Pane paneForText = new Pane();
		Text text = new Text(20, 20, "anthem0.mp3");
		text.setTextAlignment(TextAlignment.CENTER);
		
		text.setStyle(
				"-fx-font-family: \"Times New Roman\";" +
				"-fx-font-weight: bold;" +
				"-fx-font-size: 32px;");
		
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		Text text2 = new Text(20,20,"");
		text.setTranslateX(50);
		text.setTranslateY(50);
		pane.setTop(text2);
		
		//Media media = new Media("file:/Users/student/eclipse-workspace/FinalProject/src/image/enemy.mp3");
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		
		
		
		MediaView viewer = new MediaView();
		
		HBox paneForButtons = new HBox(20);
		
		Button playBtn = new Button("Play");
		Button pauseBtn = new Button("Pause"); 
		// Button testBtn = new Button("Test");
		paneForButtons.getChildren().addAll(playBtn, pauseBtn);
		paneForButtons.setAlignment(Pos.CENTER);
		pane.setBottom(altpane);
		altpane.setCenter(paneForButtons);
		
		Slider slVertical = new Slider();
	    slVertical.setOrientation(Orientation.VERTICAL);
	    slVertical.setShowTickLabels(true);
	    slVertical.setShowTickMarks(true);
	    slVertical.setValue(100);
	    pane.setRight(slVertical);
	    
	    Slider slHorizontal = new Slider();
	    slHorizontal.setShowTickLabels(true);
	    
	    altpane.setTop(slHorizontal);
	    
	    slVertical.valueProperty().addListener(ov -> mediaPlayer.setVolume(slVertical.getValue() / 100));

	    playBtn.setOnAction(e ->{
	    	//viewer.setMediaPlayer(mediaPlayer);
			try {
				Thread.sleep(4000);
				duration = mediaPlayer.getMedia().getDuration();
				
			} catch (InterruptedException ex) {
				System.out.println("Failed");
			}
			mediaPlayer.play();
			
			//System.out.println("Initial Value: " + mediaPlayer.getTotalDuration());
			//mediaPlayer.seek(new Duration(mediaPlayer.getTotalDuration().toMillis() + 100));
			//System.out.println("10 Seconds later: " + mediaPlayer.getCurrentTime());
			//System.out.println(mediaPlayer.getStatus());
		});
	    pauseBtn.setOnAction(e -> mediaPlayer.pause());
		//testBtn.setOnAction(e -> System.out.println("Initial Value: " + mediaPlayer.getTotalDuration()));
	    
		mediaPlayer.currentTimeProperty().addListener(ov -> {
			System.out.println("Changing");
		});
		
		slHorizontal.valueProperty().addListener(ov -> mediaPlayer.seek(duration.multiply(slHorizontal.getValue() / 100)));
		
	    Scene scene = new Scene(pane,400,200);
		primaryStage.setTitle("finalProject.java"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}






