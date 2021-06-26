package sample.mainGamesPanel;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
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
    private Button searchButton;

    @FXML
    private Label usernameLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;
    @FXML
    private ImageView ImageUser; // TODO: image store in sql database. User the user should be able to change own image !

    @FXML
    private Label MessageAboutFindingFriend;

    @FXML
    private TextField findYourFriendTextField;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         usernameLabel.setText(Data_User.username);
         firstnameLabel.setText(Data_User.firstname);
         lastnameLabel.setText(Data_User.lastname);
    }

    @FXML
    private void searchButtonOnAction() throws IOException {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyFindYourFriend = "SELECT count(1) FROM users_information " +
                "WHERE username = '" + findYourFriendTextField.getText() + "'";


        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyFindYourFriend);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1) {
                    MessageAboutFindingFriend.setText("I found a nickname");
                }else {
                    MessageAboutFindingFriend.setText("not found a nickname");
                }

            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
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
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }







}
