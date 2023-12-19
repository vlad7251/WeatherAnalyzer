package bsu.basatsky.weatherAnalyzer.DTO.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class DateIntervalDTO {
    @NotBlank(message = "Field cannot be empty")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date format is dd-MM-yyyy")
    String from;
    @NotBlank(message = "Field cannot be empty")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date format is dd-MM-yyyy")
    String to;
}
