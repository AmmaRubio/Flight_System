package DB.client.flight;

import DB.client.City.City;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class FlightWebClient {

    private WebClient webClient;

    public FlightWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Search by id
     *
     * @param id of flight
     * @return list of flights in DB
     */
    public List<Flight> getFlights(Long id) {
        return webClient.get().uri("http://localhost:8080/flight/{id}", id)
                .retrieve()
                .bodyToFlux(Flight.class)
                .doOnError(IOException.class, e -> log.error(e.getMessage()))
                .toStream().collect(Collectors.toList());
    }

    /**
     * @return all flights in DB
     */
    public List<Flight> getFlights() {
        return webClient.get().uri("http://localhost:8080/flight")
                .retrieve()
                .bodyToFlux(Flight.class)
                .doOnError(IOException.class, e -> log.error(e.getMessage()))
                .toStream().collect(Collectors.toList());
    }

    /**
     * @param passengerId indicates which passenger's flights to return
     * @return return list of flights
     */
    public List<Flight> getFlightsByPassengerId(long passengerId) {
        return webClient.get().uri("http://localhost:8080/passenger/{passengerId}/flight", passengerId)
                .retrieve()
                .bodyToFlux(Flight.class)
                .doOnError(IOException.class, e -> log.error(e.getMessage()))
                .toStream().collect(Collectors.toList());
    }

    public City getCityByName(String name) {
        return webClient.get().uri("http://localhost:8080/city/name/{name}", name)
                .retrieve()
                .bodyToFlux(City.class)
                .doOnError(IOException.class, e -> log.error(e.getMessage()))
                .toStream().collect(Collectors.toList()).get(0);
    }

    /**
     * Rest put request that adds the flight to the passenger`s List<Flight> flights
     * @param passengerId determines to which passenger add the flight
     * @param flight single object (not list), determines which flight to assign to passenger
     */
    public void addFlightToPassenger(Long passengerId, Flight flight){
        webClient.put().uri("http://localhost:8080/passenger/addFlight/{passengerId}") // access end point REST put
                .body(Mono.just(flight), Flight.class);// should convert object Flight to JSON body
    }
}
