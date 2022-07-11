package Controllers;

import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class ServiceMenu {
    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void goBackToEntertainmentMenu(javafx.event.ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }
}
