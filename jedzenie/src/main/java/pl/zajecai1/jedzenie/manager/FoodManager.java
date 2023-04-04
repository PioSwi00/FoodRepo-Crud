package pl.zajecai1.jedzenie.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zajecai1.jedzenie.dao.FoodRepo;
import pl.zajecai1.jedzenie.dao.entity.Food;

import java.util.Optional;

@Service
public class FoodManager {

    private final FoodRepo foodRepo;

    @Autowired
    public FoodManager(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepo.findById(id);
    }
    public Food save(Food food) {
        return foodRepo.save(food);
    }

    public void deleteFoodById(Long id) {
        foodRepo.deleteById(id);
    }
    public Iterable<Food> getAllFoods() {
        return foodRepo.findAll();
    }

}