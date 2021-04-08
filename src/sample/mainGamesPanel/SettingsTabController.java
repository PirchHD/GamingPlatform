package sample.mainGamesPanel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsTabController implements Initializable {

    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField firstnameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        phoneTextField.setText("dzialaa");
    }

}
