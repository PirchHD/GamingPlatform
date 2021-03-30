package sample.mainGamesPanel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataBaseConnection;
import sample.fileLoging.LoginController;
import sample.userInformation.Data_User;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GamePanelController implements Initializable {


    @FXML
    private Button cancelButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button setttingsButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button yourScoreButton;
    @FXML
    private Button globalButton;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private ImageView ImageUser; // TODO: image store in sql database. User the user should be able to change own image !

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         usernameLabel.setText(Data_User.username);
         firstnameLabel.setText(Data_User.firstname);
         lastnameLabel.setText(Data_User.lastname);
    }

    @FXML
    private void logOutButtonOnAction() throws IOException {
        GeneralButtonFunctions logOutAction = new GeneralButtonFunctions();
        logOutAction.logOutButtonOnAction(logOutButton);
    }

    @FXML
    private void cancelButtonOnAction() {
        GeneralButtonFunctions cancelAction = new GeneralButtonFunctions();
        cancelAction.cancelButtonOnAction(cancelButton);
    }

    @FXML
    private void settingsButtonOnAction() throws IOException {
        GeneralButtonFunctions settingsAction = new GeneralButtonFunctions();
        settingsAction.settingsButtonOnAction(setttingsButton);
    }

    @FXML
    private void homeButtonOnAction() throws IOException {
        GeneralButtonFunctions homeAction = new GeneralButtonFunctions();
        homeAction.openMainPanel();
    }




}
