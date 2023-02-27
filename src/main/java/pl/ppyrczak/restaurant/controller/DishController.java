package pl.ppyrczak.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.ppyrczak.restaurant.model.Dish;
import pl.ppyrczak.restaurant.service.DishService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurant")
public class DishController {
    private final DishService dishService;

    @PostMapping("/dishes")
    @ResponseStatus(value = CREATED)
    public Dish addDish(@Valid @RequestBody Dish dish) {
        return dishService.addDish(dish);
    }

    @GetMapping("/dishes")
    public List<Dish> getDishes() {
        return dishService.getDishes();
    }

    @GetMapping("/dishes/{id}")
    public Dish getDish(@PathVariable Long id) {
        return dishService.getDish(id);
    }

    @PutMapping("/dishes/{id}")
    public Dish editDish(@PathVariable Long id, @Valid @RequestBody Dish dishToUpdate) {
        return dishService.editDish(id, dishToUpdate);
    }

    @DeleteMapping("/dishes/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}
