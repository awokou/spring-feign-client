package com.server.spring.feign.client.service;

import com.server.spring.feign.client.feignclient.WebToolsFeignClient;
import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling operations related to airlines.
 */
@Service
public class WebToolsService {

    private final WebToolsFeignClient apiClient;

    /**
     * Constructs a new WebToolsService with the specified WebToolsFeignClient.
     *
     * @param apiClient the Feign client used to interact with the API
     */
    public WebToolsService(WebToolsFeignClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieves a list of all airlines.
     *
     * @return a list of AirlineResponse objects
     */
    public List<AirlineResponse> readAirlineData () {
        return apiClient.readAirLines();
    }

    /**
     * Retrieves an airline by its ID.
     *
     * @param airlineId the ID of the airline to retrieve
     * @return the AirlineResponse object for the specified airline
     */
    public AirlineResponse readAirLineById (String airlineId) {
        return apiClient.readAirLineById(airlineId);
    }
}
