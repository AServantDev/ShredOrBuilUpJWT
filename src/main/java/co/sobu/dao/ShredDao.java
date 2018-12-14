package co.sobu.dao;

import org.springframework.data.repository.CrudRepository;

import co.sobu.model.ShredProgram;
import co.sobu.model.User;


public interface ShredDao extends CrudRepository<ShredProgram, Integer> {
	
	ShredProgram findByIdShred(int idShred);
	ShredProgram findByShredUser(User shredUser);

}
