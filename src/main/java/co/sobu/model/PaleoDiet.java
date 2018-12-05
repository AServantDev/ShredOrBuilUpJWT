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
public class PaleoDiet extends Program{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPaleo;
	
	@OneToOne
	private User paleoUser;

	public Long getIdPaleo() {
		return idPaleo;
	}

	public void setIdPaleo(Long idPaleo) {
		this.idPaleo = idPaleo;
	}

	

	public User getPaleoUser() {
		return paleoUser;
	}

	public void setPaleoUser(User paleoUser) {
		this.paleoUser = paleoUser;
	}

	

	public PaleoDiet() {
		super();
	}

	/**
	 * @param kcalPerDay
	 * @param protPerDay
	 * @param fatPerDay
	 * @param carbPerDay
	 * @param food
	 * @param idPaleo
	 * @param paleoUser
	 */
	public PaleoDiet(double kcalPerDay, double protPerDay, double fatPerDay, double carbPerDay, List<Food> food,
			Long idPaleo, User paleoUser) {
		super(kcalPerDay, protPerDay, fatPerDay, carbPerDay, food);
		this.idPaleo = idPaleo;
		this.paleoUser = paleoUser;
	}

	@Override
	public String toString() {
		return "PaleoDiet [idPaleo=" + idPaleo + ", paleoUser=" + paleoUser + "]";
	}

	

}
