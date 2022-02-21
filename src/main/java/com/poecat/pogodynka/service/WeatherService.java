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
        String response = weatherClient.getWeatherForCity("Gdańsk");
        log.info(response);
        response = weatherClient.getForecast(52.23, 21.01);
        log.info(response);
        return null;
    }

}
