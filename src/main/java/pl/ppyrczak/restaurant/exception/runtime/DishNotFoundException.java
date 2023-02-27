package pl.ppyrczak.restaurant.exception.runtime;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND)
public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException(Long id) {
        super("Dish with id " + id + " does not exist");
    }
}
