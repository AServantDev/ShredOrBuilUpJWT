package co.sobu.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	
	@OneToOne(mappedBy = "shredUser", cascade=CascadeType.REMOVE)
	private ShredProgram shred;

	
	@OneToOne(mappedBy = "buildUser", cascade=CascadeType.REMOVE)
	private BuildProgram build;

	
	@OneToOne(mappedBy = "cetoUser", cascade=CascadeType.REMOVE)
	private CetogeneDiet ceto;

	
	@OneToOne(mappedBy = "paleoUser", cascade=CascadeType.REMOVE)
	private PaleoDiet paleo;
	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private int age;
	@Column
	private double heigth;
	@Column
	private double weight;

	@Column(unique = true)
	private String email;

	private String password;
	@Column
	private double KcalPerDay;
	@Column
	private double ProtPerDay;
	@Column
	private double FatsPerDay;
	@Column
	private double CarbsPerDays;
	@Column
	private String gender;
	@Column
	private double coefSportif;
	
	@Column(unique = true)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getCoefSportif() {
		return coefSportif;
	}

	public void setCoefSportif(double coefSportif) {
		this.coefSportif = coefSportif;
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

	
}
