package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

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
            checkdateLogin();
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
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void checkdateLogin(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectionDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText()
                                                                + "' AND password = '" + passwordTextField.getText() + "';";

        try{
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1) {
                    invalidMessage.setText("You are in!!!");
                }else {
                    invalidMessage.setText("Invalid login :( try again");
                }

            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
