package com.server.spring.feign.client.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedPassengerResponse {
    private Long totalPassengers;
    private Long totalPages;
    private List<PassengerResponse> data;
}
