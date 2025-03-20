package com.server.spring.feign.client.feignclient;

import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import com.server.spring.feign.client.dto.reponse.PaginatedPassengerResponse;
import com.server.spring.feign.client.dto.request.AirlineCreateRequest;
import com.server.spring.feign.client.dto.request.PassengerUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Feign client interface for interacting with the Web Tools API.
 */
@FeignClient(name = "webToolsFeignClient", url = "${base.url}")
public interface WebToolsFeignClient {

    /**
     * Creates a new airline.
     *
     * @param airlineCreateRequest the request object containing airline details
     * @return the created AirlineResponse object
     */
    @PostMapping("/airlines")
    AirlineResponse createAirline(@RequestBody AirlineCreateRequest airlineCreateRequest);

    /**
     * Retrieves a list of all airlines.
     *
     * @return a list of AirlineResponse objects
     */
    @GetMapping("/airlines")
    List<AirlineResponse> readAirLines();

    /**
     * Retrieves an airline by its ID.
     *
     * @param airlineId the ID of the airline to retrieve
     * @return the AirlineResponse object for the specified airline
     */
    @GetMapping("/airlines/{airlineId}")
    AirlineResponse readAirLineById(@PathVariable("airlineId") String airlineId);

    /**
     * Retrieves a paginated list of passengers.
     *
     * @param size the number of passengers per page
     * @param page the page number to retrieve
     * @return a PaginatedPassengerResponse object containing the passengers
     */
    @GetMapping("/passenger")
    PaginatedPassengerResponse readPassengers(@RequestParam("size") Long size, @RequestParam("page") Long page);

    /**
     * Updates a passenger's information.
     *
     * @param passengerId the ID of the passenger to update
     * @param request the request object containing updated passenger details
     * @return a string message indicating the result of the update operation
     */
    @PutMapping("/passenger/{passengerId}")
    String updatePassenger(@PathVariable("passengerId") String passengerId, @RequestBody PassengerUpdateRequest request);

    /**
     * Deletes a passenger by their ID.
     *
     * @param passengerId the ID of the passenger to delete
     * @return a string message indicating the result of the delete operation
     */
    @DeleteMapping("/passenger/{passengerId}")
    String deletePassenger(@PathVariable("passengerId") String passengerId);
}
