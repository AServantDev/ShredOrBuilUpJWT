package co.sobu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sobu.dao.BuildDao;
import co.sobu.dao.UserDao;
import co.sobu.model.BuildProgram;
import co.sobu.model.ShredProgram;
import co.sobu.model.User;
import co.sobu.service.BuildService;
import co.sobu.service.UserService;

@Service(value = "buildService")
public class BuildServiceImpl implements BuildService{
	
	@Autowired
	BuildDao buildDao;

	@Autowired
	UserDao userDao;

	@Autowired
	UserService userServ;
	
	public List<BuildProgram> findAll() {
		List<BuildProgram> list = new ArrayList<>();
		buildDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		buildDao.deleteById(id);
	}

	@Override
	public BuildProgram save(int idUser) {
		
		BuildProgram shred = new BuildProgram();

		buildDao.save(shred);
		
		User user = userServ.findById(idUser);
		shred.setBuildUser(user);
		shred.setKcalPerDay(user.getKcalPerDay() + 300);
		shred.setActualWeight(user.getWeight());
		shred.setProtPerDay(user.getProtPerDay());
		

		double protInKcal = (user.getProtPerDay() * 4);
		double fatInKcal = (((user.getKcalPerDay() + 300) * 30) /100);//user.getFatsPerDay() * 9
		shred.setFatPerDay(fatInKcal /9 );

		double carbInKcal = (shred.getKcalPerDay() - (protInKcal + fatInKcal));
		double carbPerDay = carbInKcal / 4;
		shred.setCarbPerDay(carbPerDay);
		user.setBuild(shred);
		
		return buildDao.save(shred);

	}
	
	@Override
	public BuildProgram findByIdUser(int idUser) {
		User user = userServ.findById(idUser);
		return buildDao.findByBuildUser(user);
	}


}
