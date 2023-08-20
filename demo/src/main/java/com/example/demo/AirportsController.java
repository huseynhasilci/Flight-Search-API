package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/airports")
@AllArgsConstructor
public class AirportsController {
    private final AirportsService airportsService;

    @GetMapping("/getAll")
    public List<Airports> fetchAllAirports(){
        return  airportsService.getAllAirport();
    }

    @PostMapping
    public void createNewAirports(@RequestBody Airports airports){
        airportsService.addNewAirport(airports);
    }

    @DeleteMapping(path = "/{airportId}")
    public void deleteAirports(@PathVariable("airportId") String airportId){
        airportsService.deleteAirportById(airportId);
    }

    @PutMapping(path = "/{airportId}")
    public void updateAirports(@PathVariable("airportId") String airportId,
                             @RequestBody(required = false) Airports airports){
        airportsService.updateAirportById(airportId, airports);
    }

    @GetMapping(path = "/{airportId}")
    public Airports getAirport(@PathVariable("airportId") String airportId){
        return airportsService.getAirportById(airportId);
    }
}
