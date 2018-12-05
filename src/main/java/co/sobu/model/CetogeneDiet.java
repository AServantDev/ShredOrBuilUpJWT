package co.sobu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class CetogeneDiet extends Program {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCetogen;
	
	@OneToOne
	private User cetoUser;
	
	public Long getIdCetogen() {
		return idCetogen;
	}
	public void setIdCetogen(Long idCetogen) {
		this.idCetogen = idCetogen;
	}
	
	
	public CetogeneDiet() {
		super();
	}

	public User getCetoUser() {
		return cetoUser;
	}
	public void setCetoUser(User cetoUser) {
		this.cetoUser = cetoUser;
	}
		
	public CetogeneDiet(double kcalPerDay, double protPerDay, double fatPerDay, double carbPerDay, List<Food> food,
			Long idCetogen, User cetoUser) {
		super(kcalPerDay, protPerDay, fatPerDay, carbPerDay, food);
		this.idCetogen = idCetogen;
		this.cetoUser = cetoUser;
	}
	
	

}
