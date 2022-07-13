package Controllers;

import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class MovieMenuController {
    private StageManager stageManager = MenuApplication.getStageManager();
    public void goBackToEntertainmentMenu(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }
}
