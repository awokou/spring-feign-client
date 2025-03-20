package com.server.spring.feign.client.controller;

import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import com.server.spring.feign.client.service.WebToolsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WebToolsControllerTest {

    @Mock
    private WebToolsService apiClient;

    @InjectMocks
    private WebToolsController webToolsController;

    @BeforeEach
    void setUp() {
        apiClient = Mockito.mock(WebToolsService.class);
        webToolsController = new WebToolsController(apiClient);
    }

    @Test
    void readAirlineData_returnsListOfAirlines() {
        List<AirlineResponse> expectedAirlines = List.of(new AirlineResponse());
        when(apiClient.readAirlineData()).thenReturn(expectedAirlines);

        ResponseEntity<List<AirlineResponse>> response = webToolsController.readAirlineData();

        assertEquals(ResponseEntity.ok(expectedAirlines), response);
    }

    @Test
    void readAirlineData_returnsEmptyListWhenNoAirlines() {
        when(apiClient.readAirlineData()).thenReturn(Collections.emptyList());

        ResponseEntity<List<AirlineResponse>> response = webToolsController.readAirlineData();

        assertEquals(ResponseEntity.ok(Collections.emptyList()), response);
    }

    @Test
    void readAirLineById_returnsAirline() {
        String airlineId = "123";
        AirlineResponse expectedAirline = new AirlineResponse();
        when(apiClient.readAirLineById(airlineId)).thenReturn(expectedAirline);

        ResponseEntity<AirlineResponse> response = webToolsController.readAirLineById(airlineId);

        assertEquals(ResponseEntity.ok(expectedAirline), response);
    }
}
