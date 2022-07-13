package Controllers;

import config.StageManager;
import flight.system.main.MenuApplication;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class ServiceMenuController {
    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void goBackToEntertainmentMenu(javafx.event.ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }
}
