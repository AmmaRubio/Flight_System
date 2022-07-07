import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class MainMenuController {
    private final String ALLFLIGHTMENU_TITLE = "All flights Menu";
    @FXML
    Label label;


    public void switchToAllFlightMenu(ActionEvent event){
        try{
        Parent parent = FXMLLoader.load(getClass().getResource("AllFlightsMenu.fxml"));


        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle(ALLFLIGHTMENU_TITLE);
        stage.show();
    } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
