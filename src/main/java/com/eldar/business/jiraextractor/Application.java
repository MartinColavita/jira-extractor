package com.eldar.business.jiraextractor;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.observation.ServerRequestObservationContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    @Bean
    ObservationRegistryCustomizer<ObservationRegistry> skipActuatorEndpointsFromObservation() {
        Set<String> excludedPaths = new HashSet<>(Arrays.asList("/actuator/**", "/swagger-ui*/**"));
        PathMatcher pathMatcher = new AntPathMatcher("/");

        return (registry) -> registry.observationConfig().observationPredicate((name, context) -> {
            if (context instanceof ServerRequestObservationContext observationContext) {
                return excludedPaths.stream().noneMatch(
                        pattern -> pathMatcher.match(pattern, observationContext.getCarrier().getRequestURI())
                );
            } else {
                return true;
            }
        });
    }


    @Bean
    ObservationRegistryCustomizer<ObservationRegistry> skipSecuritySpansFromObservation() {
        return (registry) -> registry.observationConfig().observationPredicate((name, context) ->
                !name.startsWith("spring.security"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
