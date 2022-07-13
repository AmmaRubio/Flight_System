package Controllers;

import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class CityMenuController {
    @FXML
    private Label cityName;
    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void goBack(javafx.event.ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.ALL_FLIGHTS_MENU);
    }

    @FXML
    private void initialize() {
        cityName.setText("Munich");
    }


}
