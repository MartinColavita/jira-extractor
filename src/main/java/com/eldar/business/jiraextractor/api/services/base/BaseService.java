package com.eldar.business.jiraextractor.api.services.base;

import com.eldar.business.jiraextractor.api.exceptions.customs.BadRequestException;
import com.eldar.business.jiraextractor.config.RestTemplateConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.Base64;


@Slf4j
public abstract class BaseService {

    @Autowired
    protected RestTemplateConfig restTemplateConfig;

    @Value("${jira.url}")
    protected String jiraUrl;

    @Value("${jira.username}")
    protected String jiraUsername;

    @Value("${jira.token}")
    protected String jiraToken;



    /** Creates and returns the headers required for authentication in Jira. */
    protected HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((jiraUsername + ":" + jiraToken).getBytes()));
        return headers;
    }

    /**
     * Performs a GET request to the Jira API with the provided URL and the specified response type.
     *
     * @param apiUrl       The URL of the Jira API for the GET request.
     * @param responseType The expected response type:
     *                     - For a specific type, use a concrete class.
     *                     - For a generic type (e.g., a list), use ParameterizedTypeReference.
     * @return The response of the request.
     * @throws BadRequestException If the response is not successful (status code other than 2xx).*/
    protected <T> T performGetRequest(String apiUrl, Class<T> responseType) {
        try {
            HttpHeaders headers = createHeaders();
            log.info("----> headers: {}", headers);
            log.info("----> apiUrl: {}", apiUrl);
            ResponseEntity<T> response = restTemplateConfig.restTemplate().exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), responseType);
            log.info("----> response: {}", response);
            if (!response.getStatusCode().is2xxSuccessful()) {
                log.info("----> Error response: {}", response.getStatusCode());
                throw new BadRequestException("Error making request to Jira".split(","));
            }
            return response.getBody();
        } catch (BadRequestException e) {
            log.error("Error making request to Jira", e);
            throw e;
        }
    }


    /**
     * Performs a GET request to the Jira API with the provided URL and the specified response type.
     *
     * @param apiUrl       The URL of the Jira API for the GET request.
     * @param responseType The expected response type:
     *                     - For a specific type, use a concrete class.
     *                     - For a generic type (e.g., a list), use ParameterizedTypeReference.
     * @return The response of the request.
     * @throws BadRequestException If the response is not successful (status code other than 2xx).*/
    protected <T> T performGetRequest(String apiUrl, ParameterizedTypeReference<T> responseType) {
        try {
            HttpHeaders headers = createHeaders();
            log.info("----> headers: {}", headers);
            log.info("----> apiUrl: {}", apiUrl);
            ResponseEntity<T> response = restTemplateConfig.restTemplate().exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), responseType);
            log.info("----> response: {}", response);
            if (!response.getStatusCode().is2xxSuccessful()) {
                log.info("----> Respuesta de error: {}", response.getStatusCode());
                throw new BadRequestException("Error al realizar la solicitud a Jira".split(","));
            }
            return response.getBody();
        } catch (BadRequestException e) {
            log.error("Error al realizar la solicitud a Jira", e);
            throw e;
        }
    }


}
