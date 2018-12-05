package co.sobu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sobu.dao.FoodDao;
import co.sobu.model.Food;

import co.sobu.service.FoodService;

@Service(value = "foodService")
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodDao foodDao;

	public List<Food> findAll() {
		List<Food> list = new ArrayList<>();
		foodDao.findAll().iterator().forEachRemaining(list::add);
		return list;

}

	@Override
	public Food save(Food food) {
		
		return foodDao.save(food);
		
	}

	
	@Override
	public void delete(int id) {
		
		foodDao.deleteById(id);
		
	}

	@Override
	public Food findOne(String foodName) {
		
		return foodDao.findByFoodName(foodName);
	}

	@Override
	public Food findById(int id) {
		return foodDao.findByIdFood(id);
	}
}
