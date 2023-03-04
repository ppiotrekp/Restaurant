package pl.ppyrczak.restaurant.exception.runtime;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND)
public class OrderDishNotFoundException extends RuntimeException {
    public OrderDishNotFoundException(Long id) {
        super("Order dish with id " + id + " does not exist");
    }
}
