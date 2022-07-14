package Controllers;

import DB.client.flight.Flight;
import DB.client.flight.FlightWebClient;
import config.StageManager;
import flight.system.mainmenu.MenuApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import view.FxmlView;


import java.awt.*;
import java.io.Console;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.function.Consumer;



public class AllFlightsMenuController implements Initializable, Consumer<Flight> {
    private FlightWebClient flightWebClient;

    private StageManager stageManager = MenuApplication.getStageManager();

    public AllFlightsMenuController(FlightWebClient flightWebClient) {
        this.flightWebClient = flightWebClient;
       // this.stageManager = MenuApplication.getStageManager();
    }

    @FXML private Label label;
    @FXML private TableView table;
    @FXML private TableColumn<Flight,String> id;
    @FXML private TableColumn<Flight,String> company;
    @FXML private TableColumn<Flight, String> departure;
    @FXML private TableColumn<Flight,String> destination;
    @FXML private TableColumn<Flight,String> date;
    @FXML private TableColumn<Flight,String> departureTime;
    @FXML private TableColumn<Flight,String> destinationTime;
    @FXML private TableColumn<Flight,String> duration;
    private ObservableList<Flight> data;


    //Mock data: TODO: implement normal data. Only this should be changed


    public void switchToMainMenu(ActionEvent event){
        stageManager.switchScene(FxmlView.MAIN_MENU);
    }
    public void switchToCityMenu(String cityName){stageManager.switchScene(FxmlView.CITY_MENU, cityName);}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.stageManager=MenuApplication.getStageManager();
        departure.setCellFactory(tc -> {
            TableCell<Flight, String> cell = new TableCell<Flight, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty) ;
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (! cell.isEmpty()) {
                    String departure = cell.getItem();
                    System.out.println(departure + " cell is clicked");
                    switchToCityMenu(departure);
                }
            });
            return cell ;
        });// clickable departure
        departure.setCellFactory(tc -> {
            TableCell<Flight, String> cell = new TableCell<Flight, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty) ;
                    setText(empty ? null : item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (! cell.isEmpty()) {
                    String destination = cell.getItem();
                    System.out.println(destination + " cell is clicked");
                    switchToCityMenu(destination);
                }
            });
            return cell ;
        });// clickable destination
        data = FXCollections.observableArrayList(flightWebClient.getFlights());
        id.setCellValueFactory(new PropertyValueFactory<Flight, String>("id"));
        company.setCellValueFactory(new PropertyValueFactory<Flight, String>("company"));
        departure.setCellValueFactory(new PropertyValueFactory<Flight, String>("departure"));
        destination.setCellValueFactory(new PropertyValueFactory<Flight, String>("destination"));
        date.setCellValueFactory(new PropertyValueFactory<Flight, String>("date"));
        departureTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureTime"));
        destinationTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationTime"));
        duration.setCellValueFactory(new PropertyValueFactory<Flight, String>("duration"));
        table.getItems().setAll(data);



    }

    public void switchToCityMenu(ActionEvent event){

    }

    @Override
    public void accept(Flight flight) {

    }

    @Override
    public Consumer<Flight> andThen(Consumer<? super Flight> after) {
        return Consumer.super.andThen(after);
    }
}
