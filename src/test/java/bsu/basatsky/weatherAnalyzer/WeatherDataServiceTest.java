package bsu.basatsky.weatherAnalyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import bsu.basatsky.weatherAnalyzer.DTO.response.AverageTemperatureDTO;
import bsu.basatsky.weatherAnalyzer.DTO.response.WeatherReadDTO;
import bsu.basatsky.weatherAnalyzer.entity.WeatherData;
import bsu.basatsky.weatherAnalyzer.repository.WeatherDataRepository;
import bsu.basatsky.weatherAnalyzer.service.WeatherDataService;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class WeatherDataServiceTest {

    @Mock
    private WeatherDataRepository weatherDataRepository;

    @InjectMocks
    private WeatherDataService weatherDataService;

    @Test
    public void testGetCurrentWeather() {
        WeatherData weatherData = WeatherData.builder()
                .location("Minsk").temperature(6).windMetersPerHour(10000.0).pressureMB(1013.0).humidity(65.0).weatherCondition("Sunny")
                .createdAt(Instant.now())
                .build();

        Mockito.when(weatherDataRepository.findFirstByOrderByCreatedAtDesc())
                .thenReturn(Optional.of(weatherData));

        WeatherReadDTO expected =
                new WeatherReadDTO("Minsk", 6, 10000.0, 1013.0, 65.0, "Sunny");
        WeatherReadDTO actual = weatherDataService.getCurrentWeather();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageDailyTemperature() {
        Instant now = Instant.now();

        WeatherData weatherData1 = WeatherData.builder().location("Minsk").temperature(6).windMetersPerHour(9000.0)
                .pressureMB(1017.0).humidity(66.0).weatherCondition("Sunny").createdAt( now.minus(Duration.ofDays(1)))
                .build();

        WeatherData weatherData2 = WeatherData.builder().location("Minsk").temperature(8).windMetersPerHour(6000.0)
                .pressureMB(1009.0).humidity(69.0).weatherCondition("Cloudy").createdAt(now)
                .build();

        Mockito.when(weatherDataRepository.findByCreatedAtBetween(Mockito.any(Instant.class),
                Mockito.any(Instant.class))).thenReturn(Arrays.asList(weatherData1, weatherData2));

        AverageTemperatureDTO expected = new AverageTemperatureDTO(7);
        AverageTemperatureDTO actual = weatherDataService.getAverageTemperature();

        assertEquals(expected, actual);
    }

}
