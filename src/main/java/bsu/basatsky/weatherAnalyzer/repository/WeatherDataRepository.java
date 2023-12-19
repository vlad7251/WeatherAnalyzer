package bsu.basatsky.weatherAnalyzer.repository;

import java.util.List;
import java.util.Optional;
import java.time.Instant;


import bsu.basatsky.weatherAnalyzer.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Integer> {

    Optional<WeatherData> findFirstByOrderByCreatedAtDesc();

    List<WeatherData> findByCreatedAtBetween(Instant startDate, Instant endDate);

}