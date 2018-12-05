package co.sobu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.sobu.model.Food;


@Repository
public interface FoodDao extends CrudRepository<Food, Integer> {
	
	Food findByFoodName(String foodName);
	 Food findByIdFood(int idFood);
}
