package co.sobu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFood;

	private String foodName;
	private String foodType;
	private double kcal;
	private double proteins;
	private double fats;
	private double carbs;
	private boolean paleo;
	private boolean cetogene;

	

	public Long getIdFood() {
		return idFood;
	}

	public void setIdFood(Long idFood) {
		this.idFood = idFood;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public boolean isPaleo() {
		return paleo;
	}

	public void setPaleo(boolean paleo) {
		this.paleo = paleo;
	}

	public boolean isCetogene() {
		return cetogene;
	}

	public void setCetogene(boolean cetogene) {
		this.cetogene = cetogene;
	}

	
	

	public Food(Long idFood, String foodName, String foodType, double kcal, double proteins, double fats, double carbs,
			boolean paleo, boolean cetogene
			) {
		super();
		this.idFood = idFood;
		this.foodName = foodName;
		this.foodType = foodType;
		this.kcal = kcal;
		this.proteins = proteins;
		this.fats = fats;
		this.carbs = carbs;
		this.paleo = paleo;
		this.cetogene = cetogene;
		
		
	}

	public Food() {
		super();
	}



}
