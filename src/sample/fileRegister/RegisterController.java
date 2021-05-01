package sample.fileRegister;

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
import sample.DataBaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class RegisterController {

    @FXML
    private Button cancelButton;
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
        String password = passwordTextField.getText();
        if(checkPasswordTheSame(password) == true
            && usernameTextFieldShouldNotBeEmpty() == true) {
            registerUser();
            
            cancelButtonOnAction(actionEvent);

            Parent root = FXMLLoader.load(getClass().getResource("../fileLoging/login.fxml"));
            Stage stageLogin = new Stage();
            stageLogin.initStyle(StageStyle.UNDECORATED);
            stageLogin.setScene(new Scene(root, 564, 428));
            stageLogin.show();
        }


    }

    public boolean checkPasswordTheSame(String password){
        if(password.isBlank() == true || password.isEmpty() == true) {
            messageLabelRegister.setText("Change your password !");
           return false;
        }

        if (confirmPasswordTextField.getText().equals(password)) {
            return true;
        } else {
            messageLabelRegister.setText("Password does not match !");
            return false;
        }

    }

    public boolean usernameTextFieldShouldNotBeEmpty(){
        String temp = usernameTextField.getText().replaceAll("\\s+","");
        usernameTextField.setText(temp);

        if(usernameTextField.getText().isBlank() == true || usernameTextField.getText().isEmpty() == true){
            messageLabelRegister.setText("Change your username");
            return false;
        }else{
            return true;
        }
    }

    public void registerUser(){
        DataBaseConnection connect = new DataBaseConnection();
        Connection connectDB = connect.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();



        String insertToRegister = "INSERT INTO users_information(lastname,firstname,username,password) " +
                "VALUES ('" + firstname + "','" +  lastname + "','" + username + "','" + password + "')";

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            messageLabelRegister.setText("User has been registered successfully !");

        }catch (Exception e){
            messageLabelRegister.setText("your username is taken ! ");

            e.printStackTrace();
            e.getCause();
        }


    }


}
