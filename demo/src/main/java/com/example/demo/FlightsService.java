package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class FlightsService {

    private final FlightsRepository flightsRepository;

    public List<Flights> getAllFlights(){
        return flightsRepository.findAll();

    }

    public void deleteFlightById(String flightId){
        boolean isExists = flightsRepository.existsById(flightId);
        if(!isExists){
            throw new IllegalStateException("Flight not found");
        }
        flightsRepository.deleteById(flightId);
    }

    @Transactional
    public void updateFlightById(String flightId,
                                 Flights flight){
        Flights flights = flightsRepository.findById(flightId).orElseThrow(() -> new IllegalStateException("Flight not found"));

        if(flight.getDepartureAirport() != null && !flight.getDepartureAirport().isEmpty()){
            flights.setDepartureAirport(flight.getDepartureAirport());
        }

        if(flight.getArrivalAirport() != null && !flight.getArrivalAirport().isEmpty()){
            flights.setArrivalAirport(flight.getArrivalAirport());
        }

        if(flight.getDepartureDate() != null){
            flights.setDepartureDate(flight.getDepartureDate());
        }

        if(flight.getReturnDate() != null){
            flights.setReturnDate(flight.getReturnDate());
        }

        if(flight.getPrice() != null){
            flights.setPrice(flight.getPrice());
        }
        flightsRepository.save(flights);

    }


    public Flights getFlightById(String flightId){
        Flights flights = flightsRepository.findById(flightId).orElseThrow(() -> new IllegalStateException("Flight not found"));
        return flights;
    }

    public void addNewFlight(Flights flights) {
        flightsRepository.save(flights);
    }

    public List<Flights> filterFlights(){
        return flightsRepository.findAll();
    }

    public List<Flights> getFilterWithDepartureAirport(HashMap<String, String> departureAirport){
        List<Flights> repo =  flightsRepository.findAll();
        List<Flights> fligthList= new ArrayList<Flights>();

        for (Flights name : repo) {
            //System.out.println(departureAirport.get("departureAirport"));
            if(Objects.equals(name.getDepartureAirport(), departureAirport.get("departureAirport"))){
                //System.out.println("burada");
                fligthList.add(name);
            }
        }
        return fligthList;
    }

    public List<Flights> getFilterWithArrivalAirport(HashMap<String, String> arrivalAirport){
        List<Flights> repo =  flightsRepository.findAll();
        List<Flights> fligthList= new ArrayList<Flights>();

        for (Flights name : repo) {
            //System.out.println(departureAirport.get("departureAirport"));
            if(Objects.equals(name.getArrivalAirport(), arrivalAirport.get("arrivalAirport"))){
                //System.out.println("burada");
                fligthList.add(name);
            }
        }
        return fligthList;
    }

    public List<Flights> getFilterWithPrice(HashMap<String, Integer> price){
        List<Flights> repo =  flightsRepository.findAll();
        List<Flights> fligthList= new ArrayList<Flights>();

        for (Flights name : repo) {
            //System.out.println(departureAirport.get("departureAirport"));
            if(name.getPrice() <= price.get("price")){
                //System.out.println("burada");
                fligthList.add(name);
            }
        }
        return fligthList;
    }
}
