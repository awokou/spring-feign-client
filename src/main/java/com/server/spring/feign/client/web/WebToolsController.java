package com.server.spring.feign.client.web;

import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebToolsController {

    private final WebToolsService apiClient;

    public WebToolsController(WebToolsService apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/airline")
    public ResponseEntity<List<AirlineResponse>> readAirlineData () {
        return ResponseEntity.ok(apiClient.readAirlineData());
    }

    @GetMapping("/airlines/{airlineId}")
    public ResponseEntity<AirlineResponse> readAirLineById (@PathVariable("airlineId") String airlineId) {
        return ResponseEntity.ok(apiClient.readAirLineById(airlineId));
    }
}
