package sample.mainGamesPanel;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class CreatorStage {

    public void creatStage(String pathToFXML, int width, int length) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(pathToFXML));
        Stage stageLogin = new Stage();
        stageLogin.initStyle(StageStyle.UNDECORATED);
        stageLogin.setScene(new Scene(root, width, length));
        stageLogin.show();
    }

}
