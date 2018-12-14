package co.sobu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sobu.dao.ShredDao;
import co.sobu.dao.UserDao;
import co.sobu.model.ShredDto;
import co.sobu.model.ShredProgram;
import co.sobu.model.User;
import co.sobu.service.ShredService;
import co.sobu.service.UserService;

@Service(value = "shredService")
public class ShredServiceImpl implements ShredService {

	@Autowired
	ShredDao shredDao;

	@Autowired
	UserDao userDao;

	@Autowired
	UserService userServ;

	public List<ShredProgram> findAll() {
		List<ShredProgram> list = new ArrayList<>();
		shredDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		shredDao.deleteById(id);
	}

	@Override
	public ShredProgram save(int idUser) {
		
		ShredProgram shred = new ShredProgram();

		shredDao.save(shred);
		
		User user = userServ.findById(idUser);
		shred.setShredUser(user);
		shred.setKcalPerDay(user.getKcalPerDay() - 500);
		shred.setActualWeight(user.getWeight());
		shred.setProtPerDay(user.getProtPerDay());
		shred.setFatPerDay(user.getFatsPerDay());

		double protInKcal = (user.getProtPerDay() * 4);
		double fatInKcal = (user.getFatsPerDay() * 9);

		double carbInKcal = (shred.getKcalPerDay() - (protInKcal + fatInKcal));
		double carbPerDay = carbInKcal / 4;
		shred.setCarbPerDay(carbPerDay);
		user.setShred(shred);
		
		return shredDao.save(shred);

	}

	@Override
	public ShredProgram findByIdUser(int idUser) {
		User user = userServ.findById(idUser);
		return shredDao.findByShredUser(user);
	}
}
