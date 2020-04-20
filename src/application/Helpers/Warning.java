package application.Helpers;

import java.io.IOException;

import application.Controllers.layout.WarningController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Warning {
	private double xOffset;    
    private double yOffset;  
    
    public static void showWarning(String msg) throws IOException{
        Warning warning=new Warning();
        warning.loadWarning(msg);
    }
    public  void loadWarning(String msg) throws IOException {
        
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/Warning.fxml"));
        final Parent root = loader.load();
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        WarningController controller;
        controller = loader.getController();
        controller.setMessage(msg);
    }
}
