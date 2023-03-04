package pl.ppyrczak.restaurant.model;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "dish_id")
    private Long dishId;
    private Integer quantity;
    private BigDecimal price;
}
