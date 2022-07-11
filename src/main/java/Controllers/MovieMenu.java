package Controllers;

import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import view.FxmlView;

public class MovieMenu {
    private StageManager stageManager = MenuApplication.getStageManager();
    public void goBackToEntertainmentMenu(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }
}
