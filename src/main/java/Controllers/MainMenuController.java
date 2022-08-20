package Controllers;

import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
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
