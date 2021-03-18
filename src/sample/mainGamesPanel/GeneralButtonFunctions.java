package sample.mainGamesPanel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GeneralButtonFunctions {

    @FXML
    public void cancelButtonOnAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



}
