package co.sobu.model;

public class BuildDto {

	private int idBuild;

	private User buildUser;

	private double actualWeight;

	public int getIdBuild() {
		return idBuild;
	}

	public void setIdBuild(int idBuild) {
		this.idBuild = idBuild;
	}

	public User getBuildUser() {
		return buildUser;
	}

	public void setBuildUser(User buildUser) {
		this.buildUser = buildUser;
	}

	public double getActualWeight() {
		return actualWeight;
	}

	public void setActualWeight(double actualWeight) {
		this.actualWeight = actualWeight;
	}
	
	
}
