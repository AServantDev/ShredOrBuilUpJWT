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
public class BuildProgram extends Program {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBuild;

	
	@JoinColumn(name="User_id")
	private int buildUser;

	private double actualWeight;

	public int getIdBuild() {
		return idBuild;
	}

	public void setIdBuild(int idBuild) {
		this.idBuild = idBuild;
	}

	public int getBuildUser() {
		return buildUser;
	}

	public void setBuildUser(int buildUser) {
		this.buildUser = buildUser;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}

	public BuildProgram() {
		super();
	}

	/**
	 * @param kcalPerDay
	 * @param protPerDay
	 * @param fatPerDay
	 * @param carbPerDay
	 * @param food
	 * @param idBuild
	 * @param buildUser
	 * @param actualWeight
	 * @param buildFood
	 */
	public BuildProgram(double kcalPerDay, double protPerDay, double fatPerDay, double carbPerDay, List<Food> food,
			int idBuild, int buildUser, double actualWeight) {
		super(kcalPerDay, protPerDay, fatPerDay, carbPerDay, food);
		this.idBuild = idBuild;
		this.buildUser = buildUser;
		this.actualWeight = actualWeight;

	}

}
