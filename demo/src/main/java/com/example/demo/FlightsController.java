package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/flights")
@AllArgsConstructor
public class FlightsController {

    private final FlightsService flightsService;

    @GetMapping("/getAll")
    public List<Flights> fetchAllFlights(){
        return  flightsService.getAllFlights();
    }

    @PostMapping
    public void createNewFlight(@RequestBody Flights flights){
        flightsService.addNewFlight(flights);
    }

    @DeleteMapping(path = "/{flightId}")
    public void deleteFlight(@PathVariable("flightId") String flightId){
        flightsService.deleteFlightById(flightId);
    }

    @PutMapping(path = "/{flightId}")
    public void updateFlight(@PathVariable("flightId") String flightId,
                             @RequestBody(required = false) Flights flights){
        flightsService.updateFlightById(flightId, flights);
    }

    @GetMapping(path = "/{flightId}")
    public Flights getFlight(@PathVariable("flightId") String flightId){
        return flightsService.getFlightById(flightId);
    }

    @GetMapping(value = "/getFlightsWithParameters")
    public List<Flights> getFlightsWithParameters(){ //@RequestParam String departureAirport
        return flightsService.filterFlights();
    }

    @GetMapping(value = "/getFlightsWithDepartureAirport")
    public List<Flights> getFlightsWithDepartureAirport(@RequestBody(required = true) HashMap<String, String> departureAirport){
        return flightsService.getFilterWithDepartureAirport(departureAirport);
    }

    @GetMapping(value = "/getFlightsWithArrivalAirport")
    public List<Flights> getFlightsWithArrivalAirport(@RequestBody(required = true) HashMap<String, String> arrivalAirport){
        return flightsService.getFilterWithArrivalAirport(arrivalAirport);
    }

    @GetMapping(value = "/getFlightsWithPrice")
    public List<Flights> getFlightsFilteredByPrice(@RequestBody(required = true) HashMap<String, Integer> price){
        return flightsService.getFilterWithPrice(price);
    }
}
