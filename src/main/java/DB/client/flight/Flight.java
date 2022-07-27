package DB.client.flight;

import DB.client.City.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    public Flight(Long id, City departure, City destination, LocalDate date,
                  LocalTime departureTime, LocalTime destinationTime,
                  String company) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.company = company;
        this.flightDuration = Duration.between(departureTime,destinationTime);
    }

    private Long id;
    private City departure;
    private City destination;// TODO: change Class to city
    private LocalDate date;
    private LocalTime departureTime; // TODO: change naming in UML class diagram
    private LocalTime destinationTime;
    private String company;
    private Duration flightDuration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(LocalTime destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Duration getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(Duration flightDuration) {
        this.flightDuration = flightDuration;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departure='" + departure.getName() + '\'' +
                ", destination='" + destination.getName() + '\'' +
                ", date=" + date +
                ", departureTime=" + departureTime +
                ", destinationTime=" + destinationTime +
                ", company='" + company + '\'' +
                ", flightDuration=" + flightDuration +
                '}';
    }
}
