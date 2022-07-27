package config;

/*
Manages switching scenes on the primary stage
 */

import DB.client.City.City;
import com.sun.javafx.fxml.BeanAdapter;
import flight.system.mainmenu.MenuApplication;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import view.FxmlView;

import java.io.IOException;
import java.util.Objects;


public class StageManager {

    private final Stage primaryStage;
    private FXMLLoader fxmlLoader;
    /**
     * used by CityMenuController to identify the city - not very nicely implemented though :)
     */
    private City currentCity;

public StageManager(FXMLLoader fxmlLoader, Stage stage) {
        this.fxmlLoader = fxmlLoader;
        this.primaryStage = stage;
    }


    public void switchScene( FxmlView view)  {
    if(view == FxmlView.ALL_FLIGHTS_MENU){
        try {
            fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("AllFlightsMenu.fxml"));
            fxmlLoader.setControllerFactory(aClass -> MenuApplication.getApplicationContext().getBean(aClass));
            Parent rootnode = fxmlLoader.load();
            primaryStage.setScene(new Scene(rootnode));
            primaryStage.show();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    else {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
        System.out.println("got the fxml path: " + view.getFxmlFile());
        show(viewRootNodeHierarchy, view.getTitle());
    }
    }
    public void switchScene( FxmlView view, City city)  {
        if(view == FxmlView.ALL_FLIGHTS_MENU){
            try {
                fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("AllFlightsMenu.fxml"));
                fxmlLoader.setControllerFactory(aClass -> MenuApplication.getApplicationContext().getBean(aClass));
                Parent rootnode = fxmlLoader.load();
                primaryStage.setScene(new Scene(rootnode));
                primaryStage.show();
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        else {
            this.currentCity = city;
            Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
            System.out.println("got the fxml path: " + view.getFxmlFile());
            show(viewRootNodeHierarchy, view.getTitle());
        }
    }

    private void show(final Parent rootNode, String title) {
        System.out.println("show function triggered");
        Scene scene = prepareScene(rootNode);
        primaryStage.setTitle(title);
        System.out.println(title);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private Parent loadViewNodeHierarchy(String fxmlPath) {
        Parent rootNode = null;
        try {
            fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlPath));
            rootNode = fxmlLoader.load();
            Objects.requireNonNull(rootNode, "A root FXML node must be not null");
        } catch (Exception e) {
            exit("Unable to load FXML view " + fxmlPath, e);
        }
        return  rootNode;
    }

    private Scene prepareScene(Parent rootNode) {
        Scene scene = primaryStage.getScene();
        if (scene == null) {
            scene = new Scene(rootNode);
        }
        scene.setRoot(rootNode);
        return scene;
    }

    private void exit(String errMsg, Exception e){
        System.out.println(errMsg + e.getCause());
        Platform.exit();
    }

    public City getCurrentCity() {
        return currentCity;
    }
}
