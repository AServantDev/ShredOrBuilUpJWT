package co.sobu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ShredProgram extends Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idShred;

	@JsonIgnore
	@OneToOne
	private User shredUser;

	private double actualWeight;
	



	public Long getIdShred() {
		return idShred;
	}

	public void setIdShred(Long idShred) {
		this.idShred = idShred;
	}

	public User getShredUser() {
		return shredUser;
	}

	public void setShredUser(User shredUser) {
		this.shredUser = shredUser;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}


	

	public ShredProgram() {
		super();
	}

	/**
	 * @param kcalPerDay
	 * @param protPerDay
	 * @param fatPerDay
	 * @param carbPerDay
	 * @param food
	 * @param idShred
	 * @param shredUser
	 * @param actualWeight
	 */
	public ShredProgram(double kcalPerDay, double protPerDay, double fatPerDay, double carbPerDay, List<Food> food,
			Long idShred, User shredUser, double actualWeight) {
		super(kcalPerDay, protPerDay, fatPerDay, carbPerDay, food);
		this.idShred = idShred;
		this.shredUser = shredUser;
		this.actualWeight = actualWeight;
	}

	@Override
	public String toString() {
		return "ShredProgram [idShred=" + idShred + ", shredUser=" + shredUser + ", actualWeight=" + actualWeight + "]";
	}

	

}
