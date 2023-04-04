package pl.zajecai1.jedzenie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zajecai1.jedzenie.dao.entity.Food;
import pl.zajecai1.jedzenie.manager.FoodManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodApi {

    private final FoodManager foodManager;

    @Autowired
    public FoodApi(FoodManager foodManager) {
        this.foodManager = foodManager;
    }

    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodManager.getFoodById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    @PostMapping
    public Food addFood(@RequestBody Food food) {
        return foodManager.save(food);
    }

    @PutMapping("/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food updatedFood) {
        updatedFood.setId(id);
        return foodManager.save(updatedFood);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodManager.deleteFoodById(id);
    }

    @GetMapping
    public Iterable<Food> getAllFoods() {
        return foodManager.getAllFoods();
    }
}