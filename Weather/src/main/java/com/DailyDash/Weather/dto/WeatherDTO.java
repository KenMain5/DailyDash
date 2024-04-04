package com.DailyDash.Weather.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDTO {
    private double temp;
    private double feels_like;
    private String description;
}
