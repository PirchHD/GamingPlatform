package sample.fileLoging;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import sample.DataBaseConnection;
import sample.mainGamesPanel.CreatorStage;
import sample.userInformation.Data_User;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private static String username;

    @FXML
    private Button cancelButton;
    @FXML
    private Label invalidMessage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    public void loginButtonOnAction(){

        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){
            checkoutLogging();
        }else{
            invalidMessage.setText("Please enter username and password");
        }

    }

    @FXML
    private void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    public void checkoutLogging(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();


        String verifyLogin = "SELECT count(1) FROM users_information WHERE username = '" + usernameTextField.getText()
                                                                + "' AND password = '" + passwordTextField.getText() + "';";

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1) {
                    username = usernameTextField.getText();

                    initializeDataUserToClassData_User();

                    invalidMessage.setText("You are in!!!");
                    openGamePanel();
                }else {
                    invalidMessage.setText("Invalid login :( try again");
                }

            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void openGamePanel(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

        try{
            CreatorStage openRegisterStage = new CreatorStage();
            openRegisterStage.creatStage("../mainGamesPanel/gamePanel.fxml",1232,907);

        }catch (Exception e){
            e.getMessage();
        }
    }

    public void creatAccountForm() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

        CreatorStage registerStage = new CreatorStage();
        registerStage.creatStage("../fileRegister/register.fxml", 607, 602);

    }

    public void initializeDataUserToClassData_User(){

        try {
            Connection con = new DataBaseConnection().getConnection();
            Statement myStmt = con.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from users_information WHERE username = '" + username + "';");
            while (myRs.next()) {
                Data_User.username = myRs.getString("username");
                Data_User.firstname = myRs.getString("firstname");
                Data_User.lastname = myRs.getString("lastname");
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
