package pl.zajecai1.jedzenie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zajecai1.jedzenie.dao.entity.Food;

@Repository
public interface FoodRepo extends CrudRepository<Food, Long> {

}