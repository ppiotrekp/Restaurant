package pl.ppyrczak.restaurant.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.ppyrczak.restaurant.exception.model.ApiException;
import pl.ppyrczak.restaurant.exception.runtime.DishNotFoundException;
import pl.ppyrczak.restaurant.exception.runtime.OrderDishNotFoundException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {DishNotFoundException.class, OrderDishNotFoundException.class})
    public ResponseEntity<Object> handleDishNotFoundException(DishNotFoundException e) {
        HttpStatus httpStatus = NOT_FOUND;
        ApiException apiException = new ApiException(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }
}
