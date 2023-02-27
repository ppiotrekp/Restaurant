package pl.ppyrczak.restaurant.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ppyrczak.restaurant.model.Dish;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    @Query("select d from Dish d")
    List<Dish> findAllDishes(Pageable pageable);
}
