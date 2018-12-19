package co.sobu.service;

import java.util.List;

import co.sobu.model.BuildProgram;

public interface BuildService {
	
	BuildProgram save(int IdUser);
    List<BuildProgram> findAll();
    void delete(int idBuild);
	BuildProgram findByIdBuild(int id);

}
