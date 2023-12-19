package bsu.basatsky.weatherAnalyzer.exceptions;

import bsu.basatsky.weatherAnalyzer.DTO.response.ExceptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({WeatherDataNotFoundException.class, InvalidDateException.class})
    public ResponseEntity<ExceptionDTO> handleWeatherDataNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(
                new ExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> parameterExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                return new ResponseEntity<>(
                        new ExceptionDTO(error.getDefaultMessage(), HttpStatus.BAD_REQUEST.value(),
                                HttpStatus.BAD_REQUEST.getReasonPhrase()),
                        HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(new ExceptionDTO("Argument validation failed", HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WeatherAPIException.class)
    public void handleWeatherAPIException(WeatherAPIException e){
        log.error(e.getMessage());
    }

}
