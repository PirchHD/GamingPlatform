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


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GamePanelController implements Initializable {

    private String username;

    @FXML
    private Button cancelButton;
    @FXML
    private Button logOutButton;
    @FXML
    private Button setttingsButton;
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
        username = LoginController.username;

        try {
            Connection con = new DataBaseConnection().getConnection();
            Statement myStmt = con.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from user_account WHERE username = '" + username + "';");
            while (myRs.next()) {
                usernameLabel.setText(myRs.getString("username"));
                firstnameLabel.setText(myRs.getString("firstname"));
                lastnameLabel.setText(myRs.getString("lastname"));
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
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
        GeneralButtonFunctions cancelAction = new GeneralButtonFunctions();
        cancelAction.cancelButtonOnAction(cancelButton);
    }

    @FXML
    private void settingsButtonOnAction() throws IOException {
        cancelButtonOnAction();

        CreatorStage stage = new CreatorStage();
        stage.creatStage("buttonSettings/settingsPanel.fxml", 607, 602);
    }




}
