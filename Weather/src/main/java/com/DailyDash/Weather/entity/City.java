package com.DailyDash.Weather.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cityName;

    private double latitude;

    private double longitude;

    @OneToOne(mappedBy = "city")
    private Weather weather;

    public City(){

    }


}
