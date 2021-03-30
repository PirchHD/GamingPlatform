package sample.mainGamesPanel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneralButtonFunctions {

    public void cancelButtonOnAction(Button cancelButton) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void logOutButtonOnAction(Button logOutButton) throws IOException {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.close();

        CreatorStage loginStage = new CreatorStage();
        loginStage.creatStage("../fileLoging/login.fxml", 564, 428);
    }

    void settingsButtonOnAction(Button settingsButton) throws IOException {
        cancelButtonOnAction(settingsButton);

        CreatorStage stage = new CreatorStage();
        stage.creatStage("buttonSettings/settingsPanel.fxml",1232,907);
    }

    public void openMainPanel(){
        try{
            CreatorStage openRegisterStage = new CreatorStage();
            openRegisterStage.creatStage("../mainGamesPanel/gamePanel.fxml",1232,907);

        }catch (Exception e){
            e.getMessage();
        }
    }



}
