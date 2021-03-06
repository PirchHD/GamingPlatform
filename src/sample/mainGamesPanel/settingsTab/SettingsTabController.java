package sample.mainGamesPanel.settingsTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sample.userInformation.Data_User;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsTabController implements Initializable {

    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;

    @FXML
    private PasswordField passwordTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Data_User data_user = new Data_User(Data_User.username);
        data_user.getDataFromDatabase();

        firstnameTextField.setText(data_user.firstname);
        lastnameTextField.setText(data_user.lastname);
        passwordTextField.setText("password");
    }

    public void changeButtonOnAction() {
        if(!firstnameTextField.getText().equals(Data_User.firstname)
            || !lastnameTextField.getText().equals(Data_User.lastname) ){
            Data_User data_user = new Data_User(Data_User.username);
            data_user.changeDataToDatabase(firstnameTextField.getText(),lastnameTextField.getText());
        }

        if(!passwordTextField.getText().equals("password")){
            Data_User data_user = new Data_User(Data_User.username);
            data_user.changePassword(passwordTextField.getText());
        }

    }
}
