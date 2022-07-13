package DB.client.flight;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FlightWebClient Class is class for accessing data from localhost:8080
 */
@Log4j2
public class FlightWebClient {

    private WebClient webClient;

    public FlightWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
    public FlightWebClient() {
    }

    /**
     *retrieve flights by id, empty id returns all flights
     */
    public List<Flight> getFlightsById(Long id){
        return webClient.get().uri("http://localhost:8080/flight/{id}",id)
                .retrieve()
                .bodyToFlux(Flight.class)
                .doOnError(IOException.class, e -> log.error((e.getMessage())))
                .toStream().collect(Collectors.toList());
    }

    public List<Flight> getFlightsById(){
        return webClient.get().uri("http://localhost:8080/flight")
                .retrieve()
                .bodyToFlux(Flight.class)
                .doOnError(IOException.class, e -> log.error((e.getMessage())))
                .toStream().collect(Collectors.toList());
    }


}
