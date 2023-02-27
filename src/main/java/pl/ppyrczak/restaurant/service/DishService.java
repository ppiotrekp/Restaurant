package pl.ppyrczak.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.ppyrczak.restaurant.model.Dish;
import pl.ppyrczak.restaurant.repository.DishRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public List<Dish> getDishes() {
        return dishRepository.findAll();
    }

    public Dish getDish(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Dish not found"));
    }

    public Dish editDish(Long id, Dish dishToUpdate) {
        return dishRepositor
    }

    public void deleteDish(Long id) {
        if (!dishRepository.findById(id).isPresent())
            throw new RuntimeException("Dish does not exist");
        dishRepository.deleteById(id);
    }
}
