package com.poecat.pogodynka.service;

import com.poecat.pogodynka.model.Weather;
import com.poecat.pogodynka.webclient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public Weather getWeather() {
        return weatherClient.getWeatherForCity("Gdańsk");
    }
}
