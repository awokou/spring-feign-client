package com.server.spring.feign.client.dto.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerResponse {
    @JsonProperty(value = "_id")
    private String id;
    private String name;
    private Long trips;
    private AirlineResponse airline;
}
