package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class RegisterController {

    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label messageLabelRegister;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;

    @FXML
    private void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registerButtonOnAction(ActionEvent actionEvent) throws IOException {
        checkPasswordTheSame();
        registerUser();

        cancelButtonOnAction(actionEvent);

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stageLogin = new Stage();
        stageLogin.initStyle(StageStyle.UNDECORATED);
        stageLogin.setScene(new Scene(root, 564, 428));
        stageLogin.show();

    }

    public void checkPasswordTheSame(){
        if(confirmPasswordTextField.getText().equals(passwordTextField.getText())){
        }else{
            messageLabelRegister.setText("Password does not match !");
        }
    }

    public void registerUser(){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connectDB = connect.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();


        String insertToRegister = "INSERT INTO user_account(lastname,firstname,username,password) " +
                "VALUES ('" + firstname + "','" +  lastname + "','" + username + "','" + password + "')";

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            messageLabelRegister.setText("User has been registered successfully !");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }


}
