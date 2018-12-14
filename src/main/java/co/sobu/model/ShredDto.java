package co.sobu.model;

import javax.persistence.OneToOne;

public class ShredDto extends Program {

	private int idShred;
	
	private User shredUser;

	private double actualWeight;

	public int getIdShred() {
		return idShred;
	}

	public void setIdShred(int idShred) {
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

	
}
