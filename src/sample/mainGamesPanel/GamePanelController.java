package sample.mainGamesPanel;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
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

    @FXML
    private TableView<ModelTable> tableView;


    @FXML
    private TableColumn<ModelTable,String> col_username;

    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         usernameLabel.setText(Data_User.username);
         firstnameLabel.setText(Data_User.firstname);
         lastnameLabel.setText(Data_User.lastname);

        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery("SELECT * FROM Friends");

            while (queryResult.next()){
               oblist.add(new ModelTable(queryResult.getString("username_your_friend")));
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        tableView.setItems(oblist);

    }

    @FXML
    private void searchButtonOnAction() throws IOException {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyFindYourFriend = "SELECT * FROM users_information " +
                "WHERE username = '" + findYourFriendTextField.getText() + "'";


        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyFindYourFriend);

            while (queryResult.next()){

                    AddFriend(queryResult.getString("id_account"), queryResult.getString("username"),
                            queryResult.getString("lastname"), queryResult.getString("firstname"));

                MessageAboutFindingFriend.setText("udalo sie");
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    private void AddFriend(String id_your_friend, String username_your_friend,
                           String lastname_your_friend, String firstname_your_friend){

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();


        String insertToTabelFriends = "INSERT INTO Friends(id_account,id_your_friend, " +
                "username_your_friend, lastname_your_friend, firstname_your_friend)" +
                " VALUES ( (SELECT id_account FROM users_information WHERE username='" + Data_User.username + "'),"
                + id_your_friend +", '"+ username_your_friend +"', '" + lastname_your_friend +"','" + firstname_your_friend+"')";

        try{
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(insertToTabelFriends);

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
