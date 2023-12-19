package bsu.basatsky.weatherAnalyzer.entity;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_data")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 60)
    private String location;

    @Column(nullable = false)
    private Integer temperature;

    @Column(name = "wind_meters_ph", nullable = false)
    private Double windMetersPerHour;

    @Column(name = "pressure_mb", nullable = false)
    private Double pressureMB;

    @Column(nullable = false)
    private Double humidity;

    @Column(name = "weather_condition", nullable = false, length = 25)
    private String weatherCondition;

    @Column(name = "created_at")
    private Instant createdAt;

}
