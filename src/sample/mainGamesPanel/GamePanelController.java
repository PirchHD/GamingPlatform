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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DataBaseConnection;
import sample.fileLoging.LoginController;
import sample.userInformation.Data_User;


import java.awt.*;
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
   @FXML
   private AnchorPane settingsPanel;
    @FXML
    private AnchorPane homePanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         allPanelsetVisableFalse();
         homePanel.setVisible(true);
         usernameLabel.setText(Data_User.username);
         firstnameLabel.setText(Data_User.firstname);
         lastnameLabel.setText(Data_User.lastname);
    }

    public void allPanelsetVisableFalse(){
        settingsPanel.setVisible(false);
        homePanel.setVisible(false);
    }

    @FXML
    private void logOutButtonOnAction() throws IOException {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();

        CreatorStage loginStage = new CreatorStage();
        loginStage.creatStage("../fileLoging/login.fxml", 564, 428);
    }

    @FXML
    private void cancelButtonOnAction() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void settingsButtonOnAction() throws IOException {
        allPanelsetVisableFalse();
        settingsPanel.setVisible(true);
    }

    @FXML
    private void homeButtonOnAction() throws IOException {
        allPanelsetVisableFalse();
        homePanel.setVisible(true);
    }






}
