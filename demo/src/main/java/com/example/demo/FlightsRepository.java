package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightsRepository extends MongoRepository<Flights, String> {
    List<Flights> findAllByDepartureAirport (String departureAirport);
}
