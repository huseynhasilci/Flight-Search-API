package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AirportsService {
    private final AirportsRepository airportsRepository;

    public List<Airports> getAllAirport(){
        return airportsRepository.findAll();

    }

    public void deleteAirportById(String airportId){
        boolean isExists = airportsRepository.existsById(airportId);
        if(!isExists){
            throw new IllegalStateException("Airport not found");
        }
        airportsRepository.deleteById(airportId);
    }

    @Transactional
    public void updateAirportById(String airportId,
                                 Airports airport){
        Airports airports = airportsRepository.findById(airportId).orElseThrow(() -> new IllegalStateException("Airport not found"));

        if(airport.getCity() != null && !airport.getCity().isEmpty()){
            airports.setCity(airport.getCity());
        }
        airportsRepository.save(airports);

    }


    public Airports getAirportById(String airportId){
        Airports airports = airportsRepository.findById(airportId).orElseThrow(() -> new IllegalStateException("Airport not found"));
        return airports;
    }

    public void addNewAirport(Airports airports) {
        airportsRepository.save(airports);
    }
}
