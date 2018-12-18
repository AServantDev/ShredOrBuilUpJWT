package co.sobu.model;

import javax.persistence.OneToOne;

public class ShredDto extends Program {

	private int idShred;
	
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

	
}
