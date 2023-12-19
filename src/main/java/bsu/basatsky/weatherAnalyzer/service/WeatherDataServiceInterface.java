package bsu.basatsky.weatherAnalyzer.service;

import bsu.basatsky.weatherAnalyzer.DTO.request.DateIntervalDTO;
import bsu.basatsky.weatherAnalyzer.DTO.response.AverageTemperatureDTO;
import bsu.basatsky.weatherAnalyzer.DTO.response.WeatherReadDTO;

public interface WeatherDataServiceInterface {
    WeatherReadDTO getCurrentWeather();

    AverageTemperatureDTO getAverageTemperature();

    AverageTemperatureDTO getAverageTemperatureBetweenDates(DateIntervalDTO dateIntervalDTO);
}
