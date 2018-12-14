package co.sobu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

public class Program {
	
	@Column
	private double kcalPerDay;
	@Column
	private double protPerDay;
	@Column
	private double fatPerDay;
	@Column
	private double carbPerDay;
	
	
	@OneToMany
	private List<Food> food;

	public double getKcalPerDay() {
		return kcalPerDay;
	}

	public void setKcalPerDay(double kcalPerDay) {
		this.kcalPerDay = kcalPerDay;
	}

	public double getProtPerDay() {
		return protPerDay;
	}

	public void setProtPerDay(double protPerDay) {
		this.protPerDay = protPerDay;
	}

	public double getFatPerDay() {
		return fatPerDay;
	}

	public void setFatPerDay(double fatPerDay) {
		this.fatPerDay = fatPerDay;
	}

	public double getCarbPerDay() {
		return carbPerDay;
	}

	public void setCarbPerDay(double carbPerDay) {
		this.carbPerDay = carbPerDay;
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public Program(double kcalPerDay, double protPerDay, double fatPerDay, double carbPerDay, List<Food> food) {
		super();
		this.kcalPerDay = kcalPerDay;
		this.protPerDay = protPerDay;
		this.fatPerDay = fatPerDay;
		this.carbPerDay = carbPerDay;
		this.food = food;
	}

	public Program() {
		super();
	}
	
	

}
