package pl.ppyrczak.restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.ppyrczak.restaurant.enums.Meal;
import pl.ppyrczak.restaurant.model.Dish;
import pl.ppyrczak.restaurant.repository.DishRepository;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.ppyrczak.restaurant.enums.Cuisine.ITALIAN;

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
                ITALIAN,
                Meal.MAIN,
                "Sauce, Cheese, pepperoni",
                20,
                BigDecimal.valueOf(30L),
                "Good pizza"
        );
        return dish;
    }

    @Test
    void should_create_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(post(baseUrl + "/dishes")
                        .content(objectMapper.writeValueAsString(dish))
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void should_not_create_dish() throws Exception {
        Dish dish = new Dish();
        dish.setName("Pizza");
        dishRepository.save(dish);

        mockMvc.perform(post(baseUrl + "/dishes")
                        .content(objectMapper.writeValueAsString(dish))
                        .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_get_dishes() throws Exception {
        Dish dish = createDish();
        Dish dish1 = createDish();
        dishRepository.save(dish);
        dishRepository.save(dish1);

        mockMvc.perform(get(baseUrl + "/dishes?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void should_get_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);
        MvcResult mvcResult = mockMvc.perform(get(baseUrl + "/dishes/" + dish.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Dish dishTest = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Dish.class);
        assertThat(dishTest.getCuisine()).isEqualTo(ITALIAN);
        assertThat(dishTest.getName()).isEqualTo("pizza pepperoni");
        assertThat(dishTest.getDishLimit()).isEqualTo(20);
        assertThat(dishTest.getMeal()).isEqualTo(Meal.MAIN);
    }

    @Test
    void should_not_get_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);
        mockMvc.perform(get(baseUrl + "/dishes/" + dish.getId() + 11))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    void should_edit_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(put(baseUrl + "/dishes/" + dish.getId())
                .content(objectMapper.writeValueAsString(dish))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void should_create_dish_by_put() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(put(baseUrl + "/dishes/" + dish.getId()+1000)
                        .content(objectMapper.writeValueAsString(dish))
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void should_delete_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(delete(baseUrl + "/dishes/" + dish.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertEquals(dishRepository.findAll().size(), 0);
    }

    @Test
    void should_not_delete_dish() throws Exception {
        Dish dish = createDish();
        dishRepository.save(dish);

        mockMvc.perform(delete(baseUrl + "/dishes/" + dish.getId()+1))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
