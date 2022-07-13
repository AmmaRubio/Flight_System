package Controllers;


import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class EntertainmentMenuController {

    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void goToServiceMenu(javafx.event.ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.SERVICE_MENU);
    }

    public void goToMovieMenu(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.MOVIE_MENU);
    }

    public void goToMainMenu(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.MAIN_MENU);
    }


}
