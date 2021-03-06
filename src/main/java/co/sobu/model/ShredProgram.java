package co.sobu.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ShredProgram extends Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idShred;

	
	
	@JoinColumn(name="User_id")
	private int shredUser;

	private double actualWeight;
	



	public int getIdShred() {
		return idShred;
	}

	public void setIdShred(int idShred) {
		this.idShred = idShred;
	}

	public int getShredUser() {
		return shredUser;
	}

	public void setShredUser(int shredUser) {
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
			int idShred, int shredUser, double actualWeight) {
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
