import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.FadeTransition;

public class Animation extends Application{
	@Override
	public void start(Stage primaryStage) {
		
		double points[] = { 200.0, 300.0,
                300.0, 600.0,
                700.0, 600.0,
                800.0, 300.0,
                500.0, 100.0, };
		Polygon polygon = new Polygon(points);
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		
		Rectangle rectangle = new Rectangle(0,0,25,50);
		rectangle.setFill(Color.ORANGE);
		
		Pane pane = new Pane();
		pane.getChildren().add(polygon);
		pane.getChildren().add(rectangle);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(5000));
		pt.setPath(polygon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(5000),polygon);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		polygon.setOnMousePressed(e -> pt.pause());
		polygon.setOnMouseReleased(e -> pt.play());
		
		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}