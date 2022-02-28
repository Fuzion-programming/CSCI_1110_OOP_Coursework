import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class Exercise16_01 extends Application{
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		// create top row and space out items
		HBox paneForRadioButtons = new HBox(20);
		paneForRadioButtons.setAlignment(Pos.CENTER);
		paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
		
		// create radio buttons and group them together
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton blackButton = new RadioButton("Black");
		RadioButton orangeButton = new RadioButton("Orange");
		RadioButton greenButton = new RadioButton("Green");
		ToggleGroup group = new ToggleGroup();
		redButton.setToggleGroup(group);
		yellowButton.setToggleGroup(group);
		blackButton.setToggleGroup(group);
		orangeButton.setToggleGroup(group);
		greenButton.setToggleGroup(group);
		// add radio buttons to pane
		paneForRadioButtons.getChildren().addAll(redButton,yellowButton,blackButton,orangeButton,greenButton);
		
		// place radio buttons pane to the top of border pane
		pane.setTop(paneForRadioButtons);
		
		// create text, pane for text, and set it in center of border pane
		Pane paneForText = new Pane();
		Text text = new Text(50, 50, "Programming is fun");
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		paneForText.setStyle("-fx-border-color:black;");
		
		// create buttons, create buttons pane, set them in bottom of border pane
		HBox paneForButtons = new HBox(20);
		paneForButtons.setAlignment(Pos.CENTER);
		Button btnLeft = new Button("Left", new ImageView("image/left.png"));
		Button btnRight = new Button("Right", new ImageView("image/right.png")); 
		paneForButtons.getChildren().addAll(btnLeft,btnRight);
		pane.setBottom(paneForButtons);
		
		// set listeners for left and right arrow mouse clicks
		btnLeft.setOnAction(e -> text.setX(text.getX()-10));
		btnRight.setOnAction(e -> text.setX(text.getX()+ 10));
		
		// set listeners for radio buttons
		redButton.setOnAction(e ->{
			if(redButton.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		
		yellowButton.setOnAction(e -> {
			if(yellowButton.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		blackButton.setOnAction(e -> {
			if(blackButton.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		orangeButton.setOnAction(e ->{
			if(orangeButton.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		greenButton.setOnAction(e -> {
			if(greenButton.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		
		
		Scene scene = new Scene(pane,400,200);
		primaryStage.setTitle("Exercise16_01"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	
	}
	public static void main(String[] args) {
	    launch(args);
	  }
	
}
