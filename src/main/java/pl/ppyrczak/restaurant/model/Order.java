package pl.ppyrczak.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long orderId;
    private LocalDateTime orderTime;
//    @OneToMany
//    @JoinColumn(name = "order_id")
//    private List<Dish> dishes;




}
