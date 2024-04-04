package com.DailyDash.Weather.service;

import com.DailyDash.Weather.entity.City;
import reactor.core.publisher.Mono;

public interface WeatherService {
    public Mono<String> fetchWeatherData(City city);
}
