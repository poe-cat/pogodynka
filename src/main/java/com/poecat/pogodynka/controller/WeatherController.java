package com.poecat.pogodynka.controller;

import com.poecat.pogodynka.model.Weather;
import com.poecat.pogodynka.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public Weather getWeather() {
        return weatherService.getWeather();
    }
}
