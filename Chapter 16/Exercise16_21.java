import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Exercise16_21 extends Application{
	
	private Timeline timeline;
	private TextField textField = new TextField();
	private Text text = new Text(50,50, "Enter time above");
	
	
	
	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start (Stage primaryStage) {
		primaryStage.setTitle("Exercise16_21");
		BorderPane pane = new BorderPane();
		pane.setTop(textField);
		Pane middlePane = new Pane();
		pane.getChildren().add(text);
		pane.setCenter(middlePane);
		text.setFill(Color.BLACK);
		
		
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(Timeline.INDEFINITE);
		
		
		timeline = new Timeline();
		
		
		
		textField.setOnAction(e -> {
			if (timeline != null) {
                timeline.stop();
            }
			int timeValue = Integer.parseInt(textField.getText());
			IntegerProperty timeInSeconds = new SimpleIntegerProperty(timeValue);
			text.setText(textField.getText());
			text.textProperty().bind(timeInSeconds.asString());
			
			timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(timeValue+1),new KeyValue(timeInSeconds, 0)));
			timeline.playFromStart();
			
		});
		
		timeline.setOnFinished(e ->{
			mediaPlayer.play();
			System.out.println("Completed");
		});
		
		
		Scene scene = new Scene(pane, 300, 250);
		primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	
}