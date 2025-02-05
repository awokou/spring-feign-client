package com.server.spring.feign.client.feignclient;

import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import com.server.spring.feign.client.dto.reponse.PaginatedPassengerResponse;
import com.server.spring.feign.client.dto.request.AirlineCreateRequest;
import com.server.spring.feign.client.dto.request.PassengerUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "webToolsFeignClient", url = "${base.url}")
public interface WebToolsFeignClient {

    @PostMapping("/airlines")
    AirlineResponse createAirline(@RequestBody AirlineCreateRequest airlineCreateRequest);

    @GetMapping("/airlines")
    List<AirlineResponse> readAirLines();

    @GetMapping("/airlines/{airlineId}")
    AirlineResponse readAirLineById(@PathVariable("airlineId") String airlineId);

    @GetMapping("/passenger")
    PaginatedPassengerResponse readPassengers(@RequestParam("size") Long size, @RequestParam("page") Long page);

    @PutMapping("/passenger/{passengerId}")
    String updatePassenger(@PathVariable("passengerId") String passengerId, @RequestBody PassengerUpdateRequest request);

    @DeleteMapping("/passenger/{passengerId}")
    String deletePassenger(@PathVariable("passengerId") String passengerId);
}
