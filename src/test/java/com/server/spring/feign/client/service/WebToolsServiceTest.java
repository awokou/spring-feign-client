package com.server.spring.feign.client.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.server.spring.feign.client.feignclient.WebToolsFeignClient;
import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WebToolsServiceTest {

    @Mock
    private WebToolsFeignClient apiClient;

    @InjectMocks
    private WebToolsService webToolsService;

    @BeforeEach
    void setUp() {
        apiClient = Mockito.mock(WebToolsFeignClient.class);
        webToolsService = new WebToolsService(apiClient);
    }

    @Test
    void readAirlineData_returnsListOfAirlines() {
        List<AirlineResponse> expectedAirlines = List.of(new AirlineResponse());
        when(apiClient.readAirLines()).thenReturn(expectedAirlines);

        List<AirlineResponse> actualAirlines = webToolsService.readAirlineData();

        assertEquals(expectedAirlines, actualAirlines);
    }

    @Test
    void readAirlineData_returnsEmptyListWhenNoAirlines() {
        when(apiClient.readAirLines()).thenReturn(Collections.emptyList());

        List<AirlineResponse> actualAirlines = webToolsService.readAirlineData();

        assertEquals(Collections.emptyList(), actualAirlines);
    }

    @Test
    void readAirLineById_returnsAirline() {
        String airlineId = "123";
        AirlineResponse expectedAirline = new AirlineResponse();
        when(apiClient.readAirLineById(airlineId)).thenReturn(expectedAirline);

        AirlineResponse actualAirline = webToolsService.readAirLineById(airlineId);

        assertEquals(expectedAirline, actualAirline);
    }

    @Test
    void readAirLineById_returnsNullWhenAirlineNotFound() {
        String airlineId = "123";
        when(apiClient.readAirLineById(airlineId)).thenReturn(null);

        AirlineResponse actualAirline = webToolsService.readAirLineById(airlineId);

        assertEquals(null, actualAirline);
    }
}
