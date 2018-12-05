package co.sobu.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.sobu.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);

}
