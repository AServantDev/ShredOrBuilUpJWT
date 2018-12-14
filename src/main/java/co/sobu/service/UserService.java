package co.sobu.service;

import java.util.List;

import co.sobu.model.User;
import co.sobu.model.UserDto;

public interface UserService {
	
	    User save(UserDto user);
	    List<User> findAll();
	    void delete(int id);

	    User findOne(String username);

	    User findById(int id);

	    UserDto update(UserDto userDto);
		
		
	

}
