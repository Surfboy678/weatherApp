package com.brodacki.weatherapiwithdatabase.service;

import com.brodacki.weatherapiwithdatabase.model.WeatherForCity;
import com.brodacki.weatherapiwithdatabase.model.newJsonModel.WeatherJsonModel;
import com.brodacki.weatherapiwithdatabase.reposiotory.WeatherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static String CITY = "Warsaw";

    private WeatherRepository weatherRepository;

    @Value("${APPID}")
    private String APPID;

    public final String GET_ALL_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherForCity getWeatherJson(String city) {
        String urlToWeather = GET_ALL_URL + city + APPID;
        WeatherForCity weather = restTemplate.getForObject(urlToWeather, WeatherForCity.class);
        return weather;
    }

    public void saveWeather(){
        String urlToWeather = GET_ALL_URL + CITY + APPID;
        WeatherForCity weather = restTemplate.getForObject(urlToWeather, WeatherForCity.class);
        ModelMapper modelMapper = new ModelMapper();
        WeatherJsonModel weatherJsonModel = modelMapper.map(weather.getMain(), WeatherJsonModel.class);
        weatherRepository.save(weatherJsonModel);

    }



}


