package com.poecat.pogodynka.service;

import com.poecat.pogodynka.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private RestTemplate restTemplate;

    public Weather getWeather() {
        return null;
    }
}
