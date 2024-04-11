package com.DailyDash.Weather.controller;

import com.DailyDash.Weather.entity.Weather;
import com.DailyDash.Weather.service.implementation.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherServiceImpl weatherServiceImpl;

    @Autowired
    public WeatherController(WeatherServiceImpl weatherServiceImpl) {
        this.weatherServiceImpl = weatherServiceImpl;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Weather> getWeather(){
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/testing")
    public ResponseEntity<String> giveWeatherSample(){
        return new ResponseEntity<>("it is working", HttpStatus.ACCEPTED);
    }
}
