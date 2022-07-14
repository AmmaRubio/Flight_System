package config;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

@Configuration
@ComponentScan("config")
@Component("Controllers")
public class AppJavaConfig {


    private FXMLLoader fxmlLoader;

    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("Bundle");
    }

    @Bean
    @Lazy(value = true) // Stage created only after Spring context bootstrap
    public StageManager stageManager(Stage stage) {
        return new StageManager(fxmlLoader, stage);
    }
}
