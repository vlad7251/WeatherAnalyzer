package bsu.basatsky.weatherAnalyzer.DTO.response;

import lombok.Value;

@Value
public class WeatherReadDTO {

    String location;
    Integer temperature;
    Double windMetersPerHour;
    Double pressureMB;
    Double humidity;
    String weatherCondition;
}