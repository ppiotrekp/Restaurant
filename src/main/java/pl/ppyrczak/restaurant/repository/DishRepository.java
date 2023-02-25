package pl.ppyrczak.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ppyrczak.restaurant.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
