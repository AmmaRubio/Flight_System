package Controllers;

import MockClasses.Flight;
import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import view.FxmlView;


import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AllFlightsMenuController implements Initializable {
    private StageManager stageManager = MenuApplication.getStageManager();

    @FXML private Label label;
    @FXML private TableView table;
    @FXML private TableColumn<Flight,String> id;
    @FXML private TableColumn<Flight,String> company;
    @FXML private TableColumn<Flight, Hyperlink> departure;
    @FXML private TableColumn<Flight,String> destination;
    @FXML private TableColumn<Flight,String> date;
    @FXML private TableColumn<Flight,String> departureTime;
    @FXML private TableColumn<Flight,String> destinationTime;
    @FXML private TableColumn<Flight,String> duration;


    //Mock data: TODO: implement normal data. Only this should be changed
    private final ObservableList<Flight> mockData =
            FXCollections.observableArrayList(new Flight(1L,"Munich","Frankfurt",
                    LocalDate.of(2022,12,7),LocalTime.of(12,00),
                    LocalTime.of(14,00), "LH"));

    public void switchToMainMenu(ActionEvent event){
        stageManager.switchScene(FxmlView.MAIN_MENU);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Flight, String>("id"));
        company.setCellValueFactory(new PropertyValueFactory<Flight, String>("company"));
        departure.setCellValueFactory(new PropertyValueFactory<Flight, Hyperlink>("departure"));
        destination.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
        date.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
        departureTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureTime"));
        destinationTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationTime"));
        duration.setCellValueFactory(new PropertyValueFactory<Flight, String>("duration"));
        table.getItems().setAll(mockData);

    }

    public void switchToCityMenu(ActionEvent event){

    }
}
