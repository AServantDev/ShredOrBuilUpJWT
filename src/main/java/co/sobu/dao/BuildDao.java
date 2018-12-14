package co.sobu.dao;

import org.springframework.data.repository.CrudRepository;

import co.sobu.model.BuildProgram;
import co.sobu.model.User;


public interface BuildDao extends CrudRepository<BuildProgram, Integer>{
	
	BuildProgram findByIdBuild(int idBuild);

	BuildProgram findByBuildUser(User user);

}
