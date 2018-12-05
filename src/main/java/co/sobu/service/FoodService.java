package co.sobu.service;

import java.util.List;

import co.sobu.model.Food;

public interface FoodService {
	
	Food save(Food food);
    List<Food> findAll();
    void delete(int id);

    Food findOne(String foodName);
    Food findById(int id);

}
