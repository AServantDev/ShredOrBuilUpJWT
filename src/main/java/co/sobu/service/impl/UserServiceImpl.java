package co.sobu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.sobu.model.UserDto;

import co.sobu.dao.UserDao;
import co.sobu.model.User;

import co.sobu.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid email or password.");
		}
		List <GrantedAuthority> grantedAuthorities = new ArrayList <GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

//	private List<SimpleGrantedAuthority> getAuthority() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public UserDto update(UserDto userDto) {
		User user = findById(userDto.getId());
		if (user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			userDao.save(user);
		}
		return userDto;
	}

//    @Override
//    public User save(UserDto user) {
//	    User newUser = new User();
//	    
//	    newUser.setName(user.getName());
//	    newUser.setLastname(user.getLastname());
//	    newUser.setAge(user.getAge());
//	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setHeigth(user.getHeigth());
//		newUser.setWeight(user.getWeight());
//		newUser.setEmail(user.getEmail());
//		 newUser.setKcalPerDay(user.getKcalPerDay());    	
//    	 newUser.setProtPerDay(user.getProtPerDay());    	
//    	 newUser.setFatsPerDay(user.getFatsPerDay());    	
//    	 newUser.setCarbsPerDays(user.getCarbsPerDays());    	
//    	 newUser.setGender(user.getGender());    	
//    	 newUser.setCoefSportif(user.getCoefSportif());
//		
//        return userDao.save(newUser);
//        
//        
//    	  	
//    	
//    }

	@Override
	public User save(UserDto user) {

		User newUser = new User();

		newUser.setName(user.getName());
		newUser.setLastname(user.getLastname());
		newUser.setAge(user.getAge());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setHeigth(user.getHeigth());
		newUser.setWeight(user.getWeight());
		newUser.setEmail(user.getEmail());
		newUser.setGender(user.getGender());
		newUser.setCoefSportif(user.getCoefSportif());
		newUser.setUsername(user.getUsername());

		userDao.save(newUser);

		double protPerDay = (1.8 * user.getWeight());
		double protInKcal = protPerDay * 4;

		newUser.setProtPerDay(protPerDay);

		double fatPerDay = (user.getWeight());
		double fatInKcal = fatPerDay * 9;

		newUser.setFatsPerDay(fatPerDay);

		if (newUser.getGender().equals("feminin")) {

			// MB (Femme) = 9,740∗Poids (kg) + 172,9∗Taille (m) − 4,737∗Age (an) + 667,051

			double kcalPerDay = (9.740 * newUser.getWeight()) + (172.9 * newUser.getHeigth())
					- (4.737 * newUser.getAge()) + 667.051;
			newUser.setKcalPerDay(kcalPerDay * newUser.getCoefSportif());

		} else if (newUser.getGender().equals("masculin")) {

//			Formule améliorée de Harris et Benedict par Roza et Shizgal (1984) :
//			MB (Homme) = 13,707∗Poids (kg) + 492,3∗Taille (m)−6,673∗Age (an) + 77,607
			double kcalPerDay = (13.707 * newUser.getWeight()) + (492.3 * newUser.getHeigth())
					- (6.673 * newUser.getAge()) + 77.607;
			newUser.setKcalPerDay(kcalPerDay * newUser.getCoefSportif());

		}

		double carbInKcal = (newUser.getKcalPerDay() - (protInKcal + fatInKcal));
		double carbPerDay = carbInKcal / 4;
		newUser.setCarbsPerDays(carbPerDay);

		return userDao.save(newUser);

	}

	
}
