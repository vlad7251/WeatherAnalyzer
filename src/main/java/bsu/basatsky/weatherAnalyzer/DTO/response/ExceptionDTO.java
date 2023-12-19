package bsu.basatsky.weatherAnalyzer.DTO.response;


import lombok.Value;

@Value
public class ExceptionDTO {

    String message;
    int statusCode;
    String statusMessage;
}
