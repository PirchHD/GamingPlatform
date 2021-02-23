package sample.GamePanel;

import com.sun.javafx.sg.prism.NGShape;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.DataBaseConnection;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class GamePanelController implements Initializable {

    private String username;

    @FXML
    private Button cancelButton;

    @FXML
    private Label usernameLabel;
    @FXML
    private Label firstnameLabel;
    @FXML
    private Label lastnameLabel;



    @FXML
    private void cancelButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        try {
            Connection con = new DataBaseConnection().getConnection();
            Statement myStmt = con.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from user_account WHERE username = 'PirchHD';");
            while (myRs.next()) {
                // testing if it gets the data from the db
                System.out.println(myRs.getString("firstname"));
                System.out.println(myRs.getString("lastname"));

                // attempt to put it in a textfield
                firstnameLabel.setText(myRs.getString("firstname"));
                lastnameLabel.setText(myRs.getString("lastname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void setUsername(String username) {
        this.username = username;
    }

}
