package com.brodacki.weatherapiwithdatabase.controller;

import com.brodacki.weatherapiwithdatabase.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableScheduling
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(Model model, @RequestParam(value = "city", required = false, defaultValue = "Warsaw") String city){
        model.addAttribute("weather", weatherService.getWeatherJson(city));
        if(city == null){
            return "error";
        }else
            return "weatherView";
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void saveData(){
    weatherService.saveWeather();
    }
}

