package com.server.spring.feign.client.controller;

import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import com.server.spring.feign.client.service.WebToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling requests related to airlines.
 */
@RestController
@RequestMapping("/api")
public class WebToolsController {

    private final WebToolsService apiClient;

    /**
     * Constructs a new WebToolsController with the specified WebToolsService.
     *
     * @param apiClient the service used to interact with the API
     */
    public WebToolsController(WebToolsService apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieves a list of all airlines.
     *
     * @return a ResponseEntity containing a list of AirlineResponse objects
     */
    @GetMapping("/airline")
    public ResponseEntity<List<AirlineResponse>> readAirlineData () {
        return ResponseEntity.ok(apiClient.readAirlineData());
    }

    /**
     * Retrieves an airline by its ID.
     *
     * @param airlineId the ID of the airline to retrieve
     * @return a ResponseEntity containing the AirlineResponse object for the specified airline
     */
    @GetMapping("/airlines/{airlineId}")
    public ResponseEntity<AirlineResponse> readAirLineById (@PathVariable("airlineId") String airlineId) {
        return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
    }
}
