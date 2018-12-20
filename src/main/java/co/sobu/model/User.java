package co.sobu.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import co.sobu.controller.*;
import co.sobu.service.impl.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * <b>User est la classe représentant un membre de l'API.</b>
 * <p>
 * Un User est caractérisé par les informations suivantes :
 * </p>
 * <ul>
 * <li>Un identifiant unique attribué définitivement.</li>
 * <li>Un pseudo, susceptible d'être changé.</li>
 * <li>Un nom</li>
 * <li>Un prénom</li>
 * <li>Sa taille</li>
 * <li>Son poids.</li>
 * <li>Son genre</li>
 * <li>Son email</li>
 * <li>Son mot de passe</li>
 * <li>Son coefficient sportif, qui représente son taux d'activité par semaine, il a plusieurs valeurs: 1.2, 1.375, 1.55, 1.725 et 1.9.</li>  
 * <li>Des différents programmes qu'il/elle peut suivre aux nombres de 4 : Cétogène, Paléo, Prise de masse et Sèche.</li>
 * <li>Des macros nutriments qu'il/elle doit ingérer pour garder son poids de forme: Les Kcal, les proteines, les lipides, les glucides. ces apports sont calculés automatiquement</li>
 * <li>Un prénom</li>
 * </ul>
 * 
 * 	
 * @see BuildProgram
 * @see ShredProgram
 * @see UserServiceImpl
 * 
 * @author AServantDev
 */

@Entity
@Table(name = "User")
public class User{
	
	/**
    * L'ID du User. Cet ID n'est pas modifiable.
    * 
    * @see User#getId()
    */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	/**
	 * Le programme de sèche du User, l'attribut est null à la création du user
	 * il ne peux s'inscrire qu'à un seul programme de sèche.
	 * @see ProgramController#saveShred
	 */
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="idShred")
	private ShredProgram shred;

	/**
	 * Le programme de prise de masse du User, l'attribut est null à la création du user
	 * il ne peux s'inscrire qu'à un seul programme de prise de masse.
	 * @see ProgramController#saveBuild
	 */
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="idBuild")
	private BuildProgram build;

	
	@OneToOne(mappedBy = "cetoUser", cascade=CascadeType.REMOVE)
	private CetogeneDiet ceto;

	
	@OneToOne(mappedBy = "paleoUser", cascade=CascadeType.REMOVE)
	private PaleoDiet paleo;
	
	/**
	 * Le prénom du user ,l'attribut est défini à la création du user
	 * @see UserController#saveUser
	 */
	@Column
	private String name;
	
	/**
	 * Le nom de famille du user ,l'attribut est défini à la création du user. 
	 */
	@Column
	private String lastname;
	
	/**
	 * L'age du user ,l'attribut est défini à la création du user, il servira à calculer les macros nutriments
	 * @see UserController#saveUser
	 */
	@Column
	private int age;
	
	/**
	 * La taille du user ,l'attribut est défini à la création du user, il servira à calculer les macros nutriments
	 * @see UserController#saveUser
	 */
	@Column
	private double heigth;
	
	/**
	 * Le poids du user ,l'attribut est défini à la création du user, il servira à calculer les macros nutriments
	 * @see UserController#saveUser
	 */
	@Column
	private double weight;

	
	/**
	 * Le mail du user ,l'attribut est défini à la création du user, il est unique donc deux Users ne peuvent s'inscrire avec le même mail.
	 * @see UserController#saveUser
	 */
	@Column(unique = true)
	private String email;

	/**
	 * Le mot de passe du user ,l'attribut est défini à la création du user, le mot de passe est chiffré à l'enregistrement.
	 * @see UserController#saveUser
	 * @see BCryptPasswordEncoder
	 */
	private String password;
	
	/**
	 * Les kilos calories qu'un user doit ingérer pour garder son poids de forme, elle sont calculé a la création du User en fonction d'autres attributs.
	 * @see User#age
	 * @see User#gender
	 * @see User#heigth
	 * @see User#weight
	 * @see User#coefSportif
	 * @see UserController#saveUser
	 */
	@Column
	private double KcalPerDay;
	
	/**
	 * Les proteines qu'un user doit ingérer pour garder son poids de forme, elle sont calculé a la création du User en fonction d'autres attributs.
	 * @see User#age
	 * @see User#gender
	 * @see User#heigth
	 * @see User#weight
	 * @see User#coefSportif
	 * @see UserController#saveUser
	 */
	@Column
	private double ProtPerDay;
	
	/**
	 * Les lipides calories qu'un user doit ingérer pour garder son poids de forme, elle sont calculé a la création du User en fonction d'autres attributs.
	 * @see User#age
	 * @see User#gender
	 * @see User#heigth
	 * @see User#weight
	 * @see User#coefSportif
	 * @see UserController#saveUser
	 */
	@Column
	private double FatsPerDay;
	
	/**
	 * Les glucides calories qu'un user doit ingérer pour garder son poids de forme, elle sont calculé a la création du User en fonction d'autres attributs.
	 * @see User#age
	 * @see User#gender
	 * @see User#heigth
	 * @see User#weight
	 * @see User#coefSportif
	 * @see UserController#saveUser
	 */
	@Column
	private double CarbsPerDays;
	
	/**
	 * Le genre du user ,l'attribut est défini à la création du user, il servira à calculer les macros nutriments
	 * @see UserController#saveUser
	 */
	@Column
	private String gender;
	
	/**
	 * Le coefficient sportif du user, il est calculé en fonction de l'activité sprotive d'un user ,l'attribut est défini à la création du user, il servira à calculer les macros nutriments
	 * @see UserController#saveUser
	 */
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
