package co.sobu.service;

import java.util.List;

import co.sobu.model.Food;
import co.sobu.model.ShredDto;
import co.sobu.model.ShredProgram;

public interface ShredService {
	
	ShredProgram save(int IdUser);
    List<ShredProgram> findAll();
    void delete(int idShred);
	ShredProgram  findByIdUser(int id);

}
