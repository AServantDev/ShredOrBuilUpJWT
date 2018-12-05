package co.sobu.controller;

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

import java.util.List;
import co.sobu.service.UserService;

import co.sobu.model.ApiResponse;
import co.sobu.model.User;
import co.sobu.model.UserDto;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/newUser")
    public ApiResponse<User> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }
	
	@GetMapping("/allUser")
		public List<User> allUser(){
			return (List<User>) userService.findAll();
		}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") int id){
		System.out.println(id);
		User user = userService.findById(id);
		if(user == null)
			 return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(user);
	}
	

}
