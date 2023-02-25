package pl.ppyrczak.restaurant.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ppyrczak.restaurant.enums.Cuisine;
import pl.ppyrczak.restaurant.enums.Meal;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private String name;
    private Cuisine cuisine;
    private Meal meal;
    private String ingredients;
    private int limit;
    private BigDecimal price;
    private String description;

    public Dish(String imageUrl,
                String name,
                Cuisine cuisine,
                Meal meal,
                String ingredients,
                int limit,
                BigDecimal price,
                String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cuisine = cuisine;
        this.meal = meal;
        this.ingredients = ingredients;
        this.limit = limit;
        this.price = price;
        this.description = description;
    }
}
