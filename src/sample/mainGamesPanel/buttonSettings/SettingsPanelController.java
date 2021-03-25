package sample.mainGamesPanel.buttonSettings;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.mainGamesPanel.CreatorStage;
import sample.mainGamesPanel.GeneralButtonFunctions;

import java.io.IOException;

//https://www.promotic.eu/pl/pmdoc/Subsystems/Db/MsSQL/Statmn/Update.htm

public class SettingsPanelController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button setttingsButton;
    @FXML
    private Button logOutButton;

    @FXML
    private void cancelButtonOnAction() {
        GeneralButtonFunctions cancelAction = new GeneralButtonFunctions();
        cancelAction.cancelButtonOnAction(cancelButton);
    }

    @FXML
    private void logOutButtonOnAction() throws IOException {
        GeneralButtonFunctions logOutButtonAction = new GeneralButtonFunctions();
        logOutButtonAction.cancelButtonOnAction(logOutButton);
    }



}
