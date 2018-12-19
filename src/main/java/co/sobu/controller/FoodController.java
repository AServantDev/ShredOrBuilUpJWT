package co.sobu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sobu.model.ApiResponse;
import co.sobu.model.Food;
import co.sobu.model.User;
import co.sobu.model.UserDto;
import co.sobu.service.FoodService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/food")
public class FoodController {
	
	@Autowired
	private FoodService foodServ;
	
	@PostMapping("/newFood")
    public ApiResponse<Food> saveUser(@RequestBody Food food){
        return new ApiResponse<>(HttpStatus.OK.value(), "Food saved successfully.",foodServ.save(food));
    }
	
	@GetMapping("/allFood")
	public List<Food> getAllFood(){
		return (List<Food>) foodServ.findAll();
		
	}
	
	@GetMapping("getFood/{id}")
	public ResponseEntity<Food> getFood(@PathVariable(value="id") int id){
		Food food = foodServ.findById(id);
		if(food == null)
			 return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(food);
	}

}
