import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;


public class moveBall extends Application{
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane bpane = new BorderPane();
		
		// creates a row of buttons
		Button btUp = new Button("Up");
	    Button btDown = new Button("Down");
	    Button btLeft = new Button("Left");
	    Button btRight = new Button("Right");
	    HBox hBox = new HBox(btUp, btDown, btLeft, btRight);
	    hBox.setSpacing(10);
	    hBox.setAlignment(Pos.CENTER);
		
		
		// creates a circle
		Circle circle = new Circle();
		circle.setCenterX(50);
		circle.setCenterY(50);
		circle.setRadius(25);
		circle.setStroke(Color.BLACK);
		circle.setFill(null);
		
		Pane pane = new Pane(circle);
		
		bpane.setCenter(pane);
		bpane.setBottom(hBox);
		
		
		// set up handlers
		btUp.setOnAction(e -> {
			circle.setCenterY(circle.getCenterY() > 10 ? circle.getCenterY() - 5 : 10);
		});
		btDown.setOnAction(e ->{
			circle.setCenterY(circle.getCenterY() < pane.getHeight() ? circle.getCenterY() + 5 : pane.getHeight());
		});
		btLeft.setOnAction(e -> {
			circle.setCenterX(circle.getCenterX() > 10 ? circle.getCenterX() - 5 : 10);
		});
		btRight.setOnAction(e ->{
			circle.setCenterX(circle.getCenterX() < pane.getWidth() ? circle.getCenterX() + 5 : pane.getWidth());
		});
		
		Scene scene = new Scene(bpane,200,200);
		primaryStage.setTitle("Move Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
public static void main(String[] args) {
	launch(args);
}
}
