package co.sobu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

	private int id;	
	
	private ShredProgram shred;
	
	private BuildProgram build;
	
	private CetogeneDiet ceto;
	
	private PaleoDiet paleo;

	private String name;
	
	private String lastname;
	
	private int age;
	
	private double heigth;
	
	private double weight;

	private String email;

	private String password;
	
	private double KcalPerDay;
	
	private double ProtPerDay;
	
	private double FatsPerDay;
	
	private double CarbsPerDays;
	
	private String gender;
	
	private double coefSportif;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShredProgram getShred() {
		return shred;
	}

	public void setShred(ShredProgram shred) {
		this.shred = shred;
	}

	public BuildProgram getBuild() {
		return build;
	}

	public void setBuild(BuildProgram build) {
		this.build = build;
	}

	public CetogeneDiet getCeto() {
		return ceto;
	}

	public void setCeto(CetogeneDiet ceto) {
		this.ceto = ceto;
	}

	public PaleoDiet getPaleo() {
		return paleo;
	}

	public void setPaleo(PaleoDiet paleo) {
		this.paleo = paleo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getKcalPerDay() {
		return KcalPerDay;
	}

	public void setKcalPerDay(double kcalPerDay) {
		KcalPerDay = kcalPerDay;
	}

	public double getProtPerDay() {
		return ProtPerDay;
	}

	public void setProtPerDay(double protPerDay) {
		ProtPerDay = protPerDay;
	}

	public double getFatsPerDay() {
		return FatsPerDay;
	}

	public void setFatsPerDay(double fatsPerDay) {
		FatsPerDay = fatsPerDay;
	}

	public double getCarbsPerDays() {
		return CarbsPerDays;
	}

	public void setCarbsPerDays(double carbsPerDays) {
		CarbsPerDays = carbsPerDays;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getCoefSportif() {
		return coefSportif;
	}

	public void setCoefSportif(double coefSportif) {
		this.coefSportif = coefSportif;
	}
	
	
	
}
