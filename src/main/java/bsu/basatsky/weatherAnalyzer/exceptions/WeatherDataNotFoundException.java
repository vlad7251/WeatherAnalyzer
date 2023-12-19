package bsu.basatsky.weatherAnalyzer.exceptions;

public class WeatherDataNotFoundException extends RuntimeException{

    public WeatherDataNotFoundException() {
        super();
    }

    public WeatherDataNotFoundException(String message) {
        super(message);
    }

    public WeatherDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherDataNotFoundException(Throwable cause) {
        super(cause);
    }

}
