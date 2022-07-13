package DB.client.flight;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FlightClientConfiguration {
    @Bean
    @Lazy
    public FlightWebClient flightWebClient(WebClient webClient){
        return new FlightWebClient(webClient);
    }
    @Bean
    @ConditionalOnMissingBean
    public WebClient webClient(){return WebClient.builder().build();}
}
