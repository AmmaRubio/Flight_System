package flight.system.mainmenu;

import config.SpringFXMLLoader;
import config.StageManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import view.FxmlView;

import java.awt.*;

@SpringBootApplication
public class MenuApplication extends Application {
    protected ConfigurableApplicationContext applicationContext;
    public static StageManager stageManager;

    public static void run(final String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        stageManager = applicationContext.getBean(StageManager.class, stage);
        displayMenu();
    }

    public static StageManager getStageManager() {
        return stageManager;
    }

    @Override
    public void init() {
        applicationContext = springBootApplicationContext();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    protected void displayMenu() {
        System.out.println("displaying menu...");
        stageManager.switchScene(FxmlView.ENTERTAINMENT_MENU);
    }



    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MenuApplication.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }

}
