package pl.ppyrczak.restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.ppyrczak.restaurant.enums.Cuisine;
import pl.ppyrczak.restaurant.enums.Meal;
import pl.ppyrczak.restaurant.model.Dish;
import pl.ppyrczak.restaurant.repository.DishRepository;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DishControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DishRepository dishRepository;
    private final String baseUrl = "/restaurant";

    @AfterEach
    public void tearDown() {
        dishRepository.deleteAll();
    }

    private Dish createDish() {
        Dish dish = new Dish(
                "url",
                "pizza pepperoni",
                Cuisine.ITALIAN,
                Meal.MAIN,
                "Sauce, Cheese, pepperoni",
                20,
                BigDecimal.valueOf(30L),
                "Good pizza"
        );
        return dish;
    }

    @Test
    void should_add_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(post(baseUrl + "/dishes")
                        .content(objectMapper.writeValueAsString(dish))
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void should_get_dishes() throws Exception {
        Dish dish = createDish();
        Dish dish1 = createDish();
        dishRepository.save(dish);
        dishRepository.save(dish1);

        mockMvc.perform(get(baseUrl + "/dishes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void should_get_dish() {
    }

    @Test
    void should_edit_dish() {
    }

    @Test
    void should_delete_dish() {
    }
}
