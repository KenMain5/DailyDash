package com.DailyDash.Weather.service.implementation;

import com.DailyDash.Weather.entity.City;
import com.DailyDash.Weather.entity.Weather;
import com.DailyDash.Weather.repository.WeatherRepository;
import com.DailyDash.Weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final WebClient webClient;
    private final WeatherRepository weatherRepository;

    @Value("${open-weather-APIkey}")
    private String apiKey;

    @Autowired
    public WeatherServiceImpl(WebClient.Builder webClientBuilder, WeatherRepository weatherRepository){
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org").build();
        this.weatherRepository = weatherRepository;
    }

    public Mono<String> fetchWeatherData(City city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/data/3.0/onecall")
                        .queryParam("lat", city.getLatitude())
                        .queryParam("lon", city.getLongitude())
                        .queryParam("appid", apiKey)
                        .queryParam("exclude", "minutely,hourly,daily,alerts")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
