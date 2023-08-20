package com.example.demo;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
public class Airports {
    @Id
    private String id;
    @Getter
    private String city;
    @Getter
    private LocalDateTime created;



    public Airports(String city, LocalDateTime created) {
        this.city = city;
        this.created = created;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
