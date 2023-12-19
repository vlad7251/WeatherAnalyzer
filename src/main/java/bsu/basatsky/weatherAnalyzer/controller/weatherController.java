package bsu.basatsky.weatherAnalyzer.controller;

import bsu.basatsky.weatherAnalyzer.DTO.request.DateIntervalDTO;
import bsu.basatsky.weatherAnalyzer.DTO.response.AverageTemperatureDTO;
import bsu.basatsky.weatherAnalyzer.DTO.response.WeatherReadDTO;
import bsu.basatsky.weatherAnalyzer.service.WeatherDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/weather")
public class weatherController {
    private WeatherDataService weatherDataService;

    @Autowired
    public weatherController(WeatherDataService weatherDataService){
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public ResponseEntity<WeatherReadDTO> getCurrentWeather(){
        return new ResponseEntity<>(weatherDataService.getCurrentWeather(), HttpStatus.OK);
    }



    @GetMapping("/temperature")
    public ResponseEntity<AverageTemperatureDTO> getAverageDailyTemperature(@Valid @RequestBody(required = false)
                                                                                    DateIntervalDTO dateIntervalDto) {
        if (dateIntervalDto == null){
            return new ResponseEntity<>(
                    weatherDataService.getAverageTemperature(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(weatherDataService.getAverageTemperatureBetweenDates(dateIntervalDto), HttpStatus.OK);
        }
    }
}

