package sample;

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
import sample.GamePanel.GamePanelController;

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
    public void initialize(URL url, ResourceBundle resourceBundle) { }

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
            Parent root = FXMLLoader.load(getClass().getResource("FXML-Files/gamePanel.fxml"));
            Stage stageGamePanel = new Stage();
            stageGamePanel.initStyle(StageStyle.UNDECORATED);
            stageGamePanel.setScene(new Scene(root));
            stageGamePanel.show();

        }catch (Exception e){
            e.getMessage();
        }
    }

    public void creatAccountForm(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML-Files/register.fxml"));
            Stage stageRegister = new Stage();
            stageRegister.initStyle(StageStyle.UNDECORATED);
            stageRegister.setScene(new Scene(root, 607, 602));
            stageRegister.show();

        }catch (Exception e){
            e.getMessage();
        }

    }


}
