package Controllers;


import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import view.FxmlView;

@Controller
public class EntertainmentMenu {

    private StageManager stageManager = MenuApplication.getStageManager();


    @FXML
    public void goToServiceMenu(javafx.event.ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.SERVICE_MENU);
    }

    public void goToMovieMenu(ActionEvent actionEvent) {
        stageManager.switchScene(FxmlView.MOVIE_MENU);
    }

    public void goToMainMenu(ActionEvent actionEvent) {
        System.out.println("No main menu implemented!");
    }
}
