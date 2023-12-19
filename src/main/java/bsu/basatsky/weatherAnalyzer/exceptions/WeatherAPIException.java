package bsu.basatsky.weatherAnalyzer.exceptions;

public class WeatherAPIException extends RuntimeException{

    public WeatherAPIException() {
        super();
    }

    public WeatherAPIException(String message) {
        super(message);
    }

    public WeatherAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherAPIException(Throwable cause) {
        super(cause);
    }
}
