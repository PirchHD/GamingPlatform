package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
