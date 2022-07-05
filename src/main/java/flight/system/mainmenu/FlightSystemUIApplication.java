package flight.system.mainmenu;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightSystemUIApplication {
    public static void main(String[] args) {
        Application.launch(MenuApplication.class, args);
    }
}

