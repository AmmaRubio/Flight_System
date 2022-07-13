package Controllers;

import config.StageManager;
import flight.system.main.MenuApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;
import view.FxmlView;

public class MainMenuController {
    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void switchToAllFlightMenu(ActionEvent event) {
        stageManager.switchScene(FxmlView.ALL_FLIGHTS_MENU);
    }
    @FXML
    public void switchToEntertaimentMenu(ActionEvent event){
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }
}
