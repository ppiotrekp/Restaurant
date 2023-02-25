package pl.ppyrczak.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.ppyrczak.restaurant.model.Dish;
import pl.ppyrczak.restaurant.service.DishService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("restaurant")
public class DishController {
    private final DishService dishService;

    @PostMapping("/dishes")
    public Dish addDish(@RequestBody Dish dish) {
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
    public Dish editDish(@PathVariable Long id) {
        return dishService.editDish(id);
    }

    @DeleteMapping("/dishes/{id}")
    public Dish deleteDish(@PathVariable Long id) {
        return dishService.deleteDish(id);
    }
}
