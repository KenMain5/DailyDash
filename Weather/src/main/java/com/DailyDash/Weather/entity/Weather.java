package com.DailyDash.Weather.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String condition;

    private double temperature;

    private double feelsLikeTemperature;

    private LocalDateTime dateTime;

    @OneToOne
    private City city;
}
