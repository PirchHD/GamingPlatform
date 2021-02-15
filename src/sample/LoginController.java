package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class LoginController {
    @FXML
    private Button cancelButton;

    public void cancelButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
