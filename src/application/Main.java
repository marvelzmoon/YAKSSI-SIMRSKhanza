package application;
	
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			stage.initStyle(StageStyle.DECORATED);
			Parent root = FXMLLoader.load(getClass().getResource("/application/views/main/layout.fxml"));
			FadeTransition ft = new FadeTransition(Duration.millis(1000), root);
			ft.setFromValue(0.0);
			ft.setToValue(1.0);
			ft.play();
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setResizable(true);
			scene.getStylesheets().add(getClass().getResource("/application/Assets/Css/application.css").toExternalForm());
			stage.show();
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		       @Override
		       public void handle(WindowEvent e) {
		          Platform.exit();
		          System.exit(0);
		       }
		    });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
