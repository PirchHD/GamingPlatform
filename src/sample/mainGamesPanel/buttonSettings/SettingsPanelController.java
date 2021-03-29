package sample.mainGamesPanel.buttonSettings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.mainGamesPanel.CreatorStage;
import sample.mainGamesPanel.GeneralButtonFunctions;
import sample.userInformation.Data_User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//https://www.promotic.eu/pl/pmdoc/Subsystems/Db/MsSQL/Statmn/Update.htm

public class SettingsPanelController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button setttingsButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameLabel.setText(Data_User.username);
        firstnameLabel.setText(Data_User.firstname);
        lastnameLabel.setText(Data_User.lastname);
    }

    @FXML
    private void cancelButtonOnAction() {
        GeneralButtonFunctions cancelAction = new GeneralButtonFunctions();
        cancelAction.cancelButtonOnAction(cancelButton);
    }

    @FXML
    private void logOutButtonOnAction() throws IOException {
        GeneralButtonFunctions logOutAction = new GeneralButtonFunctions();
        logOutAction.logOutButtonOnAction(logOutButton);
    }



}
