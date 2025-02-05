package com.server.spring.feign.client.web;

import com.server.spring.feign.client.feignclient.WebToolsFeignClient;
import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebToolsService {

    private final WebToolsFeignClient apiClient;

    public WebToolsService(WebToolsFeignClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<AirlineResponse> readAirlineData () {
        return apiClient.readAirLines();
    }

    public AirlineResponse readAirLineById (String airlineId) {
        return apiClient.readAirLineById(airlineId);
    }
}
