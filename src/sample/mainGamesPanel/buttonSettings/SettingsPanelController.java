package sample.mainGamesPanel.buttonSettings;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.mainGamesPanel.CreatorStage;
import sample.mainGamesPanel.GeneralButtonFunctions;

import java.io.IOException;



public class SettingsPanelController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button setttingsButton;

    @FXML
    private void settingsButtonOnAction() throws IOException {
        CreatorStage stage = new CreatorStage();
        stage.creatStage("buttonSettings/settingsPanel.fxml", 607, 602);
    }

    @FXML
    private void cancelButtonOnAction() {
        GeneralButtonFunctions cancelAction = new GeneralButtonFunctions();
        cancelAction.cancelButtonOnAction(cancelButton);
    }


}
