package com.poecat.pogodynka.webclient.weather;

import com.poecat.pogodynka.model.Weather;
import com.poecat.pogodynka.webclient.weather.dto.OpenWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "";
    private RestTemplate restTemplate = new RestTemplate();

    public Weather getWeatherForCity(String city) {
        OpenWeatherDto openWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherDto.class,
                city, API_KEY);

        return Weather.builder()
                .temperature(openWeatherDto.getMain().getTemp())
                .pressure(openWeatherDto.getMain().getPressure())
                .humidity(openWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod(WEATHER_URL +
                        "onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&units=metric&lang=pl&appid={apiKey}",
                String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object...objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
