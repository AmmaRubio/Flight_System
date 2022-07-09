import MockClasses.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableView;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AllFlightsMenuController implements Initializable {
    private final String MAINMENU_TITLE = "All flights Menu";

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
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));


            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle(MAINMENU_TITLE);
            stage.show();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
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
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("CityMenu"));


            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("City Menu"); //TODO implement name of city as city title
            stage.show();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
