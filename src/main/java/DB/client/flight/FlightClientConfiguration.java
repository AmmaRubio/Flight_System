package DB.client.flight;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan("DB.client.flight")
public class FlightClientConfiguration {
    @Bean
    public FlightWebClient flightWebClient(WebClient webClient){
        return new FlightWebClient(webClient);
    }

    @Bean
    @ConditionalOnMissingBean
    public WebClient webClient(){return WebClient.builder().build();}
}
