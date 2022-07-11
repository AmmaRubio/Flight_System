package config;

/*
Manages switching scenes on the primary stage
 */

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import view.FxmlView;

import java.util.Objects;


public class StageManager {
    private final Stage primaryStage;
    private FXMLLoader fxmlLoader;


    public StageManager(FXMLLoader fxmlLoader, Stage stage) {
        this.fxmlLoader = fxmlLoader;
        this.primaryStage = stage;
    }


    public void switchScene(final FxmlView view) {
        Parent viewRootNodeHierarchy = loadViewNodeHierarchy(view.getFxmlFile());
        System.out.println("got the fxml path: " + view.getFxmlFile());
        show(viewRootNodeHierarchy, view.getTitle());

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
            exit("Unable to load FXML view" + fxmlPath, e);
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






}
