package application.Controllers.layout;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WarningController {

    @FXML 
    private javafx.scene.control.Button warningOKBtn;
    @FXML
    public Label warningText;
    
    public void setMessage(String msg) throws IOException {
        warningText.setText(msg);
    }
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    public void closeDialog(ActionEvent event){
        
        Stage stage = (Stage) warningOKBtn.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
