package pl.ppyrczak.restaurant.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dish_id")
    private Long dishId;
    private Integer quantity;
    private BigDecimal price;
}
