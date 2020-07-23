package com.brodacki.weatherapiwithdatabase.reposiotory;

import com.brodacki.weatherapiwithdatabase.model.newJsonModel.WeatherJsonModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WeatherRepository extends JpaRepository<WeatherJsonModel, Integer> {

}
