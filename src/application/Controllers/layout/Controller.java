package application.Controllers.layout;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import application.Modules.effects.transition;

public class Controller implements Initializable {
	public double sideBarWidth = 0;
	public transition transition = new transition();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleSideBar();
	}
	@FXML
    private AnchorPane sideBar;

    @FXML
    private AnchorPane container;

    @FXML
    private AnchorPane titleBar;

    @FXML
    private JFXButton sidebarBtn;
    
    @FXML
    private AnchorPane contentArea;

    @FXML
    void toggleSidebarEvent(ActionEvent event) {
    	toggleSideBar();
    }
    @FXML
    void openRawatJalan(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/views/perawatan/rawatjalan.fxml"));
			contentArea.getChildren().setAll(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	private void toggleSideBar() {
		double w = sideBar.getPrefWidth();
		sideBar.setPrefWidth(sideBarWidth);
		AnchorPane.setLeftAnchor(container, sideBarWidth);
		transition.fadeIn(500, sideBar);
		sideBarWidth = w;
	}
}
