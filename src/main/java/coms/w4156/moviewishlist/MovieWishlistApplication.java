package coms.w4156.moviewishlist;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import coms.w4156.moviewishlist.models.User;

@SpringBootApplication
public class MovieWishlistApplication {

    /**
     * Runs the service.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(MovieWishlistApplication.class, args);
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> builder.type(
                "Query",
                wiring -> wiring.dataFetcher(
                        "users",
                        env -> List.of(
                                new User("test@test.com", "Dummy User", "password"))));
    }
}
