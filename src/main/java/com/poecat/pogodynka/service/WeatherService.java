package com.poecat.pogodynka.service;

import com.poecat.pogodynka.model.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "819401e47a6325ddd8df07f33a902b51";
    private RestTemplate restTemplate = new RestTemplate();

    public Weather getWeather() {
        String response = getWeatherForCity("Gdańsk");
        log.info(response);
        return null;
    }

    public String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}
