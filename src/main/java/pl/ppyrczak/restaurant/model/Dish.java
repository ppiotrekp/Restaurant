package pl.ppyrczak.restaurant.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ppyrczak.restaurant.enums.Cuisine;
import pl.ppyrczak.restaurant.enums.Meal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "imageUrl can not be blank")
    private String imageUrl;
    @NotBlank(message = "name can not be blank")
    private String name;
    @NotNull(message = "cuisine can not be null")
    private Cuisine cuisine;
    @NotNull(message = "meal can not be null")
    private Meal meal;
    @NotBlank(message = "ingredients can not be blank")
    private String ingredients;
    @NotNull(message = "limit can not be null")
    private int dishLimit;
    @NotNull(message = "price can not be null")
    private BigDecimal price;
    @NotBlank(message = "description can not be blank")
    private String description;

    public Dish(String imageUrl,
                String name,
                Cuisine cuisine,
                Meal meal,
                String ingredients,
                int dishLimit,
                BigDecimal price,
                String description) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cuisine = cuisine;
        this.meal = meal;
        this.ingredients = ingredients;
        this.dishLimit = dishLimit;
        this.price = price;
        this.description = description;
    }
}
